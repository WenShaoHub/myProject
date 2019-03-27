package com.wen.algorithm.main;

import com.wen.algorithm.util.ObjectReflectUtil;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Testmain {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//        User u = new User();
//        String time="2019-02-15T00:00:00.000Z";
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        String str = "1,2,3,";
        Map map = new HashMap<>();
        long Id = 212;
        map.put("userId",Id);

        Long userId = (Long)map.get("userId");
        System.out.println(userId);
        Integer num1 = 150;
        Integer num2 = 150;

        int num3 = 150;
        int num4 = 150;
        System.out.println(num3 == num4);
        System.out.println(18*18*18*18*18);


        System.out.println(num1 == num2);
        System.out.println(num1.equals(num2));

//        String account = "15297776872" ;
//        account.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")
//                || account.matches("((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(16[0-9])|(17[013678])|(18[0,5-9])|(19[89]))\\d{8}$"), "支付宝账号格式不正确");
//
////邮箱 199 198 166
//        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
////手机号
//        Pattern regex = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$");

    }

}
