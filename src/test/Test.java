package test;

import com.FLogger;
import com.constants.Constant;

public class Test {
	
	public static void main(String[] args) {
		FLogger logger = FLogger.getInstance();    //获取单例
		logger.info("Here is your message...");
		logger.writeLog(Constant.INFO, "Here is your customized level message...");
		logger.writeLog("wrong", Constant.ERROR, "Here is your customized log file and level message...");
	}

}
