package com.huanghy.onekey_switch_properties.common;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.UUID;

/**
 * <pre>
 * </pre>
 * JDK版本：JDK1.7
 *
 * @author huanghy <br>create on 2019/03/06
 */

public class OutputOrderProperties extends Properties {

    private LinkedHashMap<String, String> commentMap = new LinkedHashMap<String, String>();

    private static final long serialVersionUID = 1L;

    public OutputOrderProperties() {
        super();
    }

    public OutputOrderProperties(Properties properties) {
        super(properties);
        Iterator<Object> iterator = properties.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            this.commentMap.put((String) key, null);
        }
    }

    public void addCommentOnly(String comment){
        this.commentMap.put(UUID.randomUUID().toString(),comment);
    }

    public boolean addComment(String key, String comment) {
        if (this.containsKey(key)) {
            this.commentMap.put(key, comment);
            return true;
        }
        return false;
    }

    public void put(String key, String value, String comment) {
        this.commentMap.put(key, comment);
        this.setProperty(key, value);
    }

    public void put(String key, String value) {
        this.commentMap.put(key, null);
        this.setProperty(key, value);
    }

    public void orderStore(Writer writer, String comments) throws IOException {
        BufferedWriter bufferedWriter = (writer instanceof BufferedWriter) ? (BufferedWriter) writer : new BufferedWriter(writer);
        if (comments != null) {
            OutputOrderProperties.writeComments(bufferedWriter, comments);
        }
        synchronized (this) {
            Iterator<String> iterator = this.commentMap.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = this.getProperty(key);
                String comment = this.commentMap.get(key);
                key = saveConvert(key, true, false);
                value = saveConvert(value, false, false);
                key = saveConvert(key, true, false);
                if (comment != null && !comment.equals("")) {
                    writeComments(bufferedWriter, comment);
                }
                bufferedWriter.write(key + "=" + value);
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.flush();
    }

    private String saveConvert(String theString, boolean escapeSpace, boolean escapeUnicode) {
        int len = theString.length();
        int bufLen = len * 2;
        if (bufLen < 0) {
            bufLen = Integer.MAX_VALUE;
        }
        StringBuffer outBuffer = new StringBuffer(bufLen);
        for (int x = 0; x < len; x++) {
            char aChar = theString.charAt(x);
            if ((aChar > 61) && (aChar < 127)) {
                if (aChar == '\\') {
                    outBuffer.append('\\');
                    outBuffer.append('\\');
                    continue;
                }
                outBuffer.append(aChar);
                continue;
            }
            switch (aChar) {
                case ' ':
                    if (x == 0 || escapeSpace)
                        outBuffer.append('\\');
                    outBuffer.append(' ');
                    break;
                case '\t':
                    outBuffer.append('\\');
                    outBuffer.append('t');
                    break;
                case '\n':
                    outBuffer.append('\\');
                    outBuffer.append('n');
                    break;
                case '\r':
                    outBuffer.append('\\');
                    outBuffer.append('r');
                    break;
                case '\f':
                    outBuffer.append('\\');
                    outBuffer.append('f');
                    break;
                case '=': // Fall through
                case ':': // Fall through
                case '#': // Fall through
                case '!':
                    outBuffer.append('\\');
                    outBuffer.append(aChar);
                    break;
                default:
                    if (((aChar < 0x0020) || (aChar > 0x007e)) & escapeUnicode) {
                        outBuffer.append('\\');
                        outBuffer.append('u');
                        outBuffer.append(toHex((aChar >> 12) & 0xF));
                        outBuffer.append(toHex((aChar >> 8) & 0xF));
                        outBuffer.append(toHex((aChar >> 4) & 0xF));
                        outBuffer.append(toHex(aChar & 0xF));
                    } else {
                        outBuffer.append(aChar);
                    }
            }
        }
        return outBuffer.toString();
    }

    private static void writeComments(BufferedWriter bw, String comments) throws IOException {
        bw.write("#");
        bw.write(comments);
        bw.newLine();

    }


    private static char toHex(int nibble) {
        return hexDigit[(nibble & 0xF)];
    }

    private static final char[] hexDigit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

}
