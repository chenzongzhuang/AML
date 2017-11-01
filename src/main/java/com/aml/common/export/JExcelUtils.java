package com.aml.common.export;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * <p>Title:  上海银行商户管理系统</p>
 * <p>Description: Excel导入/导出通用类</p>
 * <p></p>
 * <p>Company: 上海恩梯梯数据晋恒软件有限公司</p>
 * @author CJUN
 * @version 1.0
 */
public class JExcelUtils {

	private static Logger logger = LoggerFactory.getLogger(JExcelUtils.class);

	// 数字格式，保留小数点2位
	private static final String NUMBER_FORMAT = "#.00";

	// 显示日期时间格式
	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";

	// 表头字体大小
	private static int DATA_FORMAT_TITLE_SIZE = 12;

	// 内容字体大小
	private static int DATA_FORMAT_SIZE = 11;

	// 列的默认宽度
	private static int COLUMN_DEFAULT_WIDTH = 15;
	
	// 列的数据位置
	private static String COLUMN_LEFT = "L";//left
	private static String COLUMN_RIGHT = "R";//right
	private static String COLUMN_CENTER = "C";//center

	private WritableWorkbook workbook;

	private WritableSheet sheet;

	private String path = "";

	private String sheetName = "";
	
	private OutputStream os = null;

	/**
	 * 初始化工作表 
	 * @param filePath 文件路径
	 * @param fileName 文件名字
	 */
	public WritableSheet creatSheet(String filePath, String fileName)
			throws Exception {
		this.path = filePath;
		this.sheetName = fileName;
		try {
			os = new FileOutputStream(path);// 输出流指定文件路径
			workbook = Workbook.createWorkbook(os);// 创建工作薄
			sheet = workbook.createSheet(sheetName, 0); // 添加第一个工作表
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return sheet;
	}

	/**
	 * 初始化表格属性
	 * 
	 * @param sheet
	 */
	public void initialSheetSetting(WritableSheet sheet) throws Exception {
		try {
			sheet.getSettings().setDefaultColumnWidth(COLUMN_DEFAULT_WIDTH); // 设置列的默认宽度
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 插入公式
	 * 
	 * @param sheet
	 * @param col
	 * @param row
	 * @param formula
	 * @param format
	 */
	public void insertFormula(WritableSheet sheet, Integer col, Integer row,
			String formula, WritableCellFormat format) throws Exception {
		try {
			Formula f = new Formula(col, row, formula, format);
			sheet.addCell(f);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 插入一个字符串数组的数据
	 * 
	 * @param sheet
	 * @param row
	 * @param dataArr
	 * @param format
	 * @throws Exception
	 */
	public void insertRowData(WritableSheet sheet, Integer row,
			String[] dataArr, WritableCellFormat format) throws Exception {
		try {
			Label label;
			for (int i = 0; i < dataArr.length; i++) {
				label = new Label(i, row, dataArr[i], format);
				sheet.addCell(label);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 插入一条对象数据
	 * 
	 * @param <T>
	 *            插入的单个对象
	 * @param sheet
	 *            工作表
	 * @param row
	 *            行号
	 * @param data
	 *            单个对象的数据
	 * @param orderCol
	 *            数据列
	 * @throws Exception
	 */
	public <T> void insertRowData(WritableSheet sheet, Integer row, T data, List<JExcelCell> orderCol) throws Exception {
		try {
			for (int i = 0; i < orderCol.size(); i++) {
				JExcelCell cell = orderCol.get(i);
				WritableCellFormat fieldFormat = cell.getFormat();
				Object objTmp = null;
				String[] fieldNames = cell.getDataName().split(",");
				if (fieldNames.length == 2) {
					objTmp = getObjValByName(fieldNames[1],getObjValByName(fieldNames[0],data));
				} else {
					String fieldName = cell.getDataName();
					objTmp = getObjValByName(fieldName,data);
				}
				// 字符串类型数据处理
				Label label = new Label(i, row, objTmp==null?"":objTmp.toString(), fieldFormat);
				sheet.addCell(label);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 插入标题
	 * 
	 * @param sheet
	 * @param row
	 * @param data
	 * @param format
	 * @throws Exception
	 */
	public void insertTitle(WritableSheet sheet, Integer row,
			List<String> data, WritableCellFormat format) throws Exception {
		try {
			Label label = null;
			for (int i = 0; i < data.size(); i++) {
				label = new Label(i, row, data.get(i), format);
				sheet.addCell(label);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 插入单元格数据
	 * 
	 * @param sheet
	 * @param col
	 * @param row
	 * @param data
	 */
	public void insertOneCellData(WritableSheet sheet, Integer col,
			Integer row, Object data, WritableCellFormat format)
			throws Exception {
		try {
			if (data instanceof Double) {
				jxl.write.Number labelNF = new jxl.write.Number(col, row,
						(Double) data, format);
				sheet.addCell(labelNF);
			} else if (data instanceof java.lang.Boolean) {
				jxl.write.Boolean labelB = new jxl.write.Boolean(col, row,
						(java.lang.Boolean) data, format);
				sheet.addCell(labelB);
			} else if (data instanceof Date) {
				jxl.write.DateTime labelDT = new jxl.write.DateTime(col, row,
						(Date) data, format);
				sheet.addCell(labelDT);
				setCellComments(labelDT, "这是个创建表的日期说明！"); // 给单元格加注释(公共方法)
			} else {
				Label label = new Label(col, row, data.toString(), format);
				sheet.addCell(label);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 合并单元格，并插入数据
	 * 
	 * @param sheet
	 * @param col_start
	 * @param row_start
	 * @param col_end
	 * @param row_end
	 * @param data
	 * @param format
	 */
	public void mergeCellsAndInsertData(WritableSheet sheet, Integer col_start,
			Integer row_start, Integer col_end, Integer row_end, Object data,
			WritableCellFormat format) throws Exception {
		try {
			sheet.mergeCells(col_start, row_start, col_end, row_end);// 左上角到右下角
			insertOneCellData(sheet, col_start, row_start, data, format);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}
	
	/**
	 * 合并单元格
	 * 
	 * @param sheet
	 * @param col_start
	 * @param row_start
	 * @param col_end
	 * @param row_end
	 * @param data
	 * @param format
	 */
	public void mergeCells(WritableSheet sheet, Integer col_start,
			Integer row_start, Integer col_end, Integer row_end, Object data,
			WritableCellFormat format) throws Exception {
		try {
			sheet.mergeCells(col_start, row_start, col_end, row_end);// 左上角到右下角
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	/**
	 * 给单元格加注释
	 * 
	 * @param label
	 *            ：lable对象
	 * @param comments
	 *            ：注释内容
	 */
	public void setCellComments(Object label, String comments) throws Exception {
		try {
			WritableCellFeatures cellFeatures = new WritableCellFeatures();
			cellFeatures.setComment(comments);
			if (label instanceof jxl.write.Number) {
				jxl.write.Number num = (jxl.write.Number) label;
				num.setCellFeatures(cellFeatures);
			} else if (label instanceof jxl.write.Boolean) {
				jxl.write.Boolean bool = (jxl.write.Boolean) label;
				bool.setCellFeatures(cellFeatures);
			} else if (label instanceof jxl.write.DateTime) {
				jxl.write.DateTime dt = (jxl.write.DateTime) label;
				dt.setCellFeatures(cellFeatures);
			} else {
				Label _label = (Label) label;
				_label.setCellFeatures(cellFeatures);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 读取excel
	 * 
	 * @param inputFile
	 * @param inputFileSheetIndex
	 * @throws Exception
	 */
	public ArrayList<String> readDataFromExcel(File inputFile,
			int inputFileSheetIndex) throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		Workbook book = null;
		Cell cell = null;
		try {
			WorkbookSettings ws = getWorkbookSettings();
			book = Workbook.getWorkbook(inputFile, ws);

			Sheet sheet = book.getSheet(inputFileSheetIndex);
			for (int rowIndex = 0; rowIndex < sheet.getRows(); rowIndex++) {// 行
				for (int colIndex = 0; colIndex < sheet.getColumns(); colIndex++) {// 列
					cell = sheet.getCell(colIndex, rowIndex);
					list.add(cell.getContents());
				}
			}
			book.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return list;
	}
	
	/**
	 * 获取数组元素的列表数据
	 * @param inputFile 传入的数据
	 * @param inputFileSheetIndex sheet
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String[]> readFromExcel(File inputFile,
			int inputFileSheetIndex) throws Exception {
		ArrayList<String[]> list = new ArrayList<String[]>();
		Workbook book = null;
		Cell cell = null;
		try {
			WorkbookSettings ws = getWorkbookSettings();
			book = Workbook.getWorkbook(inputFile, ws);

			Sheet sheet = book.getSheet(inputFileSheetIndex);
			for (int rowIndex = 0; rowIndex < sheet.getRows(); rowIndex++) {// 行
				String[] colDatas = new String[sheet.getColumns()];
				for (int colIndex = 0; colIndex < sheet.getColumns(); colIndex++) {// 列
					cell = sheet.getCell(colIndex, rowIndex);
					colDatas[colIndex] = cell.getContents();
				}
				list.add(colDatas);
			}
			book.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return list;
	}
	
	/**
	 * workbooksetting 相关设置
	 * @return
	 */
	public WorkbookSettings getWorkbookSettings(){
		WorkbookSettings setting = new WorkbookSettings();
		java.util.Locale locale = new java.util.Locale("zh", "CN"); // 本地
		setting.setLocale(locale);
		setting.setEncoding("UTF-8"); // 设置字符集编码
		return setting;
	}

	/**
	 * 得到数据表头格式
	 * 
	 * @return
	 */
//	public WritableCellFormat getTitleCellFormat() throws Exception {
//		WritableCellFormat wcf = null;
//		try {
//			// 字体样式(字体,大小,是否粗体,是否斜体)
//			WritableFont wf = new WritableFont(WritableFont.TIMES,
//					DATA_FORMAT_TITLE_SIZE, WritableFont.BOLD, false);
//			wcf = new WritableCellFormat(wf);// 实例化文字格式化
//			// 对齐方式
//			wcf.setAlignment(Alignment.CENTRE); // 水平
//			wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直
//			// 背景色
//			wcf.setBackground(jxl.format.Colour.GREY_25_PERCENT);
//			// 边框
//			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
//			wcf.setWrap(false);// 自动换行
//		} catch (WriteException e) {
//			logger.error(e.getMessage());
//		}
//		return wcf;
//	}

	/**
	 * 得到数据格式(默认左对齐)
	 * 
	 * @return
	 */
//	public WritableCellFormat getDataCellFormat(CellType type)
//			throws WriteException {
//		WritableCellFormat wcf = null;
//		try {
//			// 字体样式
//			if (type == CellType.NUMBER || type == CellType.NUMBER_FORMULA) {// 数字
//				NumberFormat nf = new NumberFormat(NUMBER_FORMAT); // 保留小数点后两位
//				wcf = new WritableCellFormat(nf);
//			} else if (type == CellType.DATE || type == CellType.DATE_FORMULA) {// 日期
//				jxl.write.DateFormat df = new jxl.write.DateFormat(
//						DATE_TIME_FORMAT); // 时间显示格式
//				wcf = new jxl.write.WritableCellFormat(df);
//			} else {
//				WritableFont wf = new WritableFont(WritableFont.TIMES,
//						DATA_FORMAT_SIZE, WritableFont.NO_BOLD, false);// 字体样式(字体,大小,是否粗体,是否斜体)
//				wcf = new WritableCellFormat(wf);
//			}
//			// 对齐方式
//			wcf.setAlignment(Alignment.LEFT);
//			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
//
//			wcf.setWrap(false);// 自动换行
//		} catch (WriteException e) {
//			logger.error(e.getMessage());
//		}
//
//		return wcf;
//	}

	/**
	 * 得到数据格式(重载)
	 * 
	 * @param align
	 *            对齐方式
	 * @param type 数据格式
	 * @return
	 */
//	public WritableCellFormat getDataCellFormat(CellType type, Alignment align)
//			throws WriteException {
//		WritableCellFormat wcf = null;
//		try {
//			// 字体样式
//			if (type == CellType.NUMBER || type == CellType.NUMBER_FORMULA) {// 数字
//				NumberFormat nf = new NumberFormat(NUMBER_FORMAT); // 保留小数点后两位
//				wcf = new WritableCellFormat(nf);
//			} else if (type == CellType.DATE || type == CellType.DATE_FORMULA) {// 日期
//				jxl.write.DateFormat df = new jxl.write.DateFormat(
//						DATE_TIME_FORMAT); // 时间显示格式
//				wcf = new jxl.write.WritableCellFormat(df);
//			} else {
//				WritableFont wf = new WritableFont(WritableFont.TIMES,
//						DATA_FORMAT_SIZE, WritableFont.NO_BOLD, false);// 字体样式(字体,大小,是否粗体,是否斜体)
//				wcf = new WritableCellFormat(wf);
//			}
//			// 对齐方式
//			wcf.setAlignment(align);
//			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
//
//			wcf.setWrap(true);// 自动换行
//		} catch (WriteException e) {
//			logger.error(e.getMessage());
//		}
//
//		return wcf;
//	}

	/**
	 * 重载单元格格式
	 * 
	 * @param type
	 *            数据格式类型
	 * @param align
	 *            位置
	 * @param format
	 *            格式
	 * @return
	 * @throws WriteException
	 */
//	public WritableCellFormat getDataCellFormat(CellType type, Alignment align,
//			String format) throws WriteException {
//		WritableCellFormat wcf = null;
//		try {
//			// 字体样式
//			if (type == CellType.NUMBER || type == CellType.NUMBER_FORMULA) {// 数字
//				if (format == null || format.equals("")) {
//					format = NUMBER_FORMAT;
//				}
//				NumberFormat nf = new NumberFormat(format); // 保留小数点后两位
//				wcf = new WritableCellFormat(nf);
//			} else if (type == CellType.DATE || type == CellType.DATE_FORMULA) {// 日期
//				if (format == null || format.equals("")) {
//					format = DATE_TIME_FORMAT;
//				}
//				jxl.write.DateFormat df = new jxl.write.DateFormat(format); // 时间显示格式
//				wcf = new jxl.write.WritableCellFormat(df);
//			} else {
//				WritableFont wf = new WritableFont(WritableFont.TIMES,
//						DATA_FORMAT_SIZE, WritableFont.NO_BOLD, false);// 字体样式(字体,大小,是否粗体,是否斜体)
//				wcf = new WritableCellFormat(wf);
//			}
//			// 对齐方式
//			wcf.setAlignment(align);
//			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
//
//			wcf.setWrap(true);// 自动换行
//		} catch (WriteException e) {
//			logger.error(e.getMessage());
//		}
//
//		return wcf;
//	}

	/**
	 * 创建目录
	 * 
	 * @param destDirName
	 *            目录路径
	 */
	public static boolean createDir(String destDirName) {
		boolean flag = true;
		File dir = new File(destDirName);
		// 如果目录不存在则创建目录
		if (!dir.exists()) {

			if (!destDirName.endsWith(File.separator)) {
				destDirName = destDirName + File.separator;
			}
			// 创建单个目录
			if (!dir.mkdirs()) {
				flag = false;
			}
		}
		return flag;
	}

	/**
	 * 生成并关闭工作簿
	 */
	public void writeAndClose() throws IOException, WriteException {
		try {
			workbook.write();
			workbook.close();
			os.close();
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (WriteException e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 生成Excel文件(适合一个标题,剩余全是数据)
	 * 
	 * @param <T>
	 * 
	 * @param path
	 *            文件路径
	 * @param sheetName
	 *            工作表名称
	 * @param dataTitles
	 *            数据标题
	 */
//	public <T> void createExcelFile(String path, String sheetName,
//			List<JExcelCell> titles, List<T> datas) throws Exception {
//		try {
//			OutputStream os = new FileOutputStream(path);// 输出流指定文件路径
//			workbook = Workbook.createWorkbook(os);// 创建工作薄
//			sheet = workbook.createSheet(sheetName, 0); // 添加第一个工作表
//			initialSheetSetting(sheet);// 初始化表格属性(公共方法)
//
//			// 标题文本
//			List<String> dataTitles = new ArrayList<String>();
//			// 标题对应数据及格式
//			List<JExcelCell> orderCol = new ArrayList<JExcelCell>();
//			for (int j = 0; j < titles.size(); j++) {
//				JExcelCell cell = titles.get(j);
//				dataTitles.add(cell.getDataIndex());
//				orderCol.add(cell);
//			}
//			// 添加数据标题
//			insertTitle(sheet, 0, dataTitles, getTitleCellFormat());
//			// 插入行
//			for (int i = 0; i < datas.size(); i++) {
//				Object obj = datas.get(i);
//				insertRowData(sheet, i + 1, obj, orderCol);
//			}
//			workbook.write();
//			workbook.close();
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//		}
//	}

	/**
	 * 从模板文件生成Excel的文件，建议使用此方法
	 * @param <T>
	 * @param path 生成文件的路径
	 * @param templatePathAndName 模板文件的路径
	 * @param rowStart 开始写入行
	 * @param datas 数据列表
	 * @param orderCol 显示的数据
	 * @throws Exception
	 */
//	public <T> void createExcelFileFromTemplate(String path,String templatePathAndName,int rowStart,
//			List<T> datas, List<JExcelCell> orderCol, String... sumStr) throws Exception {
//		Workbook book = null;
//		try {
//			OutputStream os = new FileOutputStream(path);// 输出流指定文件路径
//			
//			/** 此处若不设为空，则会空指针报错，jxl的bug? **/
//			WorkbookSettings ws = getWorkbookSettings();
//			//ws.setWriteAccess(null);
//			
//			book = Workbook.getWorkbook(new File(templatePathAndName));
//			workbook = Workbook.createWorkbook(os, book,ws);
//			sheet = workbook.getSheet(0);
//			initialSheetSetting(sheet);//
//			
//			// 插入行
//			for (int i = 0; i < datas.size(); i++) {
//				Object obj = datas.get(i);
//				insertRowData(sheet, rowStart + i, obj, orderCol);
//			}
//			
//			//为方便增加小计
//			if(sumStr != null && sumStr.length > 0){
//				int sumRow = datas.size()+2;
//				WritableCellFormat format = getDataCellFormat(CellType.NUMBER_FORMULA, Alignment.CENTRE);
//				insertOneCellData(sheet, 0, sumRow, "小计", format);
//				mergeCellsAndInsertData(sheet, 1, sumRow, orderCol.size()-1, sumRow, sumStr[0], format);
//			}
//			
//			workbook.write();
//			book.close();
//			workbook.close();
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * 用反射机制获取属性值
	 * @param fieldName
	 * @param obj
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Object getObjValByName(String fieldName,Object obj) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Method method = null;
		if(fieldName.indexOf(".") > 0){
			String[] tmpObjStrValue = fieldName.split("\\.");
			Object[] objs = new Object[tmpObjStrValue.length];
			Class[] cls = new Class[tmpObjStrValue.length];
			for (int i = 0; i < tmpObjStrValue.length; i++) {
				StringBuffer tmpBuffer = new StringBuffer();
				tmpBuffer.append("get");
				tmpBuffer.append(new String(tmpObjStrValue[i].substring(0, 1)).toUpperCase());
				tmpBuffer.append(new String(tmpObjStrValue[i].substring(1)));
				String strColValue = tmpBuffer.toString();
//				String strColValue = "get"
//						+ new String(tmpObjStrValue[i].substring(0, 1)).toUpperCase()
//						+ new String(tmpObjStrValue[i].substring(1));
				if (i == 0) {
					method = obj.getClass().getMethod(strColValue,
							new Class[] {});
					objs[0] = method.invoke(obj);
					if(null != objs[0]){
						cls[0] = objs[0].getClass();
					}else{
						logger.info("method get方法返回对象为空:"+cls[0]);
					}
				} else {
					if(null != cls[i-1]){
						method = cls[i - 1].getMethod(strColValue,
								new Class[] {});
						if(null != method){
							objs[i] = method.invoke(objs[i - 1]);
							if(null != objs[i]){
								cls[i] = objs[i].getClass();
							}else{
								logger.info("method get方法返回对象为空:"+cls[i - 1].getName());
							}
						}else{
							logger.info("未找到相关method方法:"+cls[i-1].getName());
						}
					}else{
						logger.info("未找到相关类!");
					}
				}
				
				tmpBuffer = null;
			}
			return objs[tmpObjStrValue.length - 1];
		}else{
			Object objTmp = null;
			Class clz = obj.getClass();
			StringBuffer tmpBuffer = new StringBuffer();
			tmpBuffer.append("get");
			tmpBuffer.append(new String(fieldName.substring(0, 1).toUpperCase()));
			tmpBuffer.append(new String(fieldName.substring(1)));
			String methodName = tmpBuffer.toString();
//			String methodName = "get"
//					+ new String(fieldName.substring(0, 1).toUpperCase())
//					+ new String(fieldName.substring(1));
			method = clz.getMethod(methodName, new Class[] {});
			objTmp = method.invoke(obj);
			if (objTmp == null) {
				objTmp = "";
			}
			tmpBuffer = null;
			return objTmp;
		}
	}

	// 测试
//	public static void main(String[] args) {
//
//		JExcelUtils jxl = new JExcelUtils();
//		// 创建目录
//		jxl.createDir("d:/ExcelTEMP/");
//		// 文件路径
//		String filePath = "d:/ExcelTEMP/test1.xls";
//		// 通过模板创建的文件路径
//		String filePath2 = "d:/ExcelTEMP/test2.xls";
//		
//		// 模板路径
//		String templateFilePath = "d:/ExcelTEMP/Template.xls";
//		
//		// 模拟标题
//		List<JExcelCell> titles = new ArrayList<JExcelCell>();
//		//titles.add(new JExcelCell( "学号", "classNo", "", "r" ,15));
//		//titles.add(new JExcelCell( "年龄", "age", "#.00", "r" ,15));
//		titles.add(new JExcelCell( "出生日期", "birthDate", "yyyy-MM-dd HH:mm", "C", 15 ));
//		titles.add(new JExcelCell( "姓名", "name", "", "c", 15 ));
//
//		Person p = new Person();
//		p.setClassNo("01");
//		p.setName("张");
//		p.setAge(1038283);
//		p.setBirthDate(new Date());
//		List<Person> dl = new ArrayList<Person>();
//		dl.add(p);
//		p = new Person();
//		p.setClassNo("02");
//		p.setName("李");
//		p.setAge(12329392);
//		p.setBirthDate(new Date());
//		dl.add(p);
//		
//		List<JExcelCell> orderCol = new ArrayList<JExcelCell>();
//		orderCol.add(new JExcelCell( "classNo", "", "c", 15 ));
//		orderCol.add(new JExcelCell( "age", "###,###.0", "r",15 ));
//		orderCol.add(new JExcelCell( "birthDate", "yyyy-MM-dd HH:mm", "C", 15 ));
//		orderCol.add(new JExcelCell( "name","","c",50));
//		
////		orderCol.add(new JExcelCell( "classNo"));
////		orderCol.add(new JExcelCell( "age"));
////		orderCol.add(new JExcelCell( "birthDate"));
////		orderCol.add(new JExcelCell( "name"));
//
//		// 创建Excel表格
//		try {
//			//jxl.createExcelFile(filePath, "成绩单", titles, dl);
//			
//			//从模板文件生成excel
//			//jxl.createExcelFileFromTemplate(filePath2, templateFilePath, 1, dl, orderCol);
//
//			// 读取excel文件
//			List<String[]> listFromExcel = jxl.readFromExcel(new File(filePath), 0);
//			for(int i = 0 ; i < listFromExcel.size() ; i++){
//				String[] strs = listFromExcel.get(i);
//				for(int j = 0 ; j < strs.length ; j++){
//					System.out.print(strs[j]+"   ");
//				}
//				System.out.println();
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}

class Person {

	private String classNo = "";

	private String name = "";

	private Date birthDate;

	private float age;

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

}
