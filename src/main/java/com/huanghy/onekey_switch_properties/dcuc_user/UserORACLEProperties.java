package com.huanghy.onekey_switch_properties.dcuc_user;

import com.huanghy.onekey_switch_properties.common.Constants;
import com.huanghy.onekey_switch_properties.common.OutputOrderProperties;
import com.huanghy.onekey_switch_properties.common.FlywayCommonProperties;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * <pre>
 * </pre>
 * JDK版本：JDK1.7
 *
 * @author huanghy <br>create on 2019/03/10
 */

public class UserORACLEProperties {

    public static void main(String[] args) {
        duceapProperties(Constants.USER_DUCEAP_PROPRETIES_FILEPATH);
        System.out.println("用户服务 duceap.properties Oracle配置写入成功!");

        flywayProperties(Constants.USER_FLYWAY_PROPRETIES_FILEPATH);
        System.out.println("用户服务 flyway Oracle配置写入成功!");


    }

    public static void duceapProperties(String paramFile) {
        try {
            OutputOrderProperties p = new OutputOrderProperties();
//            FileInputStream fs = new FileInputStream("模板文件路径");
//            p.load(new InputStreamReader(fs, "utf-8"));
            String jdbcUrl = "jdbc:oracle:thin:@192.168.10.6:1521:orcl";
            p.put("jdbc.url", jdbcUrl,
                    "数据库链接[开发环境中使用，并用于Flyway执行脚本]");
            p.put("jdbc.username","yhglpt_user","数据库名称[开发环境中使用，并用于Flyway执行脚本]");
            p.put("jdbc.password","dragon_2018","数据库密码[开发环境中使用，并用于Flyway执行脚本]");
            p.put("jdbc.driver","oracle.jdbc.driver.OracleDriver");
            p.put("jdbc.pool.maxIdle","10");
            p.put("jdbc.pool.maxActive","30");
            p.put("jdbc.databaseType","oracle");
            p.put("hibernate.dialect","org.hibernate.dialect.Oracle9Dialect");

            p = com.huanghy.onekey_switch_properties.dcuc_user.UserCommonProperties.duceapProperties(p);

            p.orderStore(new OutputStreamWriter(new FileOutputStream(paramFile), "utf-8"),
                    null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void flywayProperties(String filePath) {
        FlywayCommonProperties.flywayProperties(filePath,"sql");
    }
}
