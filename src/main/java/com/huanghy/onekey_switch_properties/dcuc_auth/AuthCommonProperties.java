package com.huanghy.onekey_switch_properties.dcuc_auth;

import com.huanghy.onekey_switch_properties.common.OutputOrderProperties;

/**
 * <pre>
 * </pre>
 * JDK版本：JDK1.7
 *
 * @author huanghy <br>create on 2019/03/10
 */

public class AuthCommonProperties {

    public static OutputOrderProperties duceapProperties(OutputOrderProperties p) {
        p.put("application.name","dcuc-auth","系统名称");
        p.put("application.version","0.5","系统版本号");
        p.put("application.owner","dragonsoft","负责人");

        p.put("zookeeper.address","127.0.0.1:2181","zookeeper地址[修改]");

        //###############################dubbo配置####################################*/
        p.put("dubbo.registry.address","zookeeper://127.0.0.1:2181","dubbo注册地址[修改]");
        p.put("dubbo.protocol.port","21896","dubbo开放端口[修改]");
        p.put("dubbo.timeout","30000","dubbo超时时间");

        p.put("app.code","YHZX0000000000000001","应用code");
        p.put("normal.role.code","DCUC_COMMON_USER","普通用户角色代码roleCode");
        p.put("manager.role.code","DCUC_MANAGER","各级管理员角色代码roleCode");
        return p;
    }
}
