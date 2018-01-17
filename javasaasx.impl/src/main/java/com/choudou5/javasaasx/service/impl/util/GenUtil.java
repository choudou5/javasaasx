package com.choudou5.javasaasx.service.impl.util;

import com.choudou5.javasaasx.service.constants.GenConstants;

/**
 * @Name：生成 工具类
 * @Author：xuhaowende
 * @Date：2018-01-18
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public class GenUtil {

    /**
     * 获取 生成页面类型 枚举列表
     * @return
     */
    public static GenConstants.GenPageTypeEnum[] genPageTypeEnums(){
        return GenConstants.GenPageTypeEnum.values();
    }


}
