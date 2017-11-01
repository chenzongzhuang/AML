package com.aml.sys.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <p>
 * 操作日志记录表
 * </p>
 *
 */
@TableName("login_log")
public class LoginLog extends Model<LoginLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 日志名称
     */
	private String logname;
    /**
     * 管理员id
     */
	private Integer userid;
    /**
     * 创建时间
     */
	private Timestamp createtime;
    /**
     * 是否执行成功
     */
	private String succeed;
    /**
     * 具体消息
     */
	private String message;
    /**
     * 登录ip
     */
	private String ip;
	/*
	 * 操作地址
	 */
	private String url;
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getSucceed() {
		return succeed;
	}

	public void setSucceed(String succeed) {
		this.succeed = succeed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "LoginLog{" +
			"id=" + id +
			", logname=" + logname +
			", userid=" + userid +
			", createtime=" + createtime +
			", succeed=" + succeed +
			", message=" + message +
			", ip=" + ip +
			"}";
	}
}
