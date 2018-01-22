package com.choudou5.javasaasx.web.util;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.xiaoleilu.hutool.util.StrUtil;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Name：日志助手
 * @Author：xuhaowen
 * @Date：2018-01-23
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public class LogHelper {

    /**
     * 设置 日志级别
     * @param name  包名或 类名 （越具体越好）
     * @param level 日志级别 OFF、ERROR、WARN、INFO、DEBUG、TRACE、ALL
     */
    public static void setLevel(String name, String level){
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        if (!StrUtil.isBlank(level)) {
            //设置某个类日志级别-可以实现定向日志级别调整
            ch.qos.logback.classic.Logger logger = loggerContext.getLogger(name);
            if (logger != null)
                logger.setLevel(Level.toLevel(level));
        }
    }

    public static void printLogList(){
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        List<Logger> loggerList = loggerContext.getLoggerList();
        for (ch.qos.logback.classic.Logger logger : loggerList){
            System.out.println(logger.getName()+" : "+logger.getLevel());
        }
    }

    /**
     * 设置 根日志 级别
     * @param level
     */
    public static void setRootLevel(String level){
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
//        //设置全局日志级别
        ch.qos.logback.classic.Logger logger = loggerContext.getLogger("root");
        logger.setLevel(Level.toLevel(level));
    }

}
