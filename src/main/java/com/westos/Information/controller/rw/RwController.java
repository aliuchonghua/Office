package com.westos.Information.controller.rw;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Renwu;
import com.westos.Information.bean.User;
import com.westos.Information.service.service.rw.RwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 任务管理
 */
@RestController
@RequestMapping("/rw/rwgl")
public class RwController {
    @Autowired
    private RwService service;
    /**
     * 我的任务
     */
    @RequestMapping(value = "/findMyRw", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Renwu> findMyRw(@RequestBody Renwu renwu, HttpServletRequest request){
        return service.findMyRw(new Msg(request.getSession(),renwu));
    }
    /**
     * 我下发的任务
     */
    @RequestMapping(value = "/findWXF", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Renwu> findWXF(@RequestBody Renwu renwu, HttpServletRequest request){
        return service.findWXF(new Msg(request.getSession(),renwu));
    }
    /**
     * 查询下属员工
     */
    @RequestMapping(value = "/findXs", method = RequestMethod.GET)
    public List<User> findXs(HttpServletRequest request){
        return service.findXs(new Msg(request.getSession()));
    }
    /**
     * 创建任务
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Msg add(@RequestBody Renwu renwu, HttpServletRequest request){
        return service.add(new Msg(request.getSession(),renwu));
    }
    /**
     * 进行中
     */
    @RequestMapping(value = "/hasNotStarted", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Msg hasNotStarted(@RequestBody Renwu renwu, HttpServletRequest request){
        renwu.setType("进行中");
        return service.modify(new Msg(request.getSession(),renwu));
    }
    /**
     * 已完成
     */
    @RequestMapping(value = "/fulfill", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Msg fulfill(@RequestBody Renwu renwu, HttpServletRequest request){
        renwu.setType("已完成");
        renwu.setEnd_time(new Date());
        return service.modify(new Msg(request.getSession(),renwu));
    }
    /**
     * 撤销下发的任务
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Msg delete(@RequestBody Renwu renwu, HttpServletRequest request){
        return service.delete(new Msg(request.getSession(),renwu));
    }
}
