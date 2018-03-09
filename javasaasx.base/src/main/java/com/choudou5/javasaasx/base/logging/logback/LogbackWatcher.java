package com.choudou5.javasaasx.base.logging.logback;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.classic.spi.ThrowableProxy;
import com.choudou5.base.exception.Exceptions;
import com.choudou5.base.util.CollUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.base.logging.CircularList;
import com.choudou5.javasaasx.base.logging.ListenerConfig;
import com.choudou5.javasaasx.base.logging.LogWatcher;
import com.choudou5.javasaasx.base.logging.LoggerInfo;
import org.slf4j.LoggerFactory;

import java.util.*;

public class LogbackWatcher extends LogWatcher<LoggingEvent> {

    private static LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    private Logger root = loggerContext.getLogger(LoggerInfo.ROOT_NAME);

    @Override
    public void setLogLevel(String category, String level) {
        //设置某个类日志级别-可以实现定向日志级别调整
        ch.qos.logback.classic.Logger logger = loggerContext.getLogger(category);
        if (logger != null){
            if (!StrUtil.isBlank(level)) {
                logger.setLevel(Level.toLevel(level));
            }else{
                if("unset".equals(level)||"null".equals(level)) {
                    logger.setLevel(null);
                }
            }
        }
    }

    @Override
    public Collection<LoggerInfo> getAllLoggers() {
        List<Logger> list = loggerContext.getLoggerList();
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

    @Override
    public void registerListener(ListenerConfig cfg) {
        if(history!=null) {
            throw new IllegalStateException("History already registered");
        }
        history = new CircularList<>(cfg.size);
    }

    @Override
    public long getTimestamp(LoggingEvent event) {
        return event.getTimeStamp();
    }

    @Override
    public Map toDoc(LoggingEvent event) {
        Map doc = new HashMap<>();
        doc.put("time", new Date(event.getTimeStamp()));
        doc.put("level", event.getLevel().toString());
        doc.put("logger", event.getLoggerName());
        doc.put("message", event.getMessage());
        ThrowableProxy t = (ThrowableProxy)event.getThrowableProxy();
        event.getLoggerContextVO();
        if(t!=null) {
            doc.put("trace", Exceptions.getStackTraceAsString(t.getThrowable()));
        }
        return doc;
    }
}