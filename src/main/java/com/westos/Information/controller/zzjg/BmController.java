package com.westos.Information.controller.zzjg;

import com.westos.Information.bean.Bumen;
import com.westos.Information.bean.Msg;
import com.westos.Information.service.service.zzjg.BmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/zzjg/bmgl")
public class BmController {
    @Autowired
    private BmService service;

    //主列表加载
    @RequestMapping(value = "/findlist", method = RequestMethod.GET)
    public List<Bumen> findList(HttpServletRequest request) {
        return service.findlist(new Msg(request.getSession()));
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg add(@RequestBody Bumen bumen, HttpServletRequest request) {
        return service.add(new Msg(request.getSession(),bumen));
    }
    /**
     * 修改
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg modify(@RequestBody Bumen bumen, HttpServletRequest request) {
        return service.modify(new Msg(request.getSession(),bumen));
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg remove(@RequestBody Bumen bumen, HttpServletRequest request) {
        return service.remove(new Msg(request.getSession(),bumen));
    }
}
