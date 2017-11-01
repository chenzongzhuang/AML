package com.aml.common.toolbox;

import com.alibaba.fastjson.JSON;

/**
 * ajax返回结果对象
 */
public class AjaxResult {

	// 返回状态码   (默认1:成功,其它:失败)
	private int code = 1;
	
	// 返回的中文消息
	private String message;
	
	// 成功时携带的数据
	private Object data;
	
	public int getCode() {
		return code;
	}
	
	public AjaxResult setCode(int code) {
		this.code = code;
		return this;
	}
	
	public String getMessage() {
		return message;
	}
	
	public AjaxResult setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public Object getData() {
		return data;
	}
	
	public AjaxResult setData(Object data) {
		this.data = data;
		return this;
	}
	
	public AjaxResult addSuccess(String message) {
		this.message = message;
		this.code = 1;
		this.data = null;
		return this;
	}
	
	public AjaxResult addError(String message) {
		this.message = message;
		this.code = 999;
		this.data = null;
		return this;
	}
	
	public AjaxResult addFail(String message) {
		this.message = message;
		this.code = 999;
		this.data = null;
		return this;
	}
	
	public AjaxResult addWarn(String message) {
		this.message = message;
		this.code = 333;
		this.data = null;
		return this;
	}
	
	public AjaxResult success(Object data) {
		this.message = "success";
		this.data = data;
		this.code = 1;
		return this;
	}
	
	public boolean isSuccess() {
		return getCode() == 1;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
		
}
