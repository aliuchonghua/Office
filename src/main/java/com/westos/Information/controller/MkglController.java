package com.westos.Information.controller;

import com.westos.Information.bean.Bumen;
import com.westos.Information.bean.Module;
import com.westos.Information.bean.Msg;
import com.westos.Information.service.service.mkgl.MkglService;
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
 * 模块管理
 */
@RestController
@RequestMapping("/mkgl")
public class MkglController {
    @Autowired
    private MkglService mkglService;
    //主列表加载
    @RequestMapping(value = "/findlist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Module> findList(@RequestBody Module module , HttpServletRequest request)  {
        return mkglService.findlist(module,request.getSession());
    }
    //获取当前企业部门可选的附加模块
    @RequestMapping(value = "/findMk", method = RequestMethod.GET)
    public List<Module> findMk( HttpServletRequest request)  {
        return mkglService.findMk(new Msg(request.getSession()));
    }
    /**
     * 根据模块名获取id串
     */
    @RequestMapping(value = "/fingModuleByname", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Bumen add(@RequestBody Bumen bumen, HttpServletRequest request) {
        return mkglService.fingModuleByname(new Msg(request.getSession(),bumen));
    }
    //新增
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg add(@RequestBody Module module , HttpServletRequest request)  {
        return mkglService.add(module,request.getSession());
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg remove(@RequestBody Module module , HttpServletRequest request)  {
        return mkglService.remove(module,request.getSession());
    }


}
