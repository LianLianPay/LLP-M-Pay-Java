package com.llpay.client.vo;

/**
 * 通知响应信息
 * 
 * @author guoyx
 * 
 */
public class RetBean{

    private String ret_code;

    private String ret_msg;

    public String getRet_code()
    {
        return ret_code;
    }

    public void setRet_code(String ret_code)
    {
        this.ret_code = ret_code;
    }

    public String getRet_msg()
    {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg)
    {
        this.ret_msg = ret_msg;
    }

}
