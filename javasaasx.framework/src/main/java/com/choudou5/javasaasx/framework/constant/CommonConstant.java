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

    enum DataStatusEnum {
        NO("0", "禁用"),
        OK("1", "正常"),
        ;

        DataStatusEnum(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        private String code;
        private String desc;

        public static String getCodeByCheckBoxOrRadio(String code){
            if("on".equals(code))
                return OK.getCode();
            if("off".equals(code))
                return NO.getCode();
            return code;
        }

        public String getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }
    }

}
