package com.aml.common.export;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类功能描述：通过xml生成EXCEL
 * @author ljt
 * @date 2017/10/010
 */
public class ExportTool {
	
	public ExportTool(String filePath, String fileName, String xmlName, List dataList, Object dataObj, int columnWidth, int rowHeight){
		this.filePath = filePath;
		this.fileName = fileName;
		this.xmlFilePath  = xmlName;
		this.dataList = dataList;
		this.dataObj  = dataObj;
		this.columnWidth = columnWidth;
		this.rowHeight = rowHeight;
	}
	public ExportTool(String filePath, String fileName, String xmlName, List dataList, Object dataObj, int columnWidth, int rowHeight,String columns){
		this.filePath = filePath;
		this.fileName = fileName;
		this.xmlFilePath  = xmlName;
		this.dataList = dataList;
		this.dataObj  = dataObj;
		this.columnWidth = columnWidth;
		this.rowHeight = rowHeight;
		this.columns = columns;
	}
	
	public void exportExcel() throws Exception{
		
			//首先读取XML文件，获取XML信息，变成字符串
			Map<String, Object> map = readFileFromXML(xmlFilePath);
			if(map.get("ERROR") != null){
				Exception exception = new Exception((String)map.get("ERROR"));
				throw exception;
			}
			String xmlStr = (String)map.get("XMLSTR");
			//解析xml字符串
			map = parserXML(xmlStr);
			if(map.get("ERROR") != null){
				Exception exception = new Exception((String)map.get("ERROR"));
				throw exception;
			}
			
			//通过解析的xml文件内容，产生EXCEL文件
			List<ExcelNode> excelNodeList = (List<ExcelNode>)map.get("NOTE_LIST");
			map = makeExcel(excelNodeList);
			if(map.get("ERROR") != null){
				Exception exception = new Exception((String)map.get("ERROR"));
				throw exception;
			}
			
			logger.info("EXCEL文件生成成功");
	}

	public void exportCsv() throws Exception{
		
			//首先读取XML文件，获取XML信息，变成字符串
			Map<String, Object> map = readFileFromXML(xmlFilePath);
			if(map.get("ERROR") != null){
				Exception exception = new Exception((String)map.get("ERROR"));
				throw exception;
			}
			String xmlStr = (String)map.get("XMLSTR");
			//解析xml字符串
			map = parserXMLToCSV(xmlStr);
			if(map.get("ERROR") != null){
				Exception exception = new Exception((String)map.get("ERROR"));
				throw exception;
			}
			
			//通过解析的xml文件内容，产生EXCEL文件
			List<ExcelNode> csvNodeList = (List<ExcelNode>)map.get("NOTE_LIST");
			map = makeCsv(csvNodeList);
			if(map.get("ERROR") != null){
				Exception exception = new Exception((String)map.get("ERROR"));
				throw exception;
			}
			
			logger.info("CSV文件生成成功");
	}
	
	/**
	 * 方法功能描述：首先读取XML文件，获取XML信息，变成字符串
	 * @param xmlName
	 * @return
	 */
	public Map<String, Object> readFileFromXML(String xmlName){
		logger.info("读取配置文件，并解析配置文件内容为string, 开始...");
		
		Map<String, Object> map = new HashMap<String, Object>();
		//String xmlStr = "";//xml文件内容
		StringBuffer strBuffer = new StringBuffer();//change by sq 8/5
		StringBuffer xmlFilePathBuffer = new StringBuffer();
		xmlFilePathBuffer.append(ExcelConst.defaultXmlFileDir);
		xmlFilePathBuffer.append(xmlName);
		String xmlFilePath = xmlFilePathBuffer.toString();
		//String xmlFilePath = ExcelConst.defaultXmlFileDir + xmlName;
		File file = new File(xmlFilePath);
		if(!file.exists() || !file.isFile()){
			logger.info("XML配置文件没有找到，请重新放置文件....");
			String errorMsg = "XML配置文件没有找到，请重新放置文件....";
			map.put("ERROR", errorMsg);
			return map;
		}
		
		try {
			InputStreamReader fileReader = new InputStreamReader(new FileInputStream(xmlFilePath), "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String tempStr = new String();
			while((tempStr = bufferedReader.readLine()) != null){
				strBuffer.append(tempStr);
				//xmlStr += tempStr;
			}
			bufferedReader.close();
			//map.put("XMLSTR", xmlStr);
			map.put("XMLSTR", strBuffer.toString());
		} catch (FileNotFoundException e) {
			logger.info("读取XML配置文件失败....");
			String errorMsg = "读取XML配置文件失败....";
			map.put("ERROR", errorMsg);
			return map;
		}catch (IOException e) {
			logger.info("读取XML配置文件失败....");
			String errorMsg = "读取XML配置文件失败....";
			map.put("ERROR", errorMsg);
			return map;
		}
		
		logger.info("读取配置文件，并解析配置文件内容为string, 结束...");
		
		return map;
	}
	
	/**
	 * 方法功能描述：解析xml为LIST，提供后面开始写EXCEL
	 * @param xml
	 * @return
	 */
	public Map<String, Object> parserXML(String xml){
		Document doc = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<ExcelNode> excelNodeList = new ArrayList<ExcelNode>();
		
		try {
			doc = DocumentHelper.parseText(xml); //将字符串转换成XML
		} catch (DocumentException e) {
			logger.info("解析XML配置文件失败....错误信息：" + e.getMessage() );
			String errorMsg = "解析XML配置文件失败....错误信息：" + e.getMessage();
			map.put("ERROR", errorMsg);
			return map;
		}
		
		Element rootNode = doc.getRootElement();//获取根节点，一般为XML
		Iterator iter = rootNode.elementIterator();
		while(iter.hasNext()){
			
			boolean columnTitleFlg = false;
			Element recordElement = (Element)iter.next();
			
			//遍历row标签
			if(recordElement.getName().equals("row")){
				Element rowElement = recordElement;
				Iterator rowIter = rowElement.elementIterator();
				
				while(rowIter.hasNext()){
					StringBuffer judgeKeyBuffer = new StringBuffer();//change by sq 8/5
					judgeKeyBuffer.append(columnIndex);
					judgeKeyBuffer.append(",");
					judgeKeyBuffer.append(rowIndex);
					String judgeKey = judgeKeyBuffer.toString();
					//String judgeKey = columnIndex + "," + rowIndex;
					if(filterMap.containsKey(judgeKey)){
						columnIndex ++;
						continue;
					}
					judgeKeyBuffer = null;
					Element columnElement = (Element)rowIter.next();
					if(columnElement.getName().equals("column")){
						
						ExcelNode excelNode = new ExcelNode();
						String columnValue = columnElement.getText();
						
						String startstr = "OBJFIELD";
						List<String> objField = new ArrayList<String>();
						String[] fieldArr = columnValue.split("&");
						for(int i = 0 ; i < fieldArr.length; i ++){
							if(fieldArr[i].toUpperCase().startsWith(startstr)){
								String[] tempArr = fieldArr[i].split(":");
								objField.add(tempArr[1]);
							}else{
								excelNode.setText(fieldArr[i]);
							}
						}
						
						excelNode.setObjField(objField);
						excelNode.setLocationColumn(columnIndex);
						excelNode.setLocationRow(rowIndex);
						
						List<Attribute> columnList = columnElement.attributes();
						for(int i = 0 ; i < columnList.size(); i ++){
							Attribute attribute = columnList.get(i);
							if(attribute != null && attribute.getName().equals("colspan")){
								//add by liuqh 20160224 V1.0.30 start
								int colspanValue = 0;
								if (columns != null && !"".equals(columns)) {
									colspanValue = columns.split(",").length;
								} else {
									colspanValue = Integer.valueOf(attribute.getValue());
								}
								//add by liuqh 20160224 V1.0.30 end
								excelNode.setCombineFlg(true);
								excelNode.setCombineStColumn(columnIndex);
								excelNode.setCombineEndColumn(columnIndex + colspanValue - 1);
								excelNode.setCombineStRow(rowIndex);
								excelNode.setCombineEndRow(rowIndex);
								
								for(int j = 0; j < colspanValue - 1; j ++){
									StringBuffer tmpBuffer = new StringBuffer();
									tmpBuffer.append(columnIndex + 1 + j);
									tmpBuffer.append(",");
									tmpBuffer.append(rowIndex);
									
									String key = tmpBuffer.toString();
									//String key = (columnIndex + 1 + j) + "," + rowIndex;
									filterMap.put(key, true);
									tmpBuffer = null;
								}
							}
							
							if(attribute != null && attribute.getName().equals("rowspan")){
								int rowspanValue = Integer.valueOf(attribute.getValue());
								
								excelNode.setCombineFlg(true);
								excelNode.setCombineStColumn(columnIndex);
								excelNode.setCombineEndColumn(columnIndex);
								excelNode.setCombineStRow(rowIndex);
								excelNode.setCombineEndRow(rowIndex + rowspanValue - 1);
								
								for(int j = 0 ; j < rowspanValue - 1; j ++){
									StringBuffer buffer = new StringBuffer();
									buffer.append(columnIndex);
									buffer.append(",");
									buffer.append(rowIndex + 1 + j);
									String key = buffer.toString();
									//String key = columnIndex + "," + (rowIndex + 1 + j);
									filterMap.put(key, true);
									buffer = null;
								}
							}
							
							if(attribute != null && attribute.getName().equals("css")){
								String cssValue = attribute.getValue();
								excelNode.setCss(cssValue);
							}
						}
						
						excelNodeList.add(excelNode);
						
						columnIndex ++;
					}
					
					//遍历columnTitle标签
					if(columnElement.getName().equals("columnTitle")){
						columnTitleFlg = true;
						
						String columnTitleValue = columnElement.getText();
						ExcelNode excelNode = new ExcelNode();
						excelNode.setColumnTitleFlg(columnTitleFlg);
						List<String> objField = new ArrayList<String>();
						objField.add(columnTitleValue);
						excelNode.setObjField(objField);

						List<Attribute> columnTitleList = columnElement.attributes();
						for(int i = 0 ; i < columnTitleList.size() ; i ++){
							Attribute attribute = columnTitleList.get(i);
							if(attribute != null && attribute.getName().equals("title")){
								String titleValue = attribute.getValue();
								excelNode.setText(titleValue);
							}
							
							if(attribute != null && attribute.getName().equals("titleCss")){
								String titleCssValue = attribute.getValue();
								excelNode.setTitleCss(titleCssValue);
							}
							
							if(attribute != null && attribute.getName().equals("css")){
								String cssValue = attribute.getValue();
								excelNode.setCss(cssValue);
							}
						}
						
						excelNode.setLocationColumn(columnIndex);
						excelNode.setLocationRow(rowIndex);
						
						excelNodeList.add(excelNode);
						
						columnIndex ++;
					}
				}
				
				columnIndex = 0;
				if(columnTitleFlg){
					rowIndex = rowIndex + dataList.size();
				}else{
					rowIndex ++;
				}
			}
		}
		
		map.put("NOTE_LIST", excelNodeList);
		
		return map;
	}

	/**
	 * 方法功能描述：解析xml为LIST，提供后面开始写CSV
	 * @param xml
	 * @return
	 */
	public Map<String, Object> parserXMLToCSV(String xml){
		Document doc = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<ExcelNode> csvNodeList = new ArrayList<ExcelNode>();
		
		try {
			doc = DocumentHelper.parseText(xml); //将字符串转换成XML
		} catch (DocumentException e) {
			logger.info("解析XML配置文件失败....错误信息：" + e.getMessage() );
			String errorMsg = "解析XML配置文件失败....错误信息：" + e.getMessage();
			map.put("ERROR", errorMsg);
			return map;
		}
		
		Element rootNode = doc.getRootElement();//获取根节点，一般为XML
		Iterator iter = rootNode.elementIterator();
		while(iter.hasNext()){
			
			boolean columnTitleFlg = false;
			Element recordElement = (Element)iter.next();
			
			//遍历row标签
			if(recordElement.getName().equals("row")){
				Element rowElement = recordElement;
				Iterator rowIter = rowElement.elementIterator();
				
				while(rowIter.hasNext()){
					StringBuffer judgeKeyBuffer = new StringBuffer();//change by sq 8/5
					judgeKeyBuffer.append(columnIndex);
					judgeKeyBuffer.append(",");
					judgeKeyBuffer.append(rowIndex);
					String judgeKey = judgeKeyBuffer.toString();
					//String judgeKey = columnIndex + "," + rowIndex;
					if(filterMap.containsKey(judgeKey)){
						columnIndex ++;
						continue;
					}
					judgeKeyBuffer = null;
					Element columnElement = (Element)rowIter.next();
					//遍历columnTitle标签
					if(columnElement.getName().equals("columnTitle")){
						columnTitleFlg = true;
						
						String columnTitleValue = columnElement.getText();
						
						ExcelNode excelNode = new ExcelNode();
						
						List<String> objField = new ArrayList<String>();
						objField.add(columnTitleValue);
						excelNode.setObjField(objField);
						
						List<Attribute> columnTitleList = columnElement.attributes();
						for(int i = 0 ; i < columnTitleList.size() ; i ++){
							Attribute attribute = columnTitleList.get(i);
							if(attribute != null && attribute.getName().equals("title")){
								String titleValue = attribute.getValue();
								excelNode.setText(titleValue);
							}
						}
						
						excelNode.setLocationColumn(columnIndex);
						excelNode.setLocationRow(rowIndex);
						
						csvNodeList.add(excelNode);
						
						columnIndex ++;
					}
				}
				
				columnIndex = 0;
				if(columnTitleFlg){
					if (dataList !=null ) {
						rowIndex = rowIndex + dataList.size();
					}
				}else{
					rowIndex ++;
				}
			}
		}
		
		map.put("NOTE_LIST", csvNodeList);
		
		return map;
	}
	
	
	
	/**
	 * 方法功能描述：生成EXCEL
	 * @param excelNodeList
	 * @return
	 */
	public Map<String, Object> makeExcel(List<ExcelNode> excelNodeList){
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<JExcelCell> orderCol = new ArrayList<JExcelCell>();
		boolean columnTitleProssFlg = false;
		
		//创建一个新的空的EXCEL
		JExcelUtils jxl = new JExcelUtils();
		WritableSheet sheet = null;
		try {
			sheet = jxl.creatSheet(filePath, fileName);
		} catch (Exception e) {
			logger.info("创建空的EXCEL失败,错误信息：" + e.getMessage());
			String errorMsg = "创建空的EXCEL失败,错误信息：" + e.getMessage();
			map.put("ERROR", errorMsg);
			return map;
		}
		
		//解析xml产生的excelNodeList
		for(int i = 0 ; i < excelNodeList.size(); i ++){
			ExcelNode excelNode = excelNodeList.get(i);
			if(excelNode.isCombineFlg()){
				try {
					sheet.mergeCells(excelNode.getCombineStColumn(), excelNode.getCombineStRow(), excelNode.getCombineEndColumn(), excelNode.getCombineEndRow());
				} catch (RowsExceededException e) {
					logger.info("合并单元格失败，错误信息：" + e.getMessage());
					String errorMsg = "合并单元格失败，错误信息：" + e.getMessage();
					map.put("ERROR", errorMsg);
					return map;
				} catch (WriteException e) {
					logger.info("合并单元格失败，错误信息：" + e.getMessage());
					String errorMsg = "合并单元格失败，错误信息：" + e.getMessage();
					map.put("ERROR", errorMsg);
					return map;
				}
			}
			
			String css = excelNode.getCss();
			WritableCellFormat format = parseCss(css, sheet, excelNode.getLocationColumn(), excelNode.getLocationRow());
			
			if(excelNode.isColumnTitleFlg()){
				WritableCellFormat titleFormat = parseCss(excelNode.getTitleCss(), sheet, excelNode.getLocationColumn(), excelNode.getLocationRow());
				columnTitleProssFlg = true;
				if (columns != null && !"".equals(columns)) {
					 if (columns.contains(excelNode.getObjField().get(0))) {
						 JExcelCell excelCell = new JExcelCell(excelNode.getText(), excelNode.getObjField().get(0), format, String.valueOf(excelNode.getLocationRow()), titleFormat);
							orderCol.add(excelCell); 
					 }
				} else {
					 JExcelCell excelCell = new JExcelCell(excelNode.getText(), excelNode.getObjField().get(0), format, String.valueOf(excelNode.getLocationRow()), titleFormat);
						orderCol.add(excelCell); 
				}
			}else{
				if(columnTitleProssFlg){
					Map<String, Object> titleMap = makeColumnTitleExcel(sheet, orderCol);
					if(titleMap.get("ERROR") != null){
						logger.info((String)titleMap.get("ERROR"));
						String errorMsg = (String)titleMap.get("ERROR");
						map.put("ERROR", errorMsg);
						return map;
					}
				}
				columnTitleProssFlg = false;
				
				try {
					if(excelNode.getObjField() != null && excelNode.getObjField().size() != 0){
						
						String cellText = "";
						StringBuffer cellTextBuffer = new StringBuffer();//change by sq 8/5
						StringBuffer excelNodeBuffer =  new StringBuffer();
						List<String> objField = excelNode.getObjField();
						for(int j = 0 ; j < objField.size(); j ++){
							// modify by liuqh 20160121 start
							Object objTmp = null;
							String[] fieldNames = objField.get(j).split(",");
							if (fieldNames.length == 2) {
								objTmp = jxl.getObjValByName(fieldNames[1],jxl.getObjValByName(fieldNames[0],dataObj));
							} else {
								String fieldName = objField.get(j);
								objTmp = jxl.getObjValByName(objField.get(j), dataObj);
							}
							
							cellTextBuffer.append(objTmp.toString().trim());
							// modify by liuqh 20160121 end
							//cellText = cellText + jxl.getObjValByName(objField.get(j), dataObj).toString();
						}
						cellText = cellTextBuffer.toString();
						if(excelNode.getText() != null && !excelNode.getText().trim().equals("")){
							excelNodeBuffer =  new StringBuffer();
							excelNodeBuffer.append(excelNode.getText());
							excelNodeBuffer.append(" ");
							excelNodeBuffer.append(" ");
							excelNodeBuffer.append(cellText);
							
							cellText = excelNodeBuffer.toString();
							//cellText = excelNode.getText() + " " + " " + cellText;
						}
						cellTextBuffer = null;
						excelNodeBuffer = null;
						jxl.insertOneCellData(sheet, excelNode.getLocationColumn(), excelNode.getLocationRow(), cellText, format);
					}else{
						jxl.insertOneCellData(sheet, excelNode.getLocationColumn(), excelNode.getLocationRow(), excelNode.getText(), format);
					}
				} catch (Exception e) {
					logger.info("EXCEL插入数据失败，错误信息：" + e.getMessage());
					String errorMsg = "EXCEL插入数据失败，错误信息：" + e.getMessage();
					map.put("ERROR", errorMsg);
					return map;
				}
			}
		}
		
		if(columnTitleProssFlg){
			Map<String, Object> titleMap = makeColumnTitleExcel(sheet, orderCol);
			if(titleMap.get("ERROR") != null){
				logger.info((String)titleMap.get("ERROR"));
				String errorMsg = (String)titleMap.get("ERROR");
				map.put("ERROR", errorMsg);
				return map;
			}
		}
		
		try {
			jxl.writeAndClose();
		} catch (WriteException e) {
			logger.info("EXCEL插入数据失败，错误信息：" + e.getMessage());
			String errorMsg = "EXCEL插入数据失败，错误信息：" + e.getMessage();
			map.put("ERROR", errorMsg);
			return map;
		} catch (IOException e) {
			logger.info("EXCEL插入数据失败，错误信息：" + e.getMessage());
			String errorMsg = "EXCEL插入数据失败，错误信息：" + e.getMessage();
			map.put("ERROR", errorMsg);
			return map;
		}
		
		return map;
	}

	/**
	 * 方法功能描述：生成CSV
	 * @param excelNodeList
	 * @return
	 */
	public Map<String, Object> makeCsv(List<ExcelNode> excelNodeList) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<JExcelCell> col = new ArrayList<JExcelCell>();
		CSVUtils jxl = new CSVUtils();
		BufferedWriter csvFileOutputStream = null;
		File csvFile = null;
		Boolean isTitle = false;
		int dataSize = dataList!=null?dataList.size():0;
		try {
			csvFile = new File(filePath);
			File parent = csvFile.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			csvFile.createNewFile();

			// GB2312使正确读取分隔符","
			csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(csvFile), "GB2312"), 1024);

			// 解析xml产生的excelNodeList
			for (int i = 0; i < excelNodeList.size(); i++) {
				ExcelNode excelNode = excelNodeList.get(i);
				if (!isTitle && null != excelNode.getText() && !"".equals(excelNode.getText())) {
					isTitle = true;
				}
				JExcelCell excelCell = new JExcelCell(excelNode.getText(),excelNode.getObjField().get(0));
				col.add(excelCell);
			}
			
			//插入标题
			if (isTitle) {
				jxl.insertTitle(csvFileOutputStream, col);
				if (dataSize > 0 || dataObj != null) {
					csvFileOutputStream.newLine();
				}
			}
			if (dataSize > 0) {
			// 插入数据
			for (int j = 0; j < dataSize; j++) {
				jxl.insertRowData(csvFileOutputStream, dataList.get(j), col);
				if (j < dataSize - 1) {
					csvFileOutputStream.newLine();
				}
			}
			} else {
				jxl.insertRowData(csvFileOutputStream, dataObj, col);
			}
			
			csvFileOutputStream.flush();
			csvFileOutputStream.close();
		} catch (Exception e) {
			logger.info("CSV插入数据失败，错误信息：" + e.getMessage());
			String errorMsg = "CSV插入数据失败，错误信息：" + e.getMessage();
			map.put("ERROR", errorMsg);
			return map;
		}
		return map;
	}
	
	//解析CSS
	public WritableCellFormat parseCss(String css, WritableSheet sheet, int columnLocate, int rowLocate){
		
		WritableCellFormat format = null;
		
		try {
			
			int size = 0;//记录设置字体大小
			
			//设置默认css
			WritableFont defaultFont = new WritableFont(WritableFont.createFont(ExcelConst.defaultFontType), ExcelConst.defaultFontSize);
			format = new WritableCellFormat(defaultFont);
			format.setAlignment(Alignment.LEFT); //字据左
			format.setBorder(Border.ALL, BorderLineStyle.MEDIUM); //边框中等宽度
			format.setVerticalAlignment(VerticalAlignment.CENTRE); //字内容上下居中
			format.setWrap(true);//自动换行
			
			if(css != null && !css.equals("")){
				
				String[] cssArr = css.split(";");
				for(int j = 0; j < cssArr.length; j ++){
					String[] cssRecordArr = cssArr[j].split(":");
					if(cssRecordArr[0] != null && !cssRecordArr[0].trim().equals("")){
						String cssItem = cssRecordArr[0].trim();
						String cssValue = cssRecordArr[1].trim();
						if(cssItem.equals("border")){
							if(cssValue.toUpperCase().equals("NONE")){
								format.setBorder(Border.ALL, BorderLineStyle.NONE);
							}else if(cssValue.toUpperCase().equals("MEDIUM")){
								format.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
							}
						}
						
						if(cssItem.equals("border-top")){
							if(cssValue.toUpperCase().equals("NONE")){
								format.setBorder(Border.TOP, BorderLineStyle.NONE);
							}else if(cssValue.toUpperCase().equals("MEDIUM")){
								format.setBorder(Border.TOP, BorderLineStyle.MEDIUM);
							}
						}
						
						if(cssItem.equals("border-bottom")){
							if(cssValue.toUpperCase().equals("NONE")){
								format.setBorder(Border.BOTTOM, BorderLineStyle.NONE);
							}else if(cssValue.toUpperCase().equals("MEDIUM")){
								format.setBorder(Border.BOTTOM, BorderLineStyle.MEDIUM);
							}
						}
						
						if(cssItem.equals("border-left")){
							if(cssValue.toUpperCase().equals("NONE")){
								format.setBorder(Border.LEFT, BorderLineStyle.NONE);
							}else if(cssValue.toUpperCase().equals("MEDIUM")){
								format.setBorder(Border.LEFT, BorderLineStyle.MEDIUM);
							}
						}
						
						if(cssItem.equals("border-right")){
							if(cssValue.toUpperCase().equals("NONE")){
								format.setBorder(Border.RIGHT, BorderLineStyle.NONE);
							}else if(cssValue.toUpperCase().equals("MEDIUM")){
								format.setBorder(Border.RIGHT, BorderLineStyle.MEDIUM);
							}
						}
						
						if(cssItem.equals("text-align")){
							if(cssValue.toUpperCase().equals("LEFT")){
								format.setAlignment(Alignment.LEFT);
							}else if(cssValue.toUpperCase().equals("CENTER")){
								format.setAlignment(Alignment.CENTRE);
							}else if(cssValue.toUpperCase().equals("RIGHT")){
								format.setAlignment(Alignment.RIGHT);
							}
						}
						
						if(cssItem.equals("font-size")){
							size = Integer.valueOf(cssValue);
							WritableFont font = new WritableFont(WritableFont.createFont("宋体"), size);
							format.setFont(font);
						}
						
						if(cssItem.equals("font-weight")){
							WritableFont font = null;
							if(cssValue.toUpperCase().equals("BOLD")){
								if(size != 0){
									//font = new WritableFont(WritableFont.createFont(ExcelConst.defaultFontType), size, WritableFont.BOLD);
									font = new WritableFont(WritableFont.createFont("黑体"), size, WritableFont.BOLD);  //标题统一为黑体  
								}else{
									font = new WritableFont(WritableFont.createFont("黑体"), ExcelConst.defaultFontSize, WritableFont.BOLD);
									//font = new WritableFont(WritableFont.createFont(ExcelConst.defaultFontType), ExcelConst.defaultFontSize, WritableFont.BOLD);
								}
							}
							format.setFont(font);
						}
						
						if(cssItem.equals("width")){
							size = Integer.valueOf(cssValue);
							columnWidthMap.put(columnLocate, size);
						}
						
						if(cssItem.equals("height")){
							size = Integer.valueOf(cssValue);
							rowHeightMap.put(rowLocate, size);
						}
					}
				}
			}
			
			if(columnWidthMap.containsKey(columnLocate)){
				sheet.setColumnView(columnLocate, columnWidthMap.get(columnLocate));
			}else{
				if(columnWidth != 0){
					sheet.setColumnView(columnLocate, columnWidth);
				}else{
					sheet.setColumnView(columnLocate, ExcelConst.defaultColumneWidth);
				}
			}
			
			if(rowHeightMap.containsKey(rowLocate)){
				sheet.setRowView(rowLocate, rowHeightMap.get(rowLocate));
			}else{
				if(rowHeight != 0){
					sheet.setRowView(rowLocate, rowHeight);
				}else{
					sheet.setRowView(rowLocate, ExcelConst.defaultRowHeight);
				}
			}
			
		} catch (WriteException e) {
			e.printStackTrace();
		}
		
		return format;
	}
	
	public Map<String, Object> makeColumnTitleExcel(WritableSheet sheet, List<JExcelCell> orderCol){
		int rowNum = 0;
		WritableCellFormat titleFormat = null;
		List<String> titleList = new ArrayList<String>();
		JExcelUtils jxl = new JExcelUtils();
		Map<String, Object> map = new HashMap<String, Object>();
		
		//插入EXCEL头
		for(int j = 0 ; j < orderCol.size() ; j ++){
			titleList.add(orderCol.get(j).getDataIndex());
			rowNum = Integer.valueOf(orderCol.get(j).getPosition());
			titleFormat = orderCol.get(j).getTitleFormat();
		}
		try {
			jxl.insertTitle(sheet, rowNum, titleList, titleFormat);
		} catch (Exception e) {
			logger.info("EXCEL插入标题失败，错误信息：" + e.getMessage());
			String errorMsg = "EXCEL插入标题失败，错误信息：" + e.getMessage();
			map.put("ERROR", errorMsg);
			return map;
		}
		
		for(int j = 0; j < dataList.size() ; j ++){
			try {
				jxl.insertRowData(sheet, rowNum + 1 + j, dataList.get(j), orderCol);
			} catch (Exception e) {
				logger.info("EXCEL插入数据失败，错误信息：" + e.getMessage());
				String errorMsg = "EXCEL插入数据失败，错误信息：" + e.getMessage();
				map.put("ERROR", errorMsg);
				return map;
			}
		}
		
		return map;
	}

	
	private static Logger logger = LoggerFactory.getLogger(ExcelConst.class);
	
	private int rowIndex = 0; //单元格行初始值
	
	private int columnIndex = 0; //单元格列初始值
	
	private String filePath = ""; //文件路径
	
	private String fileName = ""; //文件名
	
	private String xmlFilePath = "";  //xml配置文件名
	
	private List dataList = new ArrayList(); //数据集
	
	private Object dataObj = new Object(); //单条数据
	
	private Map<String, Boolean> filterMap = new HashMap<String, Boolean>();
	
	private int rowHeight = 0;
	
	private int columnWidth = 0;
	
	private Map<Integer, Integer> columnWidthMap = new HashMap<Integer, Integer>();
	
	private Map<Integer, Integer> rowHeightMap = new HashMap<Integer, Integer>();
	
	private String columns = "";
}
