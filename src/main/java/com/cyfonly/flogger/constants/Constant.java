package com.cyfonly.flogger.constants;
import java.util.HashMap;
import java.util.Map;
import com.cyfonly.flogger.utils.CommUtil;

/**
 * 常量
 * @author yunfeng.cheng
 * @version 2015/10/31
 */
public final class Constant {

	//------------------日志类型
	public static enum LogLevel {
		DEBUG,/** 调试信息  */
		INFO,/** 普通信息 */
		WARN,/** 警告信息 */	
		ERROR,/** 错误信息 */
		FATAL/** 严重错误信息 */
	}
	
	/**日志级别*/
	public static String CFG_LOG_LEVEL = CommUtil.getConfigByString("LOG_LEVEL","0,1,2,3,4");
	
	/**是否输出到控制台*/
	public static boolean CONSOLE_PRINT = CommUtil.getConfigByBoolean("CONSOLE_PRINT",Boolean.FALSE);
	
	/**当前运行环境的字符集*/
	public static String CFG_CHARSET_NAME = CommUtil.getConfigByString("CHARSET_NAME","UTF-8");
	
	/**日志文件路径*/
	public static String CFG_LOG_PATH = CommUtil.getConfigByString("LOG_PATH","./log");
	
}