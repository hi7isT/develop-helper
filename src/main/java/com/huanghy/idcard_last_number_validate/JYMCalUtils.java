package com.huanghy.idcard_last_number_validate;

/**
 * <pre>
 * </pre>
 * JDK版本：JDK1.7
 *
 * @author huanghy <br>create on 2019/03/09
 */

public class JYMCalUtils {

    /**
     *
     * @param idcard    二代身份证前17位
     * @return  身份证号码，共18位
     */
    public static String jisuan(String idcard){
        System.out.println("JYMCalUtils.idcard:"+idcard);
        int[] nums = new int[17];
        nums[0] = Integer.parseInt(idcard.substring(0,1));
        nums[1] = Integer.parseInt(idcard.substring(1,2));
        nums[2] = Integer.parseInt(idcard.substring(2,3));
        nums[3] = Integer.parseInt(idcard.substring(3,4));
        nums[4] = Integer.parseInt(idcard.substring(4,5));
        nums[5] = Integer.parseInt(idcard.substring(5,6));
        nums[6] = Integer.parseInt(idcard.substring(6,7));
        nums[7] = Integer.parseInt(idcard.substring(7,8));
        nums[8] = Integer.parseInt(idcard.substring(8,9));
        nums[9] = Integer.parseInt(idcard.substring(9,10));
        nums[10] = Integer.parseInt(idcard.substring(10,11));
        nums[11] = Integer.parseInt(idcard.substring(11,12));
        nums[12] = Integer.parseInt(idcard.substring(12,13));
        nums[13] = Integer.parseInt(idcard.substring(13,14));
        nums[14] = Integer.parseInt(idcard.substring(14,15));
        nums[15] = Integer.parseInt(idcard.substring(15,16));
        nums[16] = Integer.parseInt(idcard.substring(16,17));

        int[] jiaquanyinzi = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<jiaquanyinzi.length;j++){
                if(i == j){
                    sum += (nums[i] * jiaquanyinzi[j]);
                }
            }
        }
        int yushu = sum%11;

        //余数0~10对应的校验码
        String[] jiaoyanbiao = {"1","0","X","9","8","7","6","5","4","3","2"};
        System.out.println("校验码为："+jiaoyanbiao[yushu]);
        return idcard+jiaoyanbiao[yushu];
    }
}
