package com.choudou5.javasaasx.service.impl.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Name：系统异常 工具类
 * @Author：xuhaowende
 * @Date：2018-01-18
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public class SysExceptionUtil {

    private static Logger logger = LoggerFactory.getLogger(SysExceptionUtil.class);

    public static void error(String defMsg, Exception e){
        logger.error(defMsg, e);
        //保存 到异常表
    }
}
