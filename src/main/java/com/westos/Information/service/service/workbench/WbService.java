package com.westos.Information.service.service.workbench;

import com.westos.Information.bean.*;

/**
 * 工作台
 */
public interface WbService {
    //各部门员工统计
    WorkBenchList gbmygtj(Msg msg);

    //各部门完成任务量
    WorkBenchList gbmwcrwl(Msg msg);

    //未读公告
    WorkBench wdgg(Msg msg);

    //待审批任务数量
    WorkBench dsprw(Msg msg);

    //未开始任务
    WorkBench wksrw(Msg msg);

    //未通过审批
    WorkBench wtgsp(Msg msg);

    //各部门任务绩效
    WorkRwjx gbmrwjx(Msg msg);

    //员工任务绩效
    WorkRwjx ygrwjx(Msg msg);

    //个人任务绩效
    WorkRwjx grrwjx(Msg msg);

    //个人审批类型
    WorkSpzl grspzl(Msg msg);

}
