package com.huanghy.onekey_switch_properties.common;

/**
 * <pre>
 * </pre>
 * JDK版本：JDK1.5
 *
 * @author huanghy <br>create on 2019/03/10
 */
public enum DataBaseTypeEnum {

    ORACLE("ORACLE","ORACLE数据库"),
    MYSQL("MYSQL","MYSQL数据库");

    private String code;
    private String name;

    DataBaseTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
