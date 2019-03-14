package com.huanghy.idcard_last_number_validate;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * <pre>
 *     JTextField限制长度类
 * </pre>
 * JDK版本：JDK1.7
 *
 * @author huanghy <br>create on 2019/03/09
 */

    public class JTextFieldLimit extends PlainDocument {

    private int limit;  //限制的长度

    public JTextFieldLimit(int limit) {
        super(); //调用父类构造
        this.limit = limit;
    }
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if(str == null) return;
        if((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);//调用父类方法
        }
    }

}
