package com.aml.common.export;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 导出EXCEL工具配置常量类
 * @author ljt
 * @date 2014/07/03
 */
public class ExcelConst {
	
	private static Logger logger = LoggerFactory.getLogger(ExcelConst.class);

	public static int defaultRowHeight = 450; //默认行高
	public static int defaultColumneWidth = 28; //默认列宽
	
	public static String defaultXmlFileDir = ""; //默认的xml文件目录
	
	public static int defaultFontSize = 12;//默认字体大小
	public static String defaultFontType = "仿宋_GB2312";//默认字体类型
	
}
