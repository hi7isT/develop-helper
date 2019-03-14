package com.huanghy.onekey_switch_properties.dcuc_user;

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

public class UserCommonProperties {

    public static OutputOrderProperties duceapProperties(OutputOrderProperties p) {
        p.put("application.name","dcuc-user","系统名称");
        p.put("application.cnname","用户中心","用户中心系统名称");
        p.put("application.version","0.5","系统版本号");
        p.put("application.owner","dragonsoft","负责人");

        p.put("zookeeper.address","127.0.0.1:2181","zookeeper地址[修改]");

        //###############################dubbo配置####################################*/
        p.put("dubbo.registry.address","zookeeper://127.0.0.1:2181","dubbo注册地址[修改]");
        p.put("dubbo.protocol.port","21892","dubbo开放端口[修改]");
        p.put("dubbo.timeout","30000","dubbo超时时间");
        p.put("dubbo.protocol.threads","400","dubbo线程池");

        p.put("message.topic","90190006","统一用户-用户消息主题");
        p.put("message.msm.topic","90190009","发送短信消息主题");


        //##############################usertoken配置####################################
        p.put("token.issuer","统一用户中心","usertoken签发者");
        p.put("token.subject","anyone","面向的用户");
        p.put("token.audience","anyone","接收的一方,用于验证签名是否合法，验证方必须包含这些内容才验证通过");
        p.put("token.expiration","60","过期时间,单位分钟,默认60分钟");
        p.put("refreshtoken.expiration","1440","refreshToken过期时间,单位分钟,默认1天,1440分钟");

        //##############################rlsb配置####################################
        p.put("huawei.apiUrl","http://68.26.19.197:8380","华为Api网关http协议地址");
        p.put("huawei.apiHttpsUrl","https://68.26.19.197:8343","华为Api网关https协议地址");
        p.put("huawei.grantType","client_credentials","授权类型");
        p.put("huawei.clientId","d6d362a3c92a4e23a7194c9d12a6400e","Api消费者id");
        p.put("huawei.clientSecret","0a621eaee3834ac1b81feff47a5eabc1","Api消费者秘钥");
        p.put("huawei.scope","default","范围,默认default");
        p.put("feishi.threshold","60","0-100范围内的整数，以百分制衡量返回图片的最低相似程度");
        p.put("feishi.topNumber","2","该次比对每个算法返回的人员数的最大数量");
        p.put("feishi.repositories","常住人口","人员库名称,声明比对使用哪些人员库,多个用逗号隔开");
        p.put("image.positionbysso","false","是否使用单点登录入参数x,y等值,false则使用下面4个参数进行比对" +
                "而且可以实现传null进行比对");
        p.put("feishi.faceAreaX","","检索区域范围X轴值,注意:若该值不填，则faceArea传null进行比对");
        p.put("feishi.faceAreaY","200","检索区域范围Y轴值");
        p.put("feishi.faceAreaWidth","200","检索区域范围宽度");
        p.put("feishi.faceAreaHeight","300","检索区域范围高度");
        return p;
    }

}
