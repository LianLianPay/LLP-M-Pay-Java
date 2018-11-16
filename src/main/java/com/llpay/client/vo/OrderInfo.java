package com.llpay.client.vo;

import java.io.Serializable;

/**
 * 商户订单信息
 * 
 * @version V1.0
 * @author chencheng@yintong.com.cn
 * @Date 2017年8月16日 下午2:57:07
 * @since JDK 1.6
 */
public class OrderInfo implements Serializable{
    private static final long serialVersionUID = 1L;

	/** 商户编号 . */
	private String oid_partner;

	/** 签名方式 . */
	private String sign_type;

	/** 请求参数签名 . */
	private String sign;

	/** 版本号 . */
	private String api_version;

	/** 请求时间戳 . */
	private String time_stamp; // 时间 yyyyMMddHHmmss

	private String user_id;
	private String no_order; // 商户唯一订单号

	private String dt_order; // 商户订单时间

	private String name_goods; // 商品名称

	private String info_order; // 订单描述

	private String money_order; // 交易金额

	private String currency_order;// 交易币种

	private String currency_settle;// 结算币种

	public String getOid_partner() {
		return oid_partner;
	}

	public void setOid_partner(String oid_partner) {
		this.oid_partner = oid_partner;
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getNo_order()
    {
        return no_order;
    }

    public void setNo_order(String no_order)
    {
        this.no_order = no_order;
    }

    public String getDt_order()
    {
        return dt_order;
    }

    public void setDt_order(String dt_order)
    {
        this.dt_order = dt_order;
    }

    public String getName_goods()
    {
        return name_goods;
    }

    public void setName_goods(String name_goods)
    {
        this.name_goods = name_goods;
    }

    public String getInfo_order()
    {
        return info_order;
    }

    public void setInfo_order(String info_order)
    {
        this.info_order = info_order;
    }

    public String getMoney_order()
    {
        return money_order;
    }

    public void setMoney_order(String money_order)
    {
        this.money_order = money_order;
    }

	/**
	 * @return the currency_order
	 */
	public String getCurrency_order() {
		return currency_order;
	}

	/**
	 * @param currency_order the currency_order to set
	 */
	public void setCurrency_order(String currency_order) {
		this.currency_order = currency_order;
	}

	/**
	 * @return the currency_settle
	 */
	public String getCurrency_settle() {
		return currency_settle;
	}

	/**
	 * @param currency_settle the currency_settle to set
	 */
	public void setCurrency_settle(String currency_settle) {
		this.currency_settle = currency_settle;
	}

}
