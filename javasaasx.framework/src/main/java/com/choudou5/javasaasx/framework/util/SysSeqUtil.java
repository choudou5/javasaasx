package com.choudou5.javasaasx.framework.util;

import com.xiaoleilu.hutool.date.DatePattern;
import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.lang.Snowflake;

import java.util.Date;

/**
 * @Name：系统序列工具类
 * @Author：xuhaowen
 * @Date：2018-01-20
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public class SysSeqUtil {

    public static String getNextId() {
        return getIdBySnowflake()+"";
    }


    private static String getTime(){
        return DateUtil.format(new Date(), DatePattern.PURE_DATETIME_MS_PATTERN);
    }


    private static final long workerId = 1;//终端ID
    private static final long datacenterId = 1;//数据中心ID
    private static final Snowflake snowflake = new Snowflake(workerId, datacenterId);

    private static long getIdBySnowflake(){
        return snowflake.nextId();
    }

}
