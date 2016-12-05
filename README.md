# FLogger
基于双缓存队列、多刷盘机制的超轻量级 java project log

# Features
1. 双缓存队列
2. 多种刷盘机制，支持时间触发、缓存大小触发、服务关闭强制触发等刷盘方式
3. 多种RollingFile机制，支持文件大小触发、按天触发等Rolling方式
4. 多日志级别，支持debug、info、warn、error和fatal等日志级别
5. 热加载，由日志事件触发热加载
6. 超轻量，不依赖任何第三方库
7. 性能保证，成功用于日交易额百亿级交易系统
    

# Usage  
```
FLogger logger = FLogger.getInstance();    //获取单例
logger.info("Here is your message..."); 
logger.writeLog(Constant.INFO, "Here is your customized level message...");
logger.writeLog("wrong", Constant.ERROR, "Here is your customized log file and level message...");
```

# Config
>log.properties(项目根路径下)

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
  
# License
MIT  

