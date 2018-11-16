package com.llpay.client.enums;

/**
* 支付结果枚举
* @author guoyx
* @date:May 13, 2013 8:22:15 PM
* @version :1.0
*
*/
public enum PayResultEnum
{

    SUCCESS("SUCCESS", "支付成功"), PROCESSING("PROCESSING", "支付处理中"), FAILURE(
            "FAILURE", "支付失败"), REFUND("REFUND", "已退款");

    private final String code;
    private final String msg;

    PayResultEnum(String code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 判断支付结果代码合法性
     * @param code
     * @return
     */
    public static boolean isPayResult(String code)
    {
        for (PayResultEnum v : PayResultEnum.values())
        {
            if (v.getCode().equals(code))
            {
                return true;
            }
        }
        return false;
    }
    /**
     * 根据编码获取信息
     * @param code
     * @return
     */
    public static String getMsgByCode(String code)
    {
        for (PayResultEnum v : PayResultEnum.values())
        {
            if (v.getCode().equals(code))
            {
                return v.getMsg();
            }
        }
        return "未知结果";
    }
    public String getCode()
    {
        return code;
    }

    public String getMsg()
    {
        return msg;
    }
}
