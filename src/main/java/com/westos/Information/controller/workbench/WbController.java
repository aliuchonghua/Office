package com.westos.Information.controller.workbench;

import com.westos.Information.bean.*;
import com.westos.Information.service.service.workbench.WbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 工作台
 */
@RestController
@RequestMapping("/workbench/wb")
public class WbController {
    @Autowired
    private WbService service;


    //各部门员工统计
    @RequestMapping(value = "/gbmygtj", method = RequestMethod.GET)
    public WorkBenchList gbmygtj(HttpServletRequest request) {
        return service.gbmygtj(new Msg(request.getSession()));
    }
    //各部门绩效
    @RequestMapping(value = "/gbmjxtj", method = RequestMethod.GET)
    public WorkBenchList gbmjxtj(HttpServletRequest request) {
        return service.gbmwcrwl(new Msg(request.getSession()));
    }
    //未读公告
    @RequestMapping(value = "/wdgg", method = RequestMethod.GET)
    public WorkBench wdgg(HttpServletRequest request) {
        return service.wdgg(new Msg(request.getSession()));
    }
    //待审批任务
    @RequestMapping(value = "/dsprw", method = RequestMethod.GET)
    public WorkBench dsprw(HttpServletRequest request) {
        return service.dsprw(new Msg(request.getSession()));
    }
    //未开始任务
    @RequestMapping(value = "/wksrw", method = RequestMethod.GET)
    public WorkBench wksrw(HttpServletRequest request) {
        return service.wksrw(new Msg(request.getSession()));
    }
    //未通过审批
    @RequestMapping(value = "/wtgsp", method = RequestMethod.GET)
    public WorkBench wtgsp(HttpServletRequest request) {
        return service.wtgsp(new Msg(request.getSession()));
    }

    //各部门任务绩效
    @RequestMapping(value = "/gbmrwjx", method = RequestMethod.GET)
    public WorkRwjx gbmrwjx(HttpServletRequest request) {
        return service.gbmrwjx(new Msg(request.getSession()));
    }
    //员工任务绩效
    @RequestMapping(value = "/ygrwjx", method = RequestMethod.GET)
    public WorkRwjx ygrwjx(HttpServletRequest request) {
        return service.ygrwjx(new Msg(request.getSession()));
    }
    //个人任务绩效
    @RequestMapping(value = "/grrwjx", method = RequestMethod.GET)
    public WorkRwjx grrwjx(HttpServletRequest request) {
        return service.grrwjx(new Msg(request.getSession()));
    }
    //个人审批种类计数
    @RequestMapping(value = "/grspzl", method = RequestMethod.GET)
    public WorkSpzl grspzl(HttpServletRequest request) {
        return service.grspzl(new Msg(request.getSession()));
    }
}
