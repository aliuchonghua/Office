package com.westos.Information.controller;

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
