package com.huanghy.onekey_switch_properties.dcuc_list;

import com.huanghy.onekey_switch_properties.common.OutputOrderProperties;

/**
 * <pre>
 * </pre>
 * JDK版本：JDK1.7
 *
 * @author huanghy <br>create on 2019/03/10
 */

public class ListCommonProperties {

    public static OutputOrderProperties duceapProperties(OutputOrderProperties p) {
        p.put("application.name","dcuc-list","系统名称");
        p.put("application.version","0.5","系统版本号");
        p.put("application.owner","dragonsoft","负责人");

        //###############################dubbo配置####################################*/
        p.put("dubbo.registry.address","zookeeper://127.0.0.1:2181","dubbo注册地址[修改]");
        p.put("dubbo.protocol.port","21895","dubbo开放端口[修改]");
        p.put("dubbo.timeout","30000","dubbo超时时间");
        return p;
    }
}
