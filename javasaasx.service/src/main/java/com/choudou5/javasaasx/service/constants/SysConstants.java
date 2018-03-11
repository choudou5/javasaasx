package com.choudou5.javasaasx.service.constants;

/**
 * @Name：系统 常量
 * @Author：xuhaowende
 * @Date：2018-01-18
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public interface SysConstants {

    /**
     * 菜单类型
     */
    enum MenuTypeEnum {
        MENU("menu", "菜单"),
        BUTTOM("buttom", "按钮"),
        ;
        MenuTypeEnum(String type, String typeName) {
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

    enum MenuPermEnum {
        VIEW("查看"),
        ADD("新增"),
        EDIT("修改"),
        DEL("删除"),
        ;
        MenuPermEnum(String desc) {
            this.desc = desc;
        }

        private String desc;
        public String getDesc() {
            return desc;
        }

        public static String getName(String key){
            MenuPermEnum[] vals = values();
            for (MenuPermEnum val : vals) {
                if(val.getDesc().equals(key))
                    return val.name().toLowerCase();
            }
            return null;
        }

    }


}
