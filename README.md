# FLogger
基于双缓存队列、多刷盘机制的超轻量级 java log

# features
1. 双缓存队列
2. 多种刷盘机制，支持按时间、按大小、强制刷盘等方式
3. 热加载，定时加载更新的配置而无需重启
4. 超轻量，不依赖任何第三方库
5. 多日志级别，支持debug、info、warn、error和fatal等日志基本
6. 性能保证
  
# usage  
```
FLogger logger = FLogger.getInstance();    //获取单例
logger.info("Here is your message..."); 
logger.writeLog(Constant.INFO, "Here is your customized level message...");
logger.writeLog("wrong", Constant.ERROR, "Here is your customized log file and level message...");
```

