package com.huanghy.onekey_switch_properties.dcuc_org;

import com.huanghy.onekey_switch_properties.common.OutputOrderProperties;

/**
 * <pre>
 *     包括类、接口的目的、作用、功能、继承于何种父类，
 *     实现的接口、实现的算法、使用方法、示例程序等，
 *     当然还可以包括期望改进工作的地方和不希望改变的地方。
 * </pre>
 * JDK版本：JDK1.7
 *
 * @author huanghy <br>create on 2019/03/10
 */

public class OrgCommonProperties {

    public static OutputOrderProperties duceapProperties(OutputOrderProperties p) {
        p.put("application.name","dcuc-org","系统名称");
        p.put("application.cnname","用户中心","用户中心系统名称");
        p.put("application.version","0.5","系统版本号");
        p.put("application.owner","dragonsoft","负责人");

            /*spring加载路径，不配置默认情况下如下：
            duceap.spring.config=classpath*:resource/applicationContext-*.xml

            ###############################dubbo配置####################################*/
        p.put("dubbo.registry.address","zookeeper://127.0.0.1:2181","dubbo注册地址[修改]");
        p.put("dubbo.protocol.port","21890","dubbo开放端口[修改]");
        p.put("dubbo.timeout","30000","dubbo超时时间");
        p.put("message.topic","20100028","消息主题");
        return p;
    }
}
