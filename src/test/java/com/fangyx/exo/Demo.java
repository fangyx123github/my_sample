package com.fangyx.exo;

import org.junit.Test;

/**
 * @Author: Fangyx
 * @Description:
 * @CreateDate: 2019/7/25 22:56
 * @UpdateUser:
 * @UpdateDate: 2019/7/25 22:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 **/
public class Demo {

    @Test
    public void forTest(){
        int startValue = 10;
        for(int i = startValue + 1;i<=10+startValue;i++){
            System.out.printf("@@@@@:"+i);
        }
    }



}
