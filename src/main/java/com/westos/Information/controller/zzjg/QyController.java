package com.westos.Information.controller.zzjg;

import com.westos.Information.bean.Bumen;
import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Qiye;
import com.westos.Information.service.service.zzjg.QyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 企业管理
 */
@RestController
@RequestMapping("/zzjg/qygl")
public class QyController {
    @Autowired
    private QyService service;

    //主列表加载
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Qiye find(HttpServletRequest request) {
        return service.find(new Msg(request.getSession()));
    }
    /**
     * 修改
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg modify(@RequestBody Qiye qiye, HttpServletRequest request) {
        return service.modify(new Msg(request.getSession(),qiye));
    }
    /**
     * 注销企业
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @Transactional//事务
    public Msg logout(HttpServletRequest request) {
        return service.logout(new Msg(request.getSession()));
    }
}
