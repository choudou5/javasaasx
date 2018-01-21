package com.choudou5.javasaasx.framework.constant;

/**
 * @Name：公共常量
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-16
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public interface CommonConstant {

    final String STATUS_N = "0";
    final String STATUS_Y = "1";

    enum DataStatusEnum {
        N(STATUS_N, "禁用"),
        Y(STATUS_Y, "正常"),
        ;

        DataStatusEnum(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        private String code;
        private String desc;

        public static String getCodeByCheckBoxOrRadio(String code){
            return getCodeByCheckBoxOrRadio(code, code);
        }

        public static String getCodeByCheckBoxOrRadio(String code, String def){
            if("on".equals(code))
                return Y.getCode();
            if("off".equals(code))
                return N.getCode();
            return def;
        }

        public String getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }
    }

}
