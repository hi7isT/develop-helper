package com.huanghy.idcard_last_number_validate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * <pre>
 *     二代身份证第十八位校验码判断或生成
 * </pre>
 * JDK版本：JDK1.7
 *
 * @author huanghy <br>create on 2019/03/09
 */

public class IDcardLastNumValidateMain {

    public static void main(String[] args) {
        createJFrame();
    }

    public static void createJFrame() {
        final JLabel[] calResult = new JLabel[1];
        final JPanel cardJPanel=new JPanel(new CardLayout());    //卡片式布局的面板
        final CardLayout cardLayout = (CardLayout) cardJPanel.getLayout();

        final JFrame frame=new JFrame("二代身份证校验码计算");    //创建Frame窗口
        final JPanel jPanel = new JPanel();
        final JTextField idcardEt = new JTextField("",18);//18控制文本编辑框的长度，设置为0时和JTextFieldLimit则文本编辑框长度为0
        idcardEt.setDocument(new JTextFieldLimit(17));

        final JButton jButton = new JButton("计算");
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idcardPre = idcardEt.getText().trim();
                if(idcardPre.length() <= 0){
                    JOptionPane.showMessageDialog(idcardEt,"身份证不能为空!","错误 ",0);
                    return;
                }
                boolean isNumber = isNumeric(idcardPre);
                if(idcardPre.length() != 17 || !isNumber){

                    JOptionPane.showMessageDialog(idcardEt,"身份证长度需要为17位并且为数字数字！当前共"+idcardPre.length()+"位,"
                            +(isNumber ? "是数字" : "不是数字"),"错误 ",0);
                    return;
                }

                String idcard = JYMCalUtils.jisuan(idcardPre);
                calResult[0].setText("计算结果："+ idcard +",已自动复制到剪切板!");//修改JLabel内容并重绘此组件
                calResult[0].repaint();
                setSysClipboardText(idcard);

            }
        });

        calResult[0] = new JLabel("请在文本框中输入二代身份证前17位数字，然后点击计算!");

        jPanel.add(idcardEt);
        jPanel.add(jButton);
        jPanel.add(calResult[0]);
        final int[] num = {0};

        final JTextArea batchSuccessHint = new JTextArea("");
        batchSuccessHint.setCaretColor(Color.GRAY);
        final JButton generateIdcards = new JButton("批量生成身份证");
        generateIdcards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num[0] += 100;
                String idcards = generateIdcards();
                batchSuccessHint.setText("批量生成二代身份证成功！一次默认生成100个，当前已生成个数"+num[0]+"\n已自动复制到剪切板!");
                batchSuccessHint.repaint();
                setSysClipboardText(idcards);

            }
        });
        jPanel.add(generateIdcards);
        jPanel.add(batchSuccessHint);



        setIcon(frame);

        cardJPanel.add(jPanel,"ui");
        cardLayout.show(cardJPanel,"ui");
        frame.add(cardJPanel);
        frame.setBounds(500,200,400,200);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static String generateIdcards() {
        String idcards = "";
        for(int i=0;i<100;i++){
            StringBuilder idcard = new StringBuilder("350823");
            idcard.append(IdcardHelperUtils.yearMonthDayRandom());
            idcard.append(IdcardHelperUtils.generateLastThreeNum());
            idcards += JYMCalUtils.jisuan(idcard.toString())+",";

        }
        if(idcards != null && idcards.length() > 17){
            idcards = idcards.substring(0, idcards.length() - 1);
        }
        return idcards;
    }

    private static boolean isNumeric(String var1) {
        if(var1.indexOf("-") != -1)
            return false;
        try {
            Long.valueOf(var1);
            return true;
        } catch (NumberFormatException var3) {
            return false;
        }
    }

    /**
     * 将字符串复制到剪切板。
     */
    public static void setSysClipboardText(String writeMe) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(writeMe);
        clip.setContents(tText, null);
    }

    /**
     * 修改标题栏默认java官方图标
     * @param frame
     */
    private static void setIcon(JFrame frame) {
        String src = "/idcard_last_number_validate_img/logo.png";//图片路径
        Image image= null; //创建图片对象
        try {
            image = ImageIO.read(frame.getClass().getResource(src));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setIconImage(image);//设置图标
    }
}
