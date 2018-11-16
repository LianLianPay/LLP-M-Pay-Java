package com.llpay.client.vo;

import java.io.Serializable;

/**
* 支付信息bean
* @author guoyx
* @date:Jun 24, 2013 3:25:29 PM
* @version :1.0
*
*/
public class PaymentInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    
	private String sign_type;

	private String sign;

	private String correlationID;
	
	private String req_ip;
	
	private String api_version; // api版本号

	private String time_stamp; // 时间 yyyyMMddHHmmss

    
    // 商户提交参数
	private String platform;//平台来源标示
	
	private String oid_partner; // 商户编号
	
	private String user_id; // 用户编号
	
	private String no_order; // 商户唯一订单号
	
	private String busi_partner;//商户业务类型，虚拟商品销售：101001 ,实物商品销售：109001
	
	private String dt_order; // 商户订单时间yyyyMMddHHmmss
	
	private String name_goods;//商品名称
	
	private String info_order;//订单描述
	
	private String money_order;//交易金额
	
	private String notify_url;//服务器异步通知地址
	
	private String valid_order;//订单有效期
	
	private String shareing_data;//分账信息数据
	
	private String risk_item;//风险控制参数
	
	private String flag_pay_product;//支付产品标识
	
	private String flag_chnl;//应用渠道
	
	private String id_type;//证件类型
	
	private String id_no;//证件号码
	
	private String acct_name;//银行账号姓名
	
	private String card_no;//银行卡号
	
	private String bind_mob;//绑定手机号
	
	private String no_agree;//签议协议号
	
	private String back_url;// 银行卡号前置，需要修改卡号时，用户点击返回的url链接地址

	private String url_return;// 支付完成返回地址

	private String bank_code;// 支付完成返回地址
	
	private String card_type;// 支付完成返回地址

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getOid_partner() {
		return oid_partner;
	}

	public void setOid_partner(String oid_partner) {
		this.oid_partner = oid_partner;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getNo_order() {
		return no_order;
	}

	public void setNo_order(String no_order) {
		this.no_order = no_order;
	}

	public String getBusi_partner() {
		return busi_partner;
	}

	public void setBusi_partner(String busi_partner) {
		this.busi_partner = busi_partner;
	}

	public String getDt_order() {
		return dt_order;
	}

	public void setDt_order(String dt_order) {
		this.dt_order = dt_order;
	}

	public String getName_goods() {
		return name_goods;
	}

	public void setName_goods(String name_goods) {
		this.name_goods = name_goods;
	}

	public String getInfo_order() {
		return info_order;
	}

	public void setInfo_order(String info_order) {
		this.info_order = info_order;
	}

	public String getMoney_order() {
		return money_order;
	}

	public void setMoney_order(String money_order) {
		this.money_order = money_order;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getValid_order() {
		return valid_order;
	}

	public void setValid_order(String valid_order) {
		this.valid_order = valid_order;
	}

	public String getShareing_data() {
		return shareing_data;
	}

	public void setShareing_data(String shareing_data) {
		this.shareing_data = shareing_data;
	}

	public String getRisk_item() {
		return risk_item;
	}

	public void setRisk_item(String risk_item) {
		this.risk_item = risk_item;
	}

	public String getFlag_pay_product() {
		return flag_pay_product;
	}

	public void setFlag_pay_product(String flag_pay_product) {
		this.flag_pay_product = flag_pay_product;
	}

	public String getFlag_chnl() {
		return flag_chnl;
	}

	public void setFlag_chnl(String flag_chnl) {
		this.flag_chnl = flag_chnl;
	}

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	public String getId_no() {
		return id_no;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	public String getAcct_name() {
		return acct_name;
	}

	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getBind_mob() {
		return bind_mob;
	}

	public void setBind_mob(String bind_mob) {
		this.bind_mob = bind_mob;
	}

	public String getNo_agree() {
		return no_agree;
	}

	public void setNo_agree(String no_agree) {
		this.no_agree = no_agree;
	}

	public String getBack_url() {
		return back_url;
	}

	public void setBack_url(String back_url) {
		this.back_url = back_url;
	}

	public String getUrl_return() {
		return url_return;
	}

	public void setUrl_return(String url_return) {
		this.url_return = url_return;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getCorrelationID() {
		return correlationID;
	}

	public void setCorrelationID(String correlationID) {
		this.correlationID = correlationID;
	}

	public String getReq_ip() {
		return req_ip;
	}

	public void setReq_ip(String req_ip) {
		this.req_ip = req_ip;
	}

	public String getApi_version() {
		return api_version;
	}

	public void setApi_version(String api_version) {
		this.api_version = api_version;
	}

	public String getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}
	
}
