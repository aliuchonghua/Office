package com.westos.Information.controller.sp;

import com.westos.Information.bean.Gonggao;
import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Shenpi;
import com.westos.Information.bean.User;
import com.westos.Information.service.service.gg.GgService;
import com.westos.Information.service.service.sp.SpService;
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
 * 审批管理
 */
@RestController
@RequestMapping("/sp/spgl")
public class SpController {
    @Autowired
    private SpService service;
    /**
     * 我发起的审批
     */
    @RequestMapping(value = "/findMyWFQ", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Shenpi> findMyWFQ(@RequestBody Shenpi shenpi, HttpServletRequest request) {
        return service.findMyWFQ(new Msg(request.getSession(), shenpi));
    }
    /**
     * 我审批的
     */
    @RequestMapping(value = "/findMyWsp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Shenpi> findMyWsp(@RequestBody Shenpi shenpi, HttpServletRequest request) {
        return service.findMyWsp(new Msg(request.getSession(), shenpi));
    }
    /**
     * 审批
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Msg update(@RequestBody Shenpi shenpi, HttpServletRequest request) {
        return service.update(new Msg(request.getSession(), shenpi));
    }

    /**
     * 加班
     */
    @RequestMapping(value = "/overtime", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg overtime(@RequestBody Shenpi shenpi, HttpServletRequest request) {
        shenpi.setSplx("加班");
        shenpi.setType("待审批");
        return service.add(new Msg(request.getSession(), shenpi));
    }
    /**
     * 出差
     */
    @RequestMapping(value = "/businessTrip", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg businessTrip(@RequestBody Shenpi shenpi, HttpServletRequest request) {
        shenpi.setSplx("出差");
        shenpi.setType("待审批");
        return service.add(new Msg(request.getSession(), shenpi));
    }
    /**
     * 请假
     */
    @RequestMapping(value = "/askForLeave", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg askForLeave(@RequestBody Shenpi shenpi, HttpServletRequest request) {
        shenpi.setSplx("请假");
        shenpi.setType("待审批");
        return service.add(new Msg(request.getSession(), shenpi));
    }
    /**
     * 撤销审批
     */
    @RequestMapping(value = "/cancel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg cancel(@RequestBody Shenpi shenpi, HttpServletRequest request) {
        return service.remove(new Msg(request.getSession(), shenpi));
    }
    /**
     * 查询上级领导
     */
    @RequestMapping(value = "/findspr", method = RequestMethod.GET)
    public List<User> findspr(HttpServletRequest request) {
        return service.findleader(new Msg(request.getSession()));
    }




}
