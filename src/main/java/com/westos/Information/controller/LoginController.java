package com.westos.Information.controller;

import com.westos.Information.bean.Student;
import com.westos.Information.config.Adminconfig;
import com.westos.Information.service.LoginService;
import com.westos.Information.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private Adminconfig adminconfig;
    //登陆
    @RequestMapping(value = "/stulogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map login(@RequestBody Student student, HttpServletRequest request) throws IOException {

        HttpSession session = request.getSession();
        Map msg=new HashMap();
        if (StringUtils.equals(student.getStuid().toString(),adminconfig.getAccount())) {
            if (StringUtils.equals(student.getPass(), adminconfig.getPassword())) {
                //将管理员账户写入session
                session.setAttribute("currentStudent", student);
                msg.put("html","/manager_page.html");
                msg.put("msg","登陆成功");
                return msg;
            }
        }
        if (student.getStuid().length()!=11){
            msg.put("msg","手机号格式错误");
            return msg;
        }
        if (loginService.loginmsg(student)) {
            //通过只有账户信息的学生获取完整的学生信息
            student = studentService.currentStudent(student);
            //存入session
            session.setAttribute("currentStudent", student);
            //给前端传递页面跳转的地址
            msg.put("msg","登陆成功");
            msg.put("html","/student_page.html");
            return msg;
        } else {
            msg.put("msg","账户或密码错误");
            return msg;
        }

    }
    //注销
    @RequestMapping("/stulogout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("currentStudent");
        try {
            response.sendRedirect("/index.html");
        } catch (IOException e) {
            System.out.println("index重定向失败");
        }

    }

}
