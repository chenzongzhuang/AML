package com.aml.common.export;

import java.io.BufferedWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>Title:  上海银行商户管理系统</p>
 * <p>Description: CSV导入/导出通用类</p>
 * <p></p>
 * <p>Company: 上海恩梯梯数据晋恒软件有限公司</p>
 * @author lqh
 * @version 1.0
 */
public class CSVUtils {

	private static Logger logger = LoggerFactory.getLogger(CSVUtils.class);

	/**
	 * 插入标题
	 * 
	 * @param sheet
	 * @param row
	 * @param data
	 * @param format
	 * @throws Exception
	 */
	public void insertTitle(BufferedWriter csvFileOutputStream,List<JExcelCell> col) throws Exception {
		try {
			String str = "";
			for (int i = 0; i < col.size(); i++) {
				JExcelCell cell = col.get(i);
				String titleName = cell.getDataIndex();
				//str += titleName==null?"\""+"\"":"\""+titleName.toString()+"\"";
				str += titleName==null?"":titleName.toString();
				if(i < col.size() - 1) {
					str += ",";
				}
			}
            // 写入文件内容
            csvFileOutputStream.write(str);  
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
	public <T> void insertRowData(BufferedWriter csvFileOutputStream,T data,List<JExcelCell> col) throws Exception {
		try {
			String str = "";
			for (int i = 0; i < col.size(); i++) {
				JExcelCell cell = col.get(i);
				Object objTmp = null;
				if (cell.getDataName() != null && !"".equals(cell.getDataName())) {
					String[] fieldNames = cell.getDataName().split(",");
					if (fieldNames.length == 2) {
						objTmp = getObjValByName(fieldNames[1],getObjValByName(fieldNames[0],data));
					} else {
						String fieldName = cell.getDataName();
						objTmp = getObjValByName(fieldName,data);
					}
				}
				//str += objTmp==null?"\""+"\"":"\""+objTmp.toString()+"\"";
				str += objTmp==null?"":objTmp.toString().trim();
				if(i < col.size() - 1) {
					str += ",";
				}
				
				
			}
            // 写入文件内容
            csvFileOutputStream.write(str);  
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

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
			method = clz.getMethod(methodName, new Class[] {});
			objTmp = method.invoke(obj);
			if (objTmp == null) {
				objTmp = "";
			}
			tmpBuffer = null;
			return objTmp;
		}
	}
 
}