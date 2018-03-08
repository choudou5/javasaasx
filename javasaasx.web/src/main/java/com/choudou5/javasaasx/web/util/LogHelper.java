/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.util;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.choudou5.base.util.CollUtil;
import com.choudou5.base.util.StrUtil;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @Name：日志助手
 * @Author：xuhaowen
 * @Date：2018-01-23
 */
public class LogHelper {

    /** 日志 级别*/
    public static final String[] LEVELS = new String[]{"ALL", "TRACE", "DEBUG", "INFO", "WARN", "ERROR", "FATAL", "OFF"};


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

//    public static List<Logger> getLogList(){
//        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
//        return loggerContext.getLoggerList();
//    }

    public static Collection<LoggerInfo> getLogList(){
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        List<Logger> list = loggerContext.getLoggerList();
        Logger root = loggerContext.getLogger(LoggerInfo.ROOT_NAME);
        Map<String, LoggerInfo> map = new HashMap<>(64);
        if(CollUtil.isNotEmpty(list)){
            String name = null;
            Level level = null;
            for (Logger log : list) {
                name = log.getName();
                if (name.equals(Logger.ROOT_LOGGER_NAME)) {
                    continue;
                }
                level = log.getLevel();
                map.put(name, new LoggerInfo(name, level!=null?level.levelStr:null));
                while (true) {
                    int dot = name.lastIndexOf(".");
                    if (dot < 0)
                        break;
                    name = name.substring(0, dot);
                    if (!map.containsKey(name)) {
                        map.put(name, new LoggerInfo(name, null));
                    }
                }
            }
        }
        map.put(LoggerInfo.ROOT_NAME, new LoggerInfo(LoggerInfo.ROOT_NAME, root.getLevel()!=null?root.getLevel().levelStr:null));
        return map.values();
    }

    private List<LoggerInfo> buildLogNode(List<Logger> list){
        List<LoggerInfo> result = new ArrayList<>();
        if(CollUtil.isNotEmpty(list)){
            Map<String, Integer> tree = new HashMap<>();

        }
        return result;
    }

    private int getOfficeDepth(Map<String, Integer> tree, String id, String pid){
        Integer depth = tree.get(pid);
        if(depth == null){
            depth = 1;
            tree.put(pid, 1);
        }else{
            if(!pid.equals("1"))
                depth++;
        }
        tree.put(id, depth);
        return depth;
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
