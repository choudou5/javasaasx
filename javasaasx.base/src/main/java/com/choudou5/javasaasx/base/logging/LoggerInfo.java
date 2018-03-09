package com.choudou5.javasaasx.base.logging;


import com.choudou5.base.util.StrUtil;

import java.io.Serializable;

/**
 * @Name：LogNode 说明
 * @Author：xuhaowen
 * @Date：2018-03-08
 */
public class LoggerInfo implements Serializable, Comparable<LoggerInfo>  {

    public static final String ROOT_NAME = "ROOT";

    private String name;
    private String level;

    public LoggerInfo(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isSet() {
        return StrUtil.isNotBlank(level);
    }

    @Override
    public int compareTo(LoggerInfo other) {
        if (this.equals(other))
            return 0;
        String tN = this.getName();
        String oN = other.getName();

        if(ROOT_NAME.equals(tN))
            return -1;
        if(ROOT_NAME.equals(oN))
            return 1;
        return tN.compareTo(oN);
    }
}

