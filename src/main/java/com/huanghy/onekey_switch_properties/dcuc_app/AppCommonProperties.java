package com.huanghy.onekey_switch_properties.dcuc_app;

import com.huanghy.onekey_switch_properties.common.OutputOrderProperties;

/**
 * <pre>
 * </pre>
 * JDK版本：JDK1.7
 *
 * @author huanghy <br>create on 2019/03/10
 */

public class AppCommonProperties {

    public static OutputOrderProperties duceapProperties(OutputOrderProperties p) {
        p.put("application.name","dcuc-app","系统名称");
        p.put("application.cnname","用户中心","用户中心系统名称");
        p.put("application.version","0.5","系统版本号");
        p.put("application.owner","dragonsoft","负责人");

        //###############################dubbo配置####################################*/
        p.put("dubbo.registry.address","zookeeper://127.0.0.1:2181","dubbo注册地址[修改]");
        p.put("dubbo.protocol.port","21898","dubbo开放端口[修改]");
        p.put("dubbo.timeout","30000","dubbo超时时间");

        p.put("message.topic","90220006","消息主题");
        return p;
    }
}
