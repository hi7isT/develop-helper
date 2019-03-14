package com.huanghy.idcard_last_number_validate;

/**
 * <pre>
 * </pre>
 * JDK版本：JDK1.7
 *
 * @author huanghy <br>create on 2019/03/14
 */

public class IdcardHelperUtils {

    public static void main(String[] args) {
        String s = yearMonthDayRandom();
        System.out.println(s);
        System.out.println(generateLastThreeNum());
    }

    /**
     * Math.Random()函数能够返回带正号的double值，该值大于等于0.0且小于1.0，即取值范围是[0.0,1.0)的左闭右开区间
     * @return
     */
    public static String yearMonthDayRandom() {
        StringBuilder yearMonthDay = new StringBuilder("");
        int yearInt = (int) (Math.random() * 118 + 1900);
        String year = String.valueOf(yearInt);
        yearMonthDay.append(year);

        int month = (int) (Math.random() * 12 + 1);   //生成月份1-12
        int day = 0;
        switch (month) {
            case 2:
                day = (int) (Math.random() * 28 + 1);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
//                System.out.println(month + "月份有30天");
                day = (int) (Math.random() * 30 + 1);
                break;
            default:
//                System.out.println(month + "月份有31天");
                day = (int) (Math.random() * 31 + 1);
        }
        if(month < 10){
            yearMonthDay.append("0" + month);
        }else{
            yearMonthDay.append(month);
        }

        if(day < 10){
            yearMonthDay.append("0" + day);
        }else{
            yearMonthDay.append(day);
        }

        System.out.println(yearMonthDay.toString());
        return yearMonthDay.toString();
    }

    public static String generateLastThreeNum(){
        int lastThreeNum = (int)(Math.random() * 999 + 1);
        String lastThree = String.valueOf(lastThreeNum);
        if(lastThree.length() == 2){
            lastThree = "0" + lastThree;
        }else if(lastThree.length() == 1){
            lastThree = "00" + lastThree;
        }
        return lastThree;
    }
}
