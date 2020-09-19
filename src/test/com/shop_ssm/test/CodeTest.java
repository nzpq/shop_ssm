package com.shop_ssm.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CodeTest {

    @Test
    public void test(){
        StringBuilder sb =new StringBuilder();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        sb.append(format.format(new Date()));
        System.out.println(sb);
        System.out.println(sb.append(UUID.randomUUID().toString().replace("-","").substring(0,8)));
    }
    @Test
    public void test2(){
        BigDecimal total = new BigDecimal(0);

        for(int i=0;i<3;i++){
            total = total.add(BigDecimal.valueOf(5));
        }
        System.out.println(total);
        long time = new Date().getTime();
        System.out.println(time);
        System.out.println((int)time);
    }
}
