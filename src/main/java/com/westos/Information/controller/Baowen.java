package com.westos.Information.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
@RequestMapping("/baowen")
public class Baowen {
    StringBuilder sb;
    //测试报文
    @RequestMapping(value = "/fs", method = RequestMethod.POST)
    public String baowen(HttpServletRequest request) throws IOException {
        sb=new StringBuilder();
        System.out.println("============开始接收报文============");
        //io流方式获取数据
        BufferedReader reader=new BufferedReader(new InputStreamReader(request.getInputStream(),"GBK"));
        String s;
        while ((s=reader.readLine()) != null) {
            sb.append(s);
            sb.append("\r\n");
        }
        System.out.println(sb.toString());
        System.out.println("============结束============");
//        返回数据
        InputStream is=new FileInputStream("C:\\Users\\aliuc\\Desktop\\OfficeAutomationSystem\\src\\main\\resources\\test.xml");
        byte[] b = new byte[1024];
        int i = 0;
        int index = 0;
        while((i=is.read())!=-1){
            b[index]=(byte) i;
            index++;
        }
        is.close();
        return new String(b);
    }

    @RequestMapping(value = "/nr", method = RequestMethod.GET)
    public String nr(HttpServletRequest request) {
        if(sb==null){
            return "无内容";
        }
        return sb.toString();
    }
}
