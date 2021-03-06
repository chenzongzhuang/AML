package com.aml.core.config.beetl;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.aml.core.util.ToolUtil;


/**
 * beetl 相关配置信息获取
 */
@Configuration
@ConfigurationProperties(prefix = BeetlProperties.BEETLCONF_PREFIX)
public class BeetlProperties {
	
	 protected static final String BEETLCONF_PREFIX = "beetl";

	 private String delimiterStatementStart;

	 private String delimiterStatementEnd;
	 
	 private String resourceTagroot;
	 
	 private String resourceTagsuffix;
	 
	 @Value("${spring.mvc.view.prefix}")
	 private String prefix;
	 @Value("${spring.mvc.view.suffix}")
	 private String suffix;
	 
	 /**
	  * 定义beetl配置
	  * @return
	  */
	 public Properties getProperties(){
		 Properties properties = new Properties();
		 if(ToolUtil.isNotEmpty(delimiterStatementStart)){
			 if(delimiterStatementStart.startsWith("\\")){
				 delimiterStatementStart = delimiterStatementStart.substring(1);
			 }
			 properties.setProperty("DELIMITER_STATEMENT_START",delimiterStatementStart);
		 }
		 if(ToolUtil.isNotEmpty(delimiterStatementEnd)){
			 properties.setProperty("DELIMITER_STATEMENT_END",delimiterStatementEnd);
		 }else{
			 properties.setProperty("DELIMITER_STATEMENT_END","null");
		 }
		 if(ToolUtil.isNotEmpty(resourceTagroot)){
			 properties.setProperty("RESOURCE.tagRoot",resourceTagroot);
		 }
		 if(ToolUtil.isNotEmpty(resourceTagsuffix)){
			 properties.setProperty("RESOURCE.tagSuffix",resourceTagsuffix);
		 }
		 return properties;
	 }

	public String getDelimiterStatementStart() {
		return delimiterStatementStart;
	}

	public void setDelimiterStatementStart(String delimiterStatementStart) {
		this.delimiterStatementStart = delimiterStatementStart;
	}

	public String getDelimiterStatementEnd() {
		return delimiterStatementEnd;
	}

	public void setDelimiterStatementEnd(String delimiterStatementEnd) {
		this.delimiterStatementEnd = delimiterStatementEnd;
	}

	public String getResourceTagroot() {
		return resourceTagroot;
	}

	public void setResourceTagroot(String resourceTagroot) {
		this.resourceTagroot = resourceTagroot;
	}

	public String getResourceTagsuffix() {
		return resourceTagsuffix;
	}

	public void setResourceTagsuffix(String resourceTagsuffix) {
		this.resourceTagsuffix = resourceTagsuffix;
	}

	public String getPrefix() {
		return prefix;
	}
	
	public String getSuffix(){
		return suffix;
	}
	   
}
