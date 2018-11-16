package com.llpay.client.pay;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.llpay.client.config.PartnerConfig;
import com.llpay.client.config.ServerURLConfig;
import com.llpay.client.conn.HttpRequestSimple;
import com.llpay.client.utils.LLPayUtil;
import com.llpay.client.vo.OrderInfo;
import com.llpay.client.vo.PaymentInfo;

/**
* 调用连连支付WEB支付服务
* @author guoyx e-mail:guoyx@lianlian.com
* @date:2013-6-25 下午01:41:15
* @version :1.0
*
*/
public class ToPayServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        doPost(req, resp);
    }

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        // 创建订单
        OrderInfo order = createOrder(req);
        RequestDispatcher dispatcher = null;
		try {
			plainPay(req, order);
		} catch (Exception e) {
			dispatcher = req.getRequestDispatcher("/error.jsp");
			dispatcher.forward(req, resp);
		}
		dispatcher = req.getRequestDispatcher("/gotoPlainPay.jsp");
        dispatcher.forward(req, resp);
    }


    /**
     * 根据连连支付风控部门要求的参数进行构造风控参数
     * @return
     */
    private String createRiskItem()
    {
        JSONObject riskItemObj = new JSONObject();
        riskItemObj.put("user_info_full_name", "你好");
        riskItemObj.put("frms_ware_category", "1999");
        return riskItemObj.toString();
    }

    /**
	 * 普通支付处理
	 * 
	 * @param req
	 * @param order
	 * @throws Exception
	 */
	private void plainPay(HttpServletRequest req, OrderInfo order) throws Exception
    {
        // 构造支付请求对象
        PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setApi_version(PartnerConfig.VERSION);
        paymentInfo.setOid_partner(PartnerConfig.OID_PARTNER);
        paymentInfo.setSign_type(PartnerConfig.SIGN_TYPE);
        paymentInfo.setBusi_partner(PartnerConfig.BUSI_PARTNER);
        paymentInfo.setNo_order(order.getNo_order());
        paymentInfo.setDt_order(order.getDt_order());
        paymentInfo.setName_goods(order.getName_goods());
        paymentInfo.setInfo_order(order.getInfo_order());
        paymentInfo.setMoney_order(order.getMoney_order());
        paymentInfo.setNotify_url(PartnerConfig.NOTIFY_URL);
        paymentInfo.setUrl_return(PartnerConfig.URL_RETURN);
		paymentInfo.setValid_order("30");// 单位分钟，可以为空，默认30分钟
		paymentInfo.setTime_stamp(LLPayUtil.getCurrentDateTimeStr());
        paymentInfo.setRisk_item(createRiskItem());
		paymentInfo.setFlag_chnl("3");//2 web 、3 wap 
		paymentInfo.setFlag_pay_product(req.getParameter("flag_pay_product"));//0 快捷、1 认证、2 网银、5新认证支付

        paymentInfo.setUser_id(req.getParameter("user_id"));
		paymentInfo.setCard_no(req.getParameter("card_no"));
		paymentInfo.setAcct_name(req.getParameter("acct_name"));
		paymentInfo.setId_type("0");
		paymentInfo.setId_no(req.getParameter("id_no"));
		//paymentInfo.setBind_mob(req.getParameter("bind_mob"));
		paymentInfo.setBank_code(req.getParameter("bank_code"));
		paymentInfo.setCard_type(req.getParameter("card_type"));
		
		
        // 加签名
        String sign = LLPayUtil.addSign(JSON.parseObject(JSON
                .toJSONString(paymentInfo)), PartnerConfig.TRADER_PRI_KEY,
                "");
        paymentInfo.setSign(sign);

		String resJSON = HttpRequestSimple.getInstance().postSendHttp(ServerURLConfig.BILL_CREATE_URL, JSON.toJSONString(paymentInfo));
		System.out.println("创单请求响应报文[" + resJSON + "]");

		JSONObject payDataBean = JSON.parseObject(resJSON);
		if(!"0000".equals(payDataBean.getString("ret_code"))){
			System.out.println("创单失败");
			throw new Exception("创单失败");
		}

		if (!LLPayUtil.checkSign(resJSON, PartnerConfig.YT_PUB_KEY, "")) {
			System.out.println("签名验证失败");
			throw new Exception("创单失败/创单签名验证失败");
		}


		// do update pay message
		// post gateway_url
		req.setAttribute("gateway_url", payDataBean.getString("gateway_url"));
    }

    /**
     * 模拟商户创建订单
     * @param req
     * @return
     */
    private OrderInfo createOrder(HttpServletRequest req)
    {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setNo_order(LLPayUtil.getCurrentDateTimeStr());
        orderInfo.setDt_order(LLPayUtil.getCurrentDateTimeStr());
        orderInfo.setMoney_order(req.getParameter("money_order"));
        orderInfo.setName_goods(req.getParameter("name_goods"));
        orderInfo.setInfo_order("用户购买" + req.getParameter("name_goods"));
        return orderInfo;
    }

}
