package com.huanghy.onekey_switch_properties.common;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * <pre>
 * </pre>
 * JDK版本：JDK1.7
 *
 * @author huanghy <br>create on 2019/03/10
 */

public class FlywayCommonProperties {

    public static void flywayProperties(String filePath,String flywayLocation) {
        try {
            OutputOrderProperties p = new OutputOrderProperties();
            p.put("TABLESPACE_DATA", "USERS",
                    "数据表空间");
            p.put("TABLESPACE_INDEX","USERS","索引表空间");
            p.put("TABLESPACE_LOB","USERS","大字段表空间");

            p.put("flyway.locations","classpath:resource/"+flywayLocation,"flyway脚本目录");
            p.put("flyway.placeholderPrefix","#{");
            p.put("flyway.placeholderSuffix","}");
            p.put("flyway.outOfOrder","true");
            p.put("flyway.initOnMigrate","true");
            p.put("flyway.initVersion","0.5.0");
            p.put("flyway.ignoreFailedFutureMigration","false");
            p.put("flyway.disable","true","flayway自动执行[false：开启（默认）、true:关闭]");
            p.orderStore(new OutputStreamWriter(new FileOutputStream(filePath), "utf-8"),
                    null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
