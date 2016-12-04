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

# config
>log.properties  

```
########## 公共环境配置 ##########
# 字符集
CHARSET_NAME = UTF-8
########## 日志信息配置 ##########
# 日志级别   0:调试信息  1:普通信息   2:警告信息  3:错误信息  4:严重错误信息 
LOG_LEVEL = 0,1,2,3,4
# 日志文件存放路径
LOG_PATH =./log
# 日志写入文件的间隔时间(默认为1000毫秒)
WRITE_LOG_INV_TIME = 1000
# 单个日志文件的大小(默认为10M)
SINGLE_LOG_FILE_SIZE = 10485760
# 单个日志文件缓存的大小(默认为10KB)
SINGLE_LOG_CACHE_SIZE = 10240
```  
