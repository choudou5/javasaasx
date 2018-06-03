package com.choudou5.javasaasx.common.constants;

/**
 * @Name：代码生成 常量
 * @Author：xuhaowende
 * @Date：2018-01-18
 * @Site：http://www.javasaas.top
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public interface GenConstants {

    /**
     * 生成页面类型
     */
    enum GenPageTypeEnum {
        LIST("list", "单列表"),
        LIST_LEFT_TREE("listLeftTree", "树+列表"),
        LIST_LEFT_LIST("listLeftList", "双列表"),
        ;

        GenPageTypeEnum(String type, String typeName) {
            this.type = type;
            this.typeName = typeName;
        }

        private String type;
        private String typeName;

        public String getType() {
            return type;
        }
        public String getTypeName() {
            return typeName;
        }

        public boolean eq(String type){
            return this.getType().equals(type);
        }

    }
}
