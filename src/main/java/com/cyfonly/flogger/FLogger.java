package com.cyfonly.flogger;

import com.cyfonly.flogger.constants.Constant;
import com.cyfonly.flogger.constants.Constant.LogLevel;
import com.cyfonly.flogger.strategy.LogManager;
import com.cyfonly.flogger.utils.CommUtil;
import com.cyfonly.flogger.utils.TimeUtil;

/**
 * 日志工具类
 * @author yunfeng.cheng
 * @version 2015/10/31
 */
public class FLogger {
	
	private static FLogger instance;
	private static LogManager logManager;
	
	static {
		logManager = LogManager.getInstance();
	}
	
	public FLogger(){
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//			@Override
			public void run() {
				close();
			}
		}));
	}
	
	public static synchronized FLogger getInstance(){
		if(instance == null){
			instance = new FLogger();
		}
		return instance;
	}
	
	/**
	 * 写调试日志
	 * @param logMsg 日志内容
	 */
	public void debug(String logMsg){
		writeLog("debug",LogLevel.DEBUG,logMsg);
	}
	
	/**
	 * 写普通日志
	 * @param logMsg 日志内容
	 */
	public void info(String logMsg){
		writeLog("info",LogLevel.INFO,logMsg);
	}
	
	/**
	 * 写警告日志
	 * @param logMsg 日志内容
	 */
	public void warn(String logMsg){
		writeLog("warn",LogLevel.WARN,logMsg);
	}
	
	/**
	 * 写错误日志
	 * @param logMsg 日志内容
	 */
	public void error(String logMsg){
		writeLog("error",LogLevel.ERROR,logMsg);
	}
	
	/**
	 * 写严重错误日志
	 * @param logMsg 日志内容
	 */
	public void fatal(String logMsg){
		writeLog("fatal",LogLevel.FATAL,logMsg);
	}
	
	/**
	 * 写系统日志
	 * @param level 日志级别
	 * @param logMsg 日志内容
	 */
	public void writeLog(LogLevel level,String logMsg){
		writeLog(level.name(),level,logMsg);
	}
	
	/**
	 * 写日志
	 * @param logFileName 日志文件名
	 * @param level 日志级别
	 * @param logMsg 日志内容
	 */
	public void writeLog(String logFileName, LogLevel level, String logMsg){
		if(logMsg != null && CommUtil.contains(level)){
			StringBuffer sb = new StringBuffer(logMsg.length() + 100);
			sb.append("[");
			sb.append(level.name());
			sb.append("] ");
			sb.append(TimeUtil.getFullDateTime());
			sb.append(" [");
			sb.append(Thread.currentThread().getName());
			sb.append("] ");
			sb.append(logMsg);
			sb.append("\n");
			logManager.addLog(logFileName, sb);
			
			//错误信息强制打印到控制台；若 CONSOLE_PRINT 配置为 true，也将日志打印到控制台
			if(LogLevel.ERROR == level || LogLevel.FATAL == level || Constant.CONSOLE_PRINT){
				try{
					System.out.print(new String(sb.toString().getBytes(Constant.CFG_CHARSET_NAME),Constant.CFG_CHARSET_NAME));
				}catch(Exception e){
					System.out.print(CommUtil.getExpStack(e));
				}
			}
		}
	}
	
	/**
	 * 优雅关闭
	 */
	private void close(){
		logManager.close();
	}
	
}
