package com.westos.Information.controller.gg;

import com.westos.Information.bean.Gonggao;
import com.westos.Information.bean.Msg;
import com.westos.Information.service.service.gg.GgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 公告管理
 */
@RestController
@RequestMapping("/gg/gggl")
public class GgController {
    @Autowired
    private GgService service;


    //已读列表加载
    @RequestMapping(value = "/findYdList", method = RequestMethod.GET)
    public List<Gonggao> findYdList(HttpServletRequest request) {
        return service.findYdList(new Msg(request.getSession()));
    }

    //未读列表加载
    @RequestMapping(value = "/findWdList", method = RequestMethod.GET)
    public List<Gonggao> findWdList(HttpServletRequest request) {
        return service.findWdList(new Msg(request.getSession()));
    }

    //自己发布的列表加载
    @RequestMapping(value = "/findZjList", method = RequestMethod.GET)
    public List<Gonggao> findZjList(HttpServletRequest request) {
        return service.findZjList(new Msg(request.getSession()));
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg add(@RequestBody Gonggao gonggao, HttpServletRequest request) {
        return service.add(new Msg(request.getSession(), gonggao));
    }

    /**
     * 设置已读
     */
    @RequestMapping(value = "/haveRead", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg haveRead(@RequestBody Gonggao gonggao, HttpServletRequest request) {
        return service.haveRead(new Msg(request.getSession(), gonggao));
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg delete(@RequestBody Gonggao gonggao, HttpServletRequest request) {
        return service.delete(new Msg(request.getSession(), gonggao));
    }

}
