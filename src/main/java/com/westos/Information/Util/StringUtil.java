package com.westos.Information.Util;

import com.westos.Information.bean.User;

import java.lang.reflect.Field;

public class StringUtil {
    public static void main(String[] args) {
        Class<? extends User> user = new User().getClass();
        Field[] fields = user.getDeclaredFields();
        for (Field field:fields){
            field.setAccessible(true);
            System.out.println(field.getName());
        }
    }
    public static void getBean(Object o){

    }
}
