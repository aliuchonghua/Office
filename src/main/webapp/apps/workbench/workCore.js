var workDate = {};
var workbench = new Vue({
    el: '#workbench',
    data: {},
    methods: {
        //获取数据
        initWorkBenchData: function () {
            if (Global.user.zhlx === 0) {//管理员
                Global.Fun.ajaxGet('/workbench/wb/gbmygtj', function (data) {
                    workDate.bmyg = data;
                });
                //各部门任务绩效
                Global.Fun.ajaxGet('/workbench/wb/gbmrwjx', function (data) {
                    workDate.workrwjx = data;
                });
            } else if (Global.user.zhlx === 1) {//领导
                Global.Fun.ajaxGet('/workbench/wb/gbmygtj', function (data) {
                    workDate.bmyg = data;
                });
                //未读公告
                Global.Fun.ajaxGet('/workbench/wb/wdgg', function (data) {
                    workDate.wdgg = data;
                });
                //待审批任务
                Global.Fun.ajaxGet('/workbench/wb/dsprw', function (data) {
                    workDate.dsprw = data;
                });
                //各部门任务绩效
                Global.Fun.ajaxGet('/workbench/wb/gbmrwjx', function (data) {
                    workDate.workrwjx = data;
                });
            } else if (Global.user.zhlx === 2) {//负责人
                //未读公告
                Global.Fun.ajaxGet('/workbench/wb/wdgg', function (data) {
                    workDate.wdgg = data;
                });
                //待审批任务
                Global.Fun.ajaxGet('/workbench/wb/dsprw', function (data) {
                    workDate.dsprw = data;
                });
                //未开始任务
                Global.Fun.ajaxGet('/workbench/wb/wksrw', function (data) {
                    workDate.wksrw = data;
                });
                //下属任务绩效
                Global.Fun.ajaxGet('/workbench/wb/ygrwjx', function (data) {
                    workDate.ygrwjx = data;
                });
                //个人任务绩效
                Global.Fun.ajaxGet('/workbench/wb/grrwjx', function (data) {
                    workDate.grrwjx = data;
                });

            } else if (Global.user.zhlx === 3) {//员工
                //未读公告
                Global.Fun.ajaxGet('/workbench/wb/wdgg', function (data) {
                    workDate.wdgg = data;
                });
                //未开始任务
                Global.Fun.ajaxGet('/workbench/wb/wksrw', function (data) {
                    workDate.wksrw = data;
                });
                //个人任务绩效
                Global.Fun.ajaxGet('/workbench/wb/grrwjx', function (data) {
                    workDate.grrwjx = data;
                });
                //未通过审批
                Global.Fun.ajaxGet('/workbench/wb/wtgsp', function (data) {
                    workDate.wtgsp = data;
                });
                //个人审批种类
                Global.Fun.ajaxGet('/workbench/wb/grspzl', function (data) {
                    workDate.grspzl = data;
                });

            }
        },
        // 加载工作台
        loadWorkbench: function () {
            if (Global.user.zhlx === 0) {//管理员
                this.gbmygtj();
                this.gbmrwjx();//各部门任务绩效
            } else if (Global.user.zhlx === 1) {//领导
                $("#wdjs").show();
                this.gbmygtj();
                this.wdgg();
                this.dsprw();
                this.gbmrwjx();//各部门任务绩效
            } else if (Global.user.zhlx === 2) {//负责人
                $("#wdjs").show();
                this.wdgg();//未读公告计数
                this.dsprw();//待审批计数
                this.wksrw();//未开始任务计数
                this.xsrwjx();//下属任务绩效
                this.grrwjx();//个人任务绩效
            } else if (Global.user.zhlx === 3) {//员工
                $("#wdjs").show();
                this.wdgg();
                this.wksrw();
                this.grrwjx();//个人任务绩效
                this.wtgsp();//未通过审批计数
                this.grspzl();//个人审批种类

            }
        },
        gbmygtj: function () {
            $("#gbmygtj").show();
            var rytj = echarts.init(document.getElementById('rytj'), 'macarons');
            var option = {
                title: {
                    text: '各部门员工统计'
                },
                tooltip: {},
                legend: {
                    data: ['人数']
                },
                xAxis: {
                    data: workDate.bmyg.name
                },
                yAxis: {},
                series: [{
                    name: '人数',
                    type: 'bar',
                    data: workDate.bmyg.value
                }]
            };
            rytj.setOption(option);
            window.addEventListener("resize", function () {
                rytj.resize();
            });
        },
        gbmjxtj: function () {
            $("#gbmjxtj").show();
            var jxtj = echarts.init(document.getElementById('jxtj'), 'macarons');
            var option = {
                title: {
                    text: '各部门绩效统计',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: workDate.bmjx.name
                },
                series: [{
                    name: '完成任务数量',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: workDate.bmjx.wbmap,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }]
            };
            jxtj.setOption(option);
            window.addEventListener("resize", function () {
                jxtj.resize();
            });
        },
        //未读公告
        wdgg: function () {
            $("#wdggjs").show();
            var jxtj = echarts.init(document.getElementById('wdgg'), 'macarons');
            var option = {
                tooltip: {
                    formatter: "{a} <br/>{b} : {c}个"
                },
                toolbox: {
                    feature: {
                        restore: {},
                        saveAsImage: {}
                    }
                },

                series: [
                    {
                        name: '公告',
                        type: 'gauge',
                        max: 20,
                        detail: {formatter: '{value}个'},
                        data: [workDate.wdgg]
                    }
                ]
            };
            jxtj.setOption(option);
            window.addEventListener("resize", function () {
                jxtj.resize();
            });

        },
        //待审批任务数量
        dsprw: function () {
            $("#dsprwjs").show();
            var jxtj = echarts.init(document.getElementById('dsprw'), 'macarons');
            var option = {
                tooltip: {
                    formatter: "{a} <br/>{b} : {c}个"
                },
                toolbox: {
                    feature: {
                        restore: {},
                        saveAsImage: {}
                    }
                },

                series: [
                    {
                        name: '审批',
                        type: 'gauge',
                        max: 20,
                        detail: {formatter: '{value}个'},
                        data: [workDate.dsprw]
                    }
                ]
            };
            jxtj.setOption(option);
            window.addEventListener("resize", function () {
                jxtj.resize();
            });

        },
        //未开始任务
        wksrw: function () {
            $("#wwcrwjs").show();
            var jxtj = echarts.init(document.getElementById('wwcrw'), 'macarons');
            var option = {
                tooltip: {
                    formatter: "{a} <br/>{b} : {c}个"
                },
                toolbox: {
                    feature: {
                        restore: {},
                        saveAsImage: {}
                    }
                },

                series: [
                    {
                        name: '任务',
                        type: 'gauge',
                        max: 20,
                        detail: {formatter: '{value}个'},
                        data: [workDate.wksrw]
                    }
                ]
            };
            jxtj.setOption(option);
            window.addEventListener("resize", function () {
                jxtj.resize();
            });
        },
        //未通过审批
        wtgsp: function () {
            $("#wtgsp").show();
            var jxtj = echarts.init(document.getElementById('wtgsptb'), 'macarons');
            var option = {
                tooltip: {
                    formatter: "{a} <br/>{b} : {c}个"
                },
                toolbox: {
                    feature: {
                        restore: {},
                        saveAsImage: {}
                    }
                },

                series: [
                    {
                        name: '审批',
                        type: 'gauge',
                        max: 10,
                        detail: {formatter: '{value}个'},
                        data: [workDate.wtgsp]
                    }
                ]
            };
            jxtj.setOption(option);
            window.addEventListener("resize", function () {
                jxtj.resize();
            });
        },
        //各部门任务绩效
        gbmrwjx: function () {
            $("#gbmrwjx").show();
            var jxtj = echarts.init(document.getElementById('rwjx'), 'macarons');
            var option = {
                title: {
                    text: '部门任务绩效',
                    x: 'left'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data: ['未开始', '进行中', '已完成']
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: {
                    type: 'value'
                },
                yAxis: {
                    type: 'category',
                    data: workDate.workrwjx.name//部门名
                },
                series: [
                    {
                        name: '未开始',
                        type: 'bar',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'insideRight'
                            }
                        },
                        data: workDate.workrwjx.wks
                    },
                    {
                        name: '进行中',
                        type: 'bar',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'insideRight'
                            }
                        },
                        data: workDate.workrwjx.jxz
                    },
                    {
                        name: '已完成',
                        type: 'bar',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'insideRight'
                            }
                        },
                        data: workDate.workrwjx.ywc
                    }
                ]
            };
            jxtj.setOption(option);
            window.addEventListener("resize", function () {
                jxtj.resize();
            });
        },
        //下属任务绩效
        xsrwjx: function () {
            $("#xsrwjx").show();
            var jxtj = echarts.init(document.getElementById('xsrwjxtb'), 'macarons');
            var option = {
                title: {
                    text: '员工任务绩效',
                    x: 'left'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data: ['未开始', '进行中', '已完成']
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: {
                    type: 'value'
                },
                yAxis: {
                    type: 'category',
                    data: workDate.ygrwjx.name//人员名
                },
                series: [
                    {
                        name: '未开始',
                        type: 'bar',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'insideRight'
                            }
                        },
                        data: workDate.ygrwjx.wks
                    },
                    {
                        name: '进行中',
                        type: 'bar',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'insideRight'
                            }
                        },
                        data: workDate.ygrwjx.jxz
                    },
                    {
                        name: '已完成',
                        type: 'bar',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'insideRight'
                            }
                        },
                        data: workDate.ygrwjx.ywc
                    }
                ]
            };
            jxtj.setOption(option);
            window.addEventListener("resize", function () {
                jxtj.resize();
            });
        },
        //个人任务绩效
        grrwjx: function () {
            $("#grrwjx").show();
            var rytj = echarts.init(document.getElementById('grrwjxtb'), 'macarons');
            var option = {
                title: {
                    text: '个人任务绩效',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c} ({d}个)"
                },
                legend: {
                    orient: 'vertical',
                    x: 'left',
                    data: ['未开始', '进行中', '已完成']
                },
                series: [
                    {
                        name: '任务状态',
                        type: 'pie',
                        radius: ['50%', '70%'],
                        avoidLabelOverlap: false,
                        label: {
                            normal: {
                                show: false,
                                position: 'center'
                            },
                            emphasis: {
                                show: true,
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'bold'
                                }
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            }
                        },
                        data: [
                            {value: workDate.grrwjx.wks, name: '未开始'},
                            {value: workDate.grrwjx.jxz, name: '进行中'},
                            {value: workDate.grrwjx.ywc, name: '已完成'}
                        ]
                    }
                ]
            };

            rytj.setOption(option);
            window.addEventListener("resize", function () {
                rytj.resize();
            });
        },
        //个人申请类型
        grspzl: function () {
            $("#grspzl").show();
            var rytj = echarts.init(document.getElementById('grspzltb'), 'macarons');
            var option = {
                title: {
                    text: '个人申请类型',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c} ({d}个)"
                },
                legend: {
                    orient: 'vertical',
                    x: 'left',
                    data: ['加班', '请假', '出差']
                },
                series: [
                    {
                        name: '申请类型',
                        type: 'pie',
                        radius: ['50%', '70%'],
                        avoidLabelOverlap: false,
                        label: {
                            normal: {
                                show: false,
                                position: 'center'
                            },
                            emphasis: {
                                show: true,
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'bold'
                                }
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            }
                        },
                        data: [
                            {value: workDate.grspzl.jb, name: '加班'},
                            {value: workDate.grspzl.qj, name: '请假'},
                            {value: workDate.grspzl.cc, name: '出差'}
                        ]
                    }
                ]
            };
            rytj.setOption(option);
            window.addEventListener("resize", function () {
                rytj.resize();
            });
        },

    },
    mounted: function () {
        this.initWorkBenchData();
        this.loadWorkbench();
    }
});
