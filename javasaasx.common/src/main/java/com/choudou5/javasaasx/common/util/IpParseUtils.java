package com.choudou5.javasaasx.common.util;
import com.choudou5.base.util.PrintUtil;
import com.choudou5.base.util.ip.IPParseUtil;

/**
 * @Name：IpParseUtils 说明
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class IpParseUtils {

    private static final String PATH = "D:\\dev\\ip\\qqwry.dat";

    public static void main(String[] args) {
        PrintUtil.println(getIpSource("185.159.128.197"));
    }

    /**
     * 获取 ip来源
     * @param ip
     * @return
     */
    public static String getIpSource(String ip){
        return IPParseUtil.getInstance(PATH).getAddress(ip);
    }

}
