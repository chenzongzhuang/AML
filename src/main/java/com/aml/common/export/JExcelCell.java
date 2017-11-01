package com.aml.common.export;

import jxl.write.WritableCellFormat;

/**
 * <p>Title:  上海银行商户管理系统</p>
 * <p>Description: Excel导出时，定义列的对象</p>
 * <p>采用模板生成的excel文件，构造函数不要列标题</p>
 * <p>Company: 上海恩梯梯数据晋恒软件有限公司</p>
 * @author CJUN
 * @version 1.0
 */
public class JExcelCell {

	//列标题
	private String dataIndex = "";
	//列数据
	private String dataName = "";
	//数据格式
	private WritableCellFormat format = null;
	//数据位置
	private String position = "";
	//列宽度
	private int width = 15 ;
	
	//列格式
	private WritableCellFormat titleFormat = null;

	public JExcelCell(String dataName){
		this.dataName = dataName;
	}
	//CSV导出用,需要标题和内容
	public JExcelCell(String dataIndex,String dataName){
		this.dataName = dataName;
		this.dataIndex = dataIndex;
	}
	
	public JExcelCell(String dataName,int width){
		this.dataName = dataName;
		this.width = width;
	}
	
	public JExcelCell(String dataName,WritableCellFormat format){
		this.dataName = dataName;
		this.format = format;
	}
	
	public JExcelCell(String dataName,WritableCellFormat format,String pos){
		this.dataName = dataName;
		this.format = format;
		this.position = pos;
	}
	
	//采用模板方式生成的excel，不需要dataIndex列标题
	public JExcelCell(String dataName,WritableCellFormat format,String pos,int width){
		this.dataName = dataName;
		this.format = format;
		this.position = pos;
		this.width = width;
	}
	
	//不采用模板方式生成
	public JExcelCell(String dataIndex,String dataName,WritableCellFormat format,String pos,int width){
		this.dataIndex = dataIndex;
		this.dataName = dataName;
		this.format = format;
		this.position = pos;
		this.width = width;
	}
	
	public JExcelCell(String dataIndex,String dataName,WritableCellFormat format,String pos,WritableCellFormat titleFormat){
		this.dataIndex = dataIndex;
		this.dataName = dataName;
		this.format = format;
		this.position = pos;
		this.width = width;
		this.titleFormat = titleFormat;
	}
	
	public String getDataIndex() {
		return dataIndex;
	}
	public void setDataIndex(String dataIndex) {
		this.dataIndex = dataIndex;
	}
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public WritableCellFormat getFormat() {
		return format;
	}
	public void setFormat(WritableCellFormat format) {
		this.format = format;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	public WritableCellFormat getTitleFormat() {
		return titleFormat;
	}

	public void setTitleFormat(WritableCellFormat titleFormat) {
		this.titleFormat = titleFormat;
	}
}
