package com.choudou5.javasaasx.common.util;

import cn.hutool.core.util.StrUtil;

/**
 * @Name：公共 工具类
 * @Author：xuhaowende
 * @Date：2018-02-18
 */
public class CommUtil {

    public static String getBoolCode(boolean flag){
        return flag?"Y":"N";
    }

    public static String getBoolNum(boolean flag){
        return flag?"1":"0";
    }
}
