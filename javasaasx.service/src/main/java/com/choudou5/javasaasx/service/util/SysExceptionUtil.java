/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Name：系统异常 工具类
 * @Author：xuhaowende
 * @Date：2018-01-18
 */
public class SysExceptionUtil {

    private static Logger logger = LoggerFactory.getLogger(SysExceptionUtil.class);

    public static void error(String defMsg, Exception e){
        logger.error(defMsg, e);
        //保存 到异常表
    }
}
