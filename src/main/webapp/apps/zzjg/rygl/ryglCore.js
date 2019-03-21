var rygl = new Vue({
    el: '#ryglapp',
    data: {
        formTitle: '',
        userlist: [],
        user: {
            id: '',
            sjh: '',
            name: '',
            csny: '',
            xb: '男',
            zhlx: '3',
            zhlx_name: '',
            dq: '',
            qy_id: '',
            qy_name: '',
            bm_id: '',
            bm_name: '',
            pass: ''
        },
        bmlist: [],
        bm: {
            id: '',
            name: ''
        },
        frombm: {
            id: '',
            name: ''
        },
        msg: {
            mess: ''
        },
        sheng: [],
        shi: [],
        xian: [],
        city: {
            sheng: '',
            shi: '',
            xian: ''
        }
    },
    methods: {
        init: function () {
            axios.post('/zzjg/rygl/findlist',rygl.bm).then(function (result) {
                rygl.userlist = result.data;
            }).catch(function (err) {
                console.log(err);
            });
        },
        getbm: function () {
            axios.get('/zzjg/bmgl/findlist').then(function (result) {
                rygl.bmlist = result.data;
                rygl.frombm=result.data;
                rygl.bm=result.data[0];
                rygl.user.bm_id=result.data[0].id;
                rygl.user.bm_name=result.data[0].name;
                rygl.init();
            }).catch(function (err) {
                console.log(err);
            });
        },
        setbm:function(bm){
            rygl.bm=bm;
            rygl.init();
        },
        setFromBm:function(bm){
            rygl.user.bm_id=bm.id;
            rygl.user.bm_name=bm.name;
        },
        addOpen: function () {
            $('#ryglform').modal('show');
            laydate.render({
                elem: '#csny',
                done: function (value) {
                    rygl.user.csny = value;
                }
            });
            rygl.formTitle = '新增';
            rygl.getsheng();
        },
        modifyOpen: function (item) {
            $('#ryglform').modal('show');
            laydate.render({
                elem: '#csny',
                done: function (value) {
                    rygl.user.csny = value;
                }
            });
            rygl.formTitle = '修改';
            rygl.user = item;
            //回填日期
            rygl.user.csny=Global.Fun.Format(item.csny,"yyyy-MM-dd");
            //回填部门
            rygl.frombm.id=item.bm_id;
            rygl.frombm.name=item.bm_name;
            //回填省市县
            Global.Fun.ajaxGet('/city/sheng',function (value) {
                rygl.sheng=value;
            });
            rygl.city.sheng=item.dq.split(",")[0];
            Global.Fun.ajaxPost('/city/getShengByName',{cityname:rygl.city.sheng},function (data) {
                rygl.shi = [];
                rygl.xian = [];
                Global.Fun.ajaxPost('/city/shi',data,function (data) {
                    rygl.shi=data;
                    rygl.city.shi=item.dq.split(",")[1];
                    Global.Fun.ajaxPost('/city/getshiByName',{cityname:rygl.city.shi},function (data) {
                        rygl.xian = [];
                        Global.Fun.ajaxPost('/city/xian',data,function (data) {
                            rygl.xian=data;
                            rygl.city.xian=item.dq.split(",")[2];
                        });
                    });

                })

            })

        },
        submit: function () {
            var modifyform = $("#userform").data('bootstrapValidator');
            modifyform.validate();
            if(rygl.formTitle==='新增'){
                if (modifyform.isValid()) {
                    // 拼接地区
                    rygl.user.dq=rygl.city.sheng +","+ rygl.city.shi +","+ rygl.city.xian;
                    axios.post('/zzjg/rygl/add', rygl.user).then(function (result) {
                        rygl.msg.mess = result.data.mess;
                        $('#ryglform').modal('hide');
                        $('#msg').modal('show');
                        rygl.init();
                    }).catch(function (err) {
                        console.log(err);
                    });
                }
            }else if (rygl.formTitle==='修改') {
                if (modifyform.isValid()) {
                    // 拼接地区
                    rygl.user.dq=rygl.city.sheng +","+ rygl.city.shi +","+ rygl.city.xian;
                    axios.post('/zzjg/rygl/modify', rygl.user).then(function (result) {
                        rygl.msg.mess = result.data.mess;
                        $('#ryglform').modal('hide');
                        $('#msg').modal('show');
                        rygl.init();
                    }).catch(function (err) {
                        console.log(err);
                    });
                }
            }

        },
        remove: function (bm) {
            axios.post('/zzjg/rygl/remove', bm).then(function (result) {
                rygl.msg.mess = result.data.mess;
                $('#msg').modal('show');
                rygl.init();
            }).catch(function (err) {
                console.log(err);
            });
        },
        //获取省份
        getsheng: function () {
            axios.get('/city/sheng').then(function (value) {
                rygl.city.sheng = value.data[0].cityname;
                rygl.sheng=value.data;
                rygl.getshi(value.data[0]);
            }).catch(function (reason) {
                console.log(reason);
            });
        },
        //获取城市
        getshi: function (item) {
            rygl.shi = [];
            rygl.xian = [];
            axios.post('/city/shi', item).then(function (value) {
                rygl.city.shi = value.data[0].cityname;
                rygl.shi=value.data;
                rygl.getxian(value.data[0]);
            }).catch(function (reason) {
                console.log(reason);
            });
        },
        //获取县
        getxian: function (item) {
            rygl.xian = [];
            axios.post('/city/xian', item).then(function (value) {
                rygl.xian=value.data;
                rygl.city.xian = value.data[0].cityname;
            }).catch(function (reason) {
                console.log(reason);
            });
        }
    },
    mounted: function () {
        this.getbm();
        $('#ryglform').on('hide.bs.modal',
            function () {
                rygl.user = {
                    id: '',
                    sjh: '',
                    name: '',
                    csny: '',
                    xb: '男',
                    zhlx: '3',
                    zhlx_name: '',
                    dq: '',
                    qy_id: '',
                    qy_name: '',
                    bm_id: rygl.bm.id,
                    bm_name: rygl.bm.name,
                    pass: ''
                };
                $("#userform").data("bootstrapValidator").resetForm();
                rygl.init();
            }
        );


    }
});
$(document).ready(function () {
    $("#userform").bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: '姓名校验',
                validators: {
                    notEmpty: {
                        message: '姓名不能为空'
                    }
                }
            },
            sjh: {
                message: '手机号校验',
                validators: {
                    notEmpty: {
                        message: '手机号不能为空'
                    },
                    stringLength: {
                        min: 11,
                        max: 11,
                        message: '手机号必须为11位'
                    }
                }
            },
            csny: {
                message: '出生年月校验',
                validators: {
                    notEmpty: {
                        message: '出生年月不能为空'
                    }
                }
            },
            zhlx_name: {
                message: '职位校验',
                validators: {
                    notEmpty: {
                        message: '职位不能为空'
                    }
                }
            },
            pass: {
                message: '密码校验',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 20,
                        message: '密码长度必须在6到20位'
                    }
                },

            }
        }
    });
});
//表单验证

