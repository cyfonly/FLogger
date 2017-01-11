![design](https://github.com/cyfonly/FLogger/blob/master/FLogger.png "FLooger")  
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/cyfonly/FLogger/blob/master/LICENCE)  [![Built with Maven](http://maven.apache.org/images/logos/maven-feather.png)](http://search.maven.org/#search%7Cga%7C1%7Ccyfonly)  
基于双缓冲队列、多刷盘机制的超轻量级 java 日志  

# Features
1. 双缓冲队列
2. 多种刷盘机制，支持时间触发、缓存大小触发、服务关闭强制触发等刷盘方式
3. 多种RollingFile机制，支持文件大小触发、按天触发等Rolling方式
4. 多日志级别，支持debug、info、warn、error和fatal等日志级别
5. 热加载，由日志事件触发热加载
6. 超轻量，不依赖任何第三方库
7. 性能保证，成功用于日交易额百亿级交易系统
    

# Usage  
#### 1. Maven

```
<dependency>
    <groupId>com.github.cyfonly</groupId>
    <artifactId>flogger</artifactId>
    <version>1.0.0</version>
</dependency>
```  
#### 2. flogger.properties  
see `Config`  

#### 3. In your project code
```
//获取单例
FLogger logger = FLogger.getInstance();
//简便api,只需指定内容
logger.info("Here is your message...");
//指定日志级别和内容，文件名自动映射
logger.writeLog(Constant.WARN, "Here is your customized level message...");
//指定日志输出文件名、日志级别和内容
logger.writeLog("error", Constant.ERROR, "Here is your customized log file and level message...");
```
# Output  

#### info.log  

```
[INFO] 2016-12-06 21:07:32:840 [main] Here is your message...
```  
#### warn.log  

```
[WARN] 2016-12-06 21:07:32:842 [main] Here is your customized level message...
```  
#### error.log  

```
[ERROR] 2016-12-06 21:07:32:842 [main] Here is your customized log file and level message...
```


# Config  
#### 1. 配置文件名称  
flogger.properties  
#### 2. 配置文件加载顺序  
1. 项目根路径
2. src/main/resources
3. 默认配置  

#### 3. 配置项  

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

# Demo
see [https://github.com/cyfonly/FLogger/tree/master/src/test](https://github.com/cyfonly/FLogger/tree/master/src/test)  

# License  
基于 Apache License 2.0 发布。有关详细信息，请参阅 [LICENCE](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/cyfonly/FLogger/blob/master/LICENCE)
