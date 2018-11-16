package com.llpay.client.vo;

import java.io.Serializable;

/**
* 支付信息bean
* @author guoyx
* @date:Jun 24, 2013 3:25:29 PM
* @version :1.0
*
*/
public class ToPayInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    // 商户提交参数
	/** 商户编号 . */
	private String oid_partner;

	/** 版本号 . */
	private String api_version;

	/** 签名方式 . */
	private String sign_type;

	/** 请求参数签名 . */
	private String sign;

	private String user_id;

	private String token;

	private String no_order;
	
	private String money_order;

	private String custom;
	
	public String getOid_partner() {
		return oid_partner;
	}

	public void setOid_partner(String oid_partner) {
		this.oid_partner = oid_partner;
	}

	public String getApi_version() {
		return api_version;
	}

	public void setApi_version(String api_version) {
		this.api_version = api_version;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public String getNo_order() {
		return no_order;
	}


	public void setNo_order(String no_order) {
		this.no_order = no_order;
	}

	public String getCustom() {
		return custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}

	public String getMoney_order() {
		return money_order;
	}

	public void setMoney_order(String money_order) {
		this.money_order = money_order;
	}


}
