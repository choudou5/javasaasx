package com.choudou5.javasaasx.base.util;

import com.choudou5.javasaasx.base.util.SpringContextHolder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @Name: 线程 工具类
 * @Author：xuhaowen
 * @Date：2018-03-01
 */
public class ThreadUtil {

    private static final ThreadPoolTaskExecutor EXECUTOR = SpringContextHolder.getBean("taskExecutor");

    public static void execute(Runnable runnable){
        EXECUTOR.execute(runnable);
    }

    public static Future sub(Runnable runnable){
        return EXECUTOR.submit(runnable);
    }

    public static <T> Future<T>  sub(Callable<T> runnable){
        return EXECUTOR.submit(runnable);
    }

}
