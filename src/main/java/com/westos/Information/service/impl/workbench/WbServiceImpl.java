package com.westos.Information.service.impl.workbench;

import com.westos.Information.bean.*;
import com.westos.Information.dao.*;
import com.westos.Information.service.service.workbench.WbService;
import com.westos.Information.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 工作台
 *
 * @author liuchonghua
 */
@Service
public class WbServiceImpl implements WbService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BuMenDao buMenDao;
    @Autowired
    private GgDao ggDao;
    @Autowired
    private SpDao spDao;
    @Autowired
    private RwDao rwDao;


    @Override
    public WorkBenchList gbmygtj(Msg msg) {
        List<Bumen> list = buMenDao.gbmygtj(Auth.getQiye(msg));
        List<String> name = new ArrayList<>();
        List<String> value = new ArrayList<>();
        for (Bumen bm : list) {
            name.add(bm.getName().substring(0, 2));
            value.add(bm.getRs());
        }
        return new WorkBenchList(name, value);
    }

    @Override
    public WorkBenchList gbmwcrwl(Msg msg) {
        List<Bumen> list = buMenDao.gbmwcrwl(Auth.getQiye(msg));
        List<String> name = new ArrayList<>();
        List<WorkBench> map = new ArrayList<>();
        for (Bumen bm : list) {
            name.add(bm.getName());
            map.add(new WorkBench(bm.getName(), bm.getNum()));
        }
        WorkBenchList wb = new WorkBenchList();
        wb.setName(name);
        wb.setWbmap(map);
        return wb;
    }

    @Override
    public WorkBench wdgg(Msg msg) {
        List<Gonggao> wdList = ggDao.findWdList(Auth.getUser(msg));
        return new WorkBench("未读公告", Integer.toString(wdList.size()));
    }

    @Override
    public WorkBench dsprw(Msg msg) {
        Shenpi sp = new Shenpi();
        sp.setSpr_id(Auth.getUser(msg).getId());
        sp.setType("待审批");
        List<Shenpi> myWsp = spDao.findMyWsp(sp);
        return new WorkBench("待审批", Integer.toString(myWsp.size()));
    }

    @Override
    public WorkBench wksrw(Msg msg) {
        Renwu rw = new Renwu();
        rw.setType("未开始");
        rw.setZx_id(Auth.getUser(msg).getId());
        List<Renwu> myRw = rwDao.findMyRw(rw);
        return new WorkBench("待完成任务", Integer.toString(myRw.size()));
    }

    @Override
    public WorkBench wtgsp(Msg msg) {
        Shenpi sp=new Shenpi();
        sp.setU_id(Auth.getUser(msg).getId());
        sp.setType("待审批");
        List<Shenpi> myWFQ = spDao.findMyWFQ(sp);
        return new WorkBench("待审批申请", Integer.toString(myWFQ.size()));
    }

    @Override
    public WorkRwjx gbmrwjx(Msg msg) {
        List<Bumen> gbmwcrwl = buMenDao.gbmwcrwl(Auth.getQiye(msg));
        WorkRwjx workRwjx = new WorkRwjx();
        List name = new ArrayList();
        List wks = new ArrayList();
        List jxz = new ArrayList();
        List ywc = new ArrayList();
        for (Bumen bm : gbmwcrwl) {
            name.add(bm.getName());
            wks.add(bm.getRwwks());
            jxz.add(bm.getRwjxz());
            ywc.add(bm.getRwywc());
        }
        return new WorkRwjx(name, wks, jxz, ywc);
    }

    @Override
    public WorkRwjx ygrwjx(Msg msg) {
        List<User> ygrwjx = userDao.ygrwjx(Auth.getUser(msg));
        WorkRwjx workRwjx = new WorkRwjx();
        List name = new ArrayList();
        List wks = new ArrayList();
        List jxz = new ArrayList();
        List ywc = new ArrayList();
        for (User user : ygrwjx) {
            name.add(user.getName());
            wks.add(user.getRwwks());
            jxz.add(user.getRwjxz());
            ywc.add(user.getRwywc());
        }
        return new WorkRwjx(name, wks, jxz, ywc);
    }

    @Override
    public WorkRwjx grrwjx(Msg msg) {
        List<User> grrwjx = userDao.grrwjx(Auth.getUser(msg));
        WorkRwjx workRwjx = new WorkRwjx();
        List name = new ArrayList();
        List wks = new ArrayList();
        List jxz = new ArrayList();
        List ywc = new ArrayList();
        for (User user : grrwjx) {
            name.add(user.getName());
            wks.add(user.getRwwks());
            jxz.add(user.getRwjxz());
            ywc.add(user.getRwywc());
        }
        return new WorkRwjx(name, wks, jxz, ywc);
    }

    @Override
    public WorkSpzl grspzl(Msg msg) {
        return spDao.grspzl(Auth.getUser(msg));
    }
}
