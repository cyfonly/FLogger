package com.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Properties;
import com.FLogger;
import com.constants.Constant;

/**
 * 公用工具类
 * @author yunfeng.cheng
 * @version 2015/10/31
 */
public class CommUtil {
	
	/** 配置map */
	private static HashMap<String,Object[]> propsMap = new HashMap<String,Object[]>();
	
	/**
	 * 从配置文件中取得字符串的值，若无则返回默认值
	 * @param keyName
	 * @param defaultValue
	 * @return
	 */
	public static String getConfigByString(String keyName,String defaultValue){
		String value = getConfig(keyName);
		if(value != null && value.length() > 0){
			return value.trim();
		}else{
			return defaultValue;
		}
	}
	
	/**
	 * 从配置文件中取得整型的值，若无则返回默认值
	 * @param keyName
	 * @param defaultValue
	 * @return
	 */
	public static int getConfigByInt(String keyName,int defaultValue){
		String value = getConfig(keyName);
		if(value != null && value.length() > 0){
			return Integer.parseInt(value.trim());
		}else{
			return defaultValue;
		}
	}
	
	/**
	 * 从默认配置文件中读取字符串的值
	 * @param keyName
	 * @return
	 */
	public static String getConfig(String keyName) {
		return CommUtil.getConfig("log.properties",keyName);
	}
	
	/**
	 * 从配置文件中读取字符串的值
	 * @param fileName
	 * @param keyName
	 * @return
	 */
	public static String getConfig(String fileName,String keyName) {
		Properties props = null;
		boolean bIsNeedLoadCfg = false;

		File cfgFile = new File(fileName);
		if(!cfgFile.exists()){
			return "";
		}
		
		Object[] arrs = propsMap.get(fileName);
		if(arrs == null){
			bIsNeedLoadCfg = true ;
		}else{
			Long lastModify = (Long)arrs[0];
			if(lastModify.longValue() != cfgFile.lastModified()){
				bIsNeedLoadCfg = true;
			}else{
				props = (Properties)arrs[1];
			}
		}
		
		if(bIsNeedLoadCfg == true){
			FileInputStream fis = null;
			try{
				fis = new FileInputStream(cfgFile);
				props = new Properties();		
				props.load(fis);
				propsMap.put(fileName, new Object[]{cfgFile.lastModified(),props});
			}catch (Exception e) {
				return "";
			}finally{
				try{
					if(fis != null){
						fis.close();
					}
				}catch(Exception e){;}
			}
		}
		return props.getProperty(keyName, "");
	}
	
	/**
	 * 将字符串转为字节数组
	 * @param str
	 * @return
	 */
	public static byte[] StringToBytes(String str) {
		try{
			if(str == null || str.length() <= 0){
				return new byte[0];
			}else{
				return str.getBytes(Constant.CFG_CHARSET_NAME);
			}
		}catch(Exception e){
			FLogger.writeLog("Error", Constant.ERROR, getExpStack(e));
		}
		return null;
	}
	
	/**
	 * 将异常的堆栈信息转为字符串
	 * @param e 异常
	 * @return
	 */
	public static String getExpStack(Exception e) {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		PrintWriter pw = new PrintWriter(bo);
		e.printStackTrace(pw);
		pw.flush();
		pw.close();
		return bo.toString();
	}
	
}
