package com.llpay.client.enums;

/**
* 签名方式枚举
* @author guoyx
* @date:May 13, 2013 8:22:15 PM
* @version :1.0
*
*/
public enum SignTypeEnum
{

    RSA("RSA", "RSA签名"),
    MD5("MD5", "MD5签名");

    private final String code;
    private final String msg;

    SignTypeEnum(String code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public String getCode()
    {
        return code;
    }

    public String getMsg()
    {
        return msg;
    }
    public static boolean isSignType(String code)
    {
        for (SignTypeEnum s : SignTypeEnum.values())
        {
            if (s.getCode().equals(code))
            {
                return true;
            }
        }
        return false;
    }
}
