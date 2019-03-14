package com.huanghy;

import java.io.IOException;
import java.util.Scanner;

/**
 * <pre>
 * </pre>
 * JDK版本：JDK1.7
 *
 * @author huanghy <br>create on 2019/03/14
 */

public class CPUTest {

    /**
     * 获取cpu序列号通过
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        long start = System.currentTimeMillis();
        Process process = Runtime.getRuntime().exec(
                new String[] { "wmic", "cpu", "get", "ProcessorId" });
        process.getOutputStream().close();
        Scanner sc = new Scanner(process.getInputStream());
        String property = sc.next();
        String serial = sc.next();
        System.out.println(property + ": " + serial);

        System.out.println("time:" + (System.currentTimeMillis() - start));

    }
}
