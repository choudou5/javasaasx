package com.choudou5.javasaasx.base.util;

import com.choudou5.base.util.IdSeqUtil;

/**
 * @Name：系统序列工具类
 * @Author：xuhaowen
 * @Date：2018-01-20
 * @Site：http://www.javasaas.top
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public class SysSeqUtil extends IdSeqUtil{

    public SysSeqUtil() {
        super(1, 1, "javasaasx");
    }

    public SysSeqUtil(long dcId, long workerId, String signKey) {
        super(dcId, workerId, signKey);
    }

    public static void main(String[] args) {
        System.out.println(SysSeqUtil.getId());
        System.out.println(SysSeqUtil.encryptId("962253286751289344"));
    }

}
