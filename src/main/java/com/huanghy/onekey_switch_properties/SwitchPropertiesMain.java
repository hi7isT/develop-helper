package com.huanghy.onekey_switch_properties;

import com.huanghy.onekey_switch_properties.common.Constants;
import com.huanghy.onekey_switch_properties.common.DataBaseTypeEnum;
import com.huanghy.onekey_switch_properties.dcuc_app.AppMYSQLProperties;
import com.huanghy.onekey_switch_properties.dcuc_app.AppORACLEProperties;
import com.huanghy.onekey_switch_properties.dcuc_auth.AuthMYSQLProperties;
import com.huanghy.onekey_switch_properties.dcuc_auth.AuthORACLEProperties;
import com.huanghy.onekey_switch_properties.dcuc_list.ListMYSQLProperties;
import com.huanghy.onekey_switch_properties.dcuc_list.ListORACLEProperties;
import com.huanghy.onekey_switch_properties.dcuc_org.OrgMYSQLProperties;
import com.huanghy.onekey_switch_properties.dcuc_org.OrgORACLEProperties;
import com.huanghy.onekey_switch_properties.dcuc_tenant.TenantMYSQLProperties;
import com.huanghy.onekey_switch_properties.dcuc_tenant.TenantORACLEProperties;
import com.huanghy.onekey_switch_properties.dcuc_user.UserMYSQLProperties;
import com.huanghy.onekey_switch_properties.dcuc_user.UserORACLEProperties;
import com.huanghy.onekey_switch_properties.dcuc_webapp.WebMYSQLProperties;
import com.huanghy.onekey_switch_properties.dcuc_webapp.WebORACLEProperties;
import com.huanghy.onekey_switch_properties.duceap_service_resource.ResourceMYSQLProperties;
import com.huanghy.onekey_switch_properties.duceap_service_resource.ResourceORACLEProperties;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * <pre>
 * </pre>
 * JDK版本：JDK1.7
 *
 * @author huanghy <br>create on 2019/03/10
 */

public class SwitchPropertiesMain {

    public static void main(String[] args) {
        final JLabel[] jLabel = {null};
//        JFrame frame=new JFrame("开发辅助工具");
        JFrame frame=new JFrame("一键切换配置文件");
        final JPanel jp=new JPanel();    //创建面板
//        JLabel firstLabel = new JLabel("一键切换配置文件: " +
//                "                                                                                 ");
//        jp.add(firstLabel);

        final JLabel label1=new JLabel("数据库类型：");    //创建标签
        final JComboBox cmb=new JComboBox();    //创建JComboBox
        cmb.addItem("--请选择--");    //向下拉列表中添加一项
        cmb.addItem("ORACLE");
        cmb.addItem("MYSQL");
        jp.add(label1);
        jp.add(cmb);

//        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(SwitchProperties.class.getResource("/onekey_switch_properties_img/logo.png")));//设置图标
        setIcon(frame);

        final JButton jButton = new JButton("写入配置");
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(cmb.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(cmb,"请选择具体的数据库类型!","错误 ",0);
                    return;
                }
                String select_databaseType = cmb.getSelectedItem().toString().trim();
                String insertTotalTime = insertProperties(select_databaseType);
                jLabel[0].setText("写入配置成功!"+insertTotalTime);
                jLabel[0].repaint();
            }
        });
        jp.add(jButton);

        jLabel[0] = new JLabel("请选择具体的数据库类型，然后点击切换配置按钮即可!");
        jp.add(jLabel[0]);

        frame.add(jp);
        frame.setBounds(500,200,400,200);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * 修改标题栏默认java官方图标
     * @param frame
     */
    private static void setIcon(JFrame frame) {
        String src = "/onekey_switch_properties_img/logo.png";//图片路径
        Image image= null; //创建图片对象
        try {
            image = ImageIO.read(frame.getClass().getResource(src));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setIconImage(image);//设置图标
    }

    private static String insertProperties(String databaseType) {

        long startTime = System.currentTimeMillis();
        if(DataBaseTypeEnum.ORACLE.getCode().equals(databaseType)){
            System.out.println("=====================统一用户及表码服务ORACLE配置写入开始==========================");
            OrgORACLEProperties.duceapProperties(Constants.ORG_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("机构服务 duceap.properties Oracle配置写入成功!");
            OrgORACLEProperties.flywayProperties(Constants.ORG_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("机构服务 flyway Oracle配置写入成功!");

            UserORACLEProperties.duceapProperties(Constants.USER_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("用户服务 duceap.properties Oracle配置写入成功!");
            UserORACLEProperties.flywayProperties(Constants.USER_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("用户服务 flyway Oracle配置写入成功!");

            TenantORACLEProperties.duceapProperties(Constants.TENANT_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("租户服务 duceap.properties Oracle配置写入成功!");
            TenantORACLEProperties.flywayProperties(Constants.TENANT_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("租户服务 flyway Oracle配置写入成功!");

            ListORACLEProperties.duceapProperties(Constants.LIST_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("名单服务 duceap.properties Oracle配置写入成功!");
            ListORACLEProperties.flywayProperties(Constants.LIST_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("名单服务 flyway Oracle配置写入成功!");

            AppORACLEProperties.duceapProperties(Constants.APP_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("应用服务 duceap.properties Oracle配置写入成功!");
            AppORACLEProperties.flywayProperties(Constants.APP_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("应用服务 flyway Oracle配置写入成功!");

            AuthORACLEProperties.duceapProperties(Constants.AUTH_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("权限服务 duceap.properties Oracle配置写入成功!");
            AuthORACLEProperties.flywayProperties(Constants.AUTH_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("权限服务 flyway Oracle配置写入成功!");

            ResourceORACLEProperties.duceapProperties(Constants.RESOURCE_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("表码服务 duceap.properties Oracle配置写入成功!");
            ResourceORACLEProperties.flywayProperties(Constants.RESOURCE_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("表码服务 flyway Oracle配置写入成功!");

            WebORACLEProperties.duceapProperties(Constants.WEBAPP_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("dcuc-webapp系统 duceap.properties Oracle配置写入成功!");
            WebORACLEProperties.flywayProperties(Constants.WEBAPP_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("dcuc-webapp系统 flyway Oracle配置写入成功!");
            System.out.println("=====================统一用户及表码服务ORACLE配置写入完毕==========================");

        } else if (DataBaseTypeEnum.MYSQL.getCode().equals(databaseType)) {

            System.out.println("=====================统一用户及表码服务MYSQL配置写入开始==========================");
            OrgMYSQLProperties.duceapProperties(Constants.ORG_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("机构服务 duceap.properties Mysql配置写入成功!");
            OrgMYSQLProperties.flywayProperties(Constants.ORG_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("机构服务 flyway Mysql配置写入成功!");

            UserMYSQLProperties.duceapProperties(Constants.USER_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("用户服务 duceap.properties Mysql配置写入成功!");
            UserMYSQLProperties.flywayProperties(Constants.USER_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("用户服务 flyway Mysql配置写入成功!");

            TenantMYSQLProperties.duceapProperties(Constants.TENANT_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("租户服务 duceap.properties Mysql配置写入成功!");
            TenantMYSQLProperties.flywayProperties(Constants.TENANT_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("租户服务 flyway Mysql配置写入成功!");

            ListMYSQLProperties.duceapProperties(Constants.LIST_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("名单服务 duceap.properties Mysql配置写入成功!");
            ListMYSQLProperties.flywayProperties(Constants.LIST_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("名单服务 flyway Mysql配置写入成功!");

            AppMYSQLProperties.duceapProperties(Constants.APP_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("应用服务 duceap.properties Mysql配置写入成功!");
            AppMYSQLProperties.flywayProperties(Constants.APP_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("应用服务 flyway Mysql配置写入成功!");

            AuthMYSQLProperties.duceapProperties(Constants.AUTH_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("权限服务 duceap.properties Mysql配置写入成功!");
            AuthMYSQLProperties.flywayProperties(Constants.AUTH_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("权限服务 flyway Mysql配置写入成功!");

            ResourceMYSQLProperties.duceapProperties(Constants.RESOURCE_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("表码服务 duceap.properties Mysql配置写入成功!");
            ResourceMYSQLProperties.flywayProperties(Constants.RESOURCE_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("表码服务 flyway Mysql配置写入成功!");

            WebMYSQLProperties.duceapProperties(Constants.WEBAPP_DUCEAP_PROPRETIES_FILEPATH);
            System.out.println("duceap.properties Mysql配置写入成功!");
            WebMYSQLProperties.flywayProperties(Constants.WEBAPP_FLYWAY_PROPRETIES_FILEPATH);
            System.out.println("flyway Mysql配置写入成功!");
            System.out.println("=====================统一用户及表码服务MYSQL配置写入完毕==========================");
        }

        long endTime = System.currentTimeMillis();
        String insertTotalTime = "写入共消耗:"+(endTime-startTime)+"毫秒";
        System.out.println(insertTotalTime);
        return insertTotalTime;
    }
}
