package com.aml.core.config.beetl;

import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

import com.aml.core.util.ToolUtil;


/**
 * beetl全局工具配置扩展
 */
public class BeetlConfiguration extends BeetlGroupUtilConfiguration {

	/**
	 * 扩展其它全局配置 方便开发
	 */
	@Override
	public void initOther() {
		groupTemplate.registerFunctionPackage("tool", new ToolUtil());

	}
}
