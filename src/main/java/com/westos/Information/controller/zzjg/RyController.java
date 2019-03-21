package com.westos.Information.controller.zzjg;

import com.westos.Information.bean.Bumen;
import com.westos.Information.bean.Msg;
import com.westos.Information.bean.User;
import com.westos.Information.service.service.zzjg.RyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 人员管理
 */
@RestController
@RequestMapping("/zzjg/rygl")
public class RyController {
    @Autowired
    private RyService service;

    //主列表加载
    @RequestMapping(value = "/findlist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> findList(@RequestBody Bumen bumen, HttpServletRequest request) {
        return service.findlist(new Msg(request.getSession(),bumen));
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Msg add(@RequestBody User user, HttpServletRequest request) {
        return service.add(new Msg(request.getSession(), user));
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Msg modify(@RequestBody User user, HttpServletRequest request) {
        return service.modify(new Msg(request.getSession(), user));
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Msg remove(@RequestBody User user, HttpServletRequest request) {
        return service.remove(new Msg(request.getSession(), user));
    }
}
