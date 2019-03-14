package com.huanghy.onekey_switch_properties.dcuc_webapp;

import com.huanghy.onekey_switch_properties.common.OutputOrderProperties;

/**
 * <pre>
 * </pre>
 * JDK版本：JDK1.7
 *
 * @author huanghy <br>create on 2019/03/10
 */

public class WebappCommonProperties {

    public static OutputOrderProperties duceapProperties(OutputOrderProperties p) {
        p.put("application.name","dcuc-webapp","系统名称");
        p.put("application.version","0.5","系统版本号");
        p.put("application.owner","dragonsoft","负责人");

        p.put("application.servlet.contextpath","dcuc","Servlet上下文");
        p.put("application.servlet.port","8889","Servlet端口");
        p.put("application.webpath","dcuc-webapp/src/main/webapp","Web路径");

        p.put("app.code","YHZX0000000000000001","应用code");
        p.put("root.orgid","7F08CCC3C4984A2586C9D3F0A6B804E5","顶级机构Id");
        p.put("auth.accessable","false","是否启用auth模块管理本系统权限");

        p.put("statistics.range","GD","统计模块的范围");
        p.put("authweb.accessable","false","是否部署为统一权限系统，为true时auth.accessable需设置为true");
        p.put("install.jarfile.accessable","false","是否启用jar包解压[修改]");
        p.put("install.jarfile.accessable.files","widgets-src,monitor","jar包解压过滤文件[修改]");
        p.put("development","true","是否开发模式，如果是开发模式且用平台登录系统的话，则自动以ADMIN登录[修改]");

        //###############################dubbo配置####################################*/
        p.put("dubbo.registry.address","zookeeper://127.0.0.1:2181","dubbo注册地址[修改]");
        p.put("dubbo.timeout","30000","dubbo超时时间");
        return p;
    }
}
