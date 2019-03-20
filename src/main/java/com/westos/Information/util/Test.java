package com.westos.Information.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws Exception {
        form("user");
    }

    public static void form(String s) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\aliuc\\Desktop\\OfficeAutomationSystem\\src\\main\\resources\\form.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String spell = PingYinUtil.getFirstSpell(replace(line));
            System.out.println("\t\t\t\t\t\t<div class=\"form-group\">\n" +
                    "\t\t\t\t\t\t\t<label for=\""+spell+"\" class=\"control-label\">"+line+"</label>\n" +
                    "\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\""+spell+"\" name=\""+spell+"\" v-model=\""+s+"."+spell+"\">\n" +
                    "\t\t\t\t\t\t</div>");
        }
        reader.close();
    }

    public static String replace(String s) {
        if (s.indexOf("姓名")!=-1){
            return s.replaceAll("姓名","name");
        }else if (s.indexOf("名")!=-1){
            return s.replaceAll("名","_name");
        }else if (s.indexOf("密码")!=-1){
            return s.replaceAll("密码","pass");
        }else {
            return s;
        }

    }
}
