package com.choudou5.javasaasx.base.logging.util;


import com.choudou5.javasaasx.base.logging.LogWatcher;
import com.choudou5.javasaasx.base.logging.LoggerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Name：日志管理 助手
 * @Author：xuhaowen
 * @Date：2018-03-09
 */
public class LogAdminHelper {

    protected static Logger log = LoggerFactory.getLogger(LogAdminHelper.class);

    private static LogWatcher watcher;

    private LogAdminHelper() {
    }

    public static void setWatcher(LogWatcher logWatcher) {
        if(watcher != null)
            throw new RuntimeException("已初始化---日志观察者");
        log.info("初始化-----日志观察");
        watcher = logWatcher;
    }

    public static void setLevel(String name, String level) {
        if(watcher==null) {
            throw new RuntimeException("未初始化---日志观察者");
        }
        watcher.setLogLevel(name, level);
    }

    public static Map getLogHistory(Long time) {
        Map result = new HashMap<>(2);
        if(watcher==null || time==null) {
            return result;
        }
        AtomicBoolean found = new AtomicBoolean(false);
        List<Map> docs = watcher.getHistory(time, found);
        if(docs==null) {
            return result;
        }
        else {
            Map info = new HashMap<>();
            if(time>0) {
                info.put("since", time);
                info.put("found", found);
            }else {
                info.put("levels", watcher.getAllLevels()); // show for the first request
            }
            info.put("last", watcher.getLastEvent());
            info.put("buffer", watcher.getHistorySize());

            result.put("info", info);
            result.put("history", docs);
            result.put("watcher", "xxxxxx");
        }
        return result;
    }

    public static Map getLogListInfo() {
        Map result = new HashMap<>(2);
        if(watcher==null) {
            return result;
        }
        result.put("levels", watcher.getAllLevels());
        List<LoggerInfo> loggers = new ArrayList<>(watcher.getAllLoggers());
        Collections.sort(loggers);
        List<LoggerInfo> infos = new ArrayList<>();
        for(LoggerInfo info:loggers) {
            infos.add(info);
        }
        result.put("loggers", infos);
        return result;
    }

    public static void stop() {
        if(watcher==null) {
            return;
        }
        log.info("停止-----日志观察");
        watcher.reset();
    }

}