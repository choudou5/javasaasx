package com.choudou5.javasaasx.service.impl.util;

import com.choudou5.javasaasx.common.util.SpringContextHolder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Name: 任务工具类
 * @Author：xuhaowen
 * @Date：2018-03-01
 */
public class TaskUtil {

    public static final ThreadPoolTaskExecutor EXECUTOR = SpringContextHolder.getBean("taskExecutor");

}
