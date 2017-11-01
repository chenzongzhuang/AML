package com.aml.common.export;

import java.util.ArrayList;
import java.util.List;

public class ExcelNode {

	private boolean combineFlg = false; //是否需要合并的标志
	
	private boolean columnTitleFlg = false; //一维表表头
	
	private int combineStColumn = 0; //合并开始的列
	
	private int combineStRow = 0; //合并开始的行
	
	private int combineEndColumn = 0; //合并结束的列
	
	private int combineEndRow = 0; //合并结束的行
	
	private int locationColumn = 0; //坐标列
	
	private int locationRow = 0; //坐标行
	
	private String css = ""; //样式
	
	private String text = "";//具体静态内容
	
	private List<String> objField = new ArrayList<String>(); //对象域映射
	
	private String titleCss = ""; //一维表表头样式
	
	private boolean lowTag = false;
	
	private String dtlOrgTp = "";
	
	public boolean isCombineFlg() {
		return combineFlg;
	}

	public void setCombineFlg(boolean combineFlg) {
		this.combineFlg = combineFlg;
	}

	public int getCombineStColumn() {
		return combineStColumn;
	}

	public void setCombineStColumn(int combineStColumn) {
		this.combineStColumn = combineStColumn;
	}

	public int getCombineStRow() {
		return combineStRow;
	}

	public void setCombineStRow(int combineStRow) {
		this.combineStRow = combineStRow;
	}

	public int getCombineEndColumn() {
		return combineEndColumn;
	}

	public void setCombineEndColumn(int combineEndColumn) {
		this.combineEndColumn = combineEndColumn;
	}

	public int getCombineEndRow() {
		return combineEndRow;
	}

	public void setCombineEndRow(int combineEndRow) {
		this.combineEndRow = combineEndRow;
	}

	public int getLocationColumn() {
		return locationColumn;
	}

	public void setLocationColumn(int locationColumn) {
		this.locationColumn = locationColumn;
	}

	public int getLocationRow() {
		return locationRow;
	}

	public void setLocationRow(int locationRow) {
		this.locationRow = locationRow;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getObjField() {
		return objField;
	}

	public void setObjField(List<String> objField) {
		this.objField = objField;
	}

	public boolean isColumnTitleFlg() {
		return columnTitleFlg;
	}

	public void setColumnTitleFlg(boolean columnTitleFlg) {
		this.columnTitleFlg = columnTitleFlg;
	}

	public String getTitleCss() {
		return titleCss;
	}

	public void setTitleCss(String titleCss) {
		this.titleCss = titleCss;
	}

	public boolean isLowTag() {
		return lowTag;
	}

	public void setLowTag(boolean lowTag) {
		this.lowTag = lowTag;
	}

	public String getDtlOrgTp() {
		return dtlOrgTp;
	}

	public void setDtlOrgTp(String dtlOrgTp) {
		this.dtlOrgTp = dtlOrgTp;
	}

}
