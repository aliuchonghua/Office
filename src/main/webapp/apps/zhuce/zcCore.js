var zc = new Vue({
    el: '#zc',
    data: {
        pass2: '',
        qiye: {
            name: '', // 企业名称
            hymc: '', // 行业名称
            clrq: '', // 成立日期
            dq: '', // 地区
            xxdz: '', // 详细地址
            zczj: '', // 注册资金
            jyfw: '', // 经营范围
            qyjj: '' // 企业简介
        },
        user: {
            sjh: '', // 手机号
            pass: '', //密码
            pass2: '' //密码
        },
        mess: {
            sjh: '',
            pass: '',
            pass2: '',
            name: '',
            hymc: '',
            clrq: '',
            zczj: '',
            xxdz: '',
            jyfw: ''
        },
        city: {
            sheng: '',
            shi: '',
            xian: ''
        },
        msg: {
            qiye: {},
            user: {}
        },
        sheng: [],
        shi: [],
        xian: [],
        i: false,
        Modal: ''
    },
    methods: {
        back: function () {
            $("#app").show();
            $("#app2").hide();
            $("#app2").html('');
        },
        //获取省份
        getsheng: function () {
            axios.get('/city/sheng').then(function (value) {
                zc.city.sheng = value.data[0].cityname;
                for (var i = 0; i < value.data.length; i++) {
                    zc.sheng.push(value.data[i]);
                }
                zc.getshi(value.data[0]);
            }).catch(function (reason) {
                console.log(reason);
            });
        },
        //获取城市
        getshi: function (item) {
            zc.shi = [];
            zc.xian = [];
            axios.post('/city/shi', item).then(function (value) {
                zc.city.shi = value.data[0].cityname;
                for (var i = 0; i < value.data.length; i++) {
                    zc.shi.push(value.data[i]);
                }
                zc.getxian(value.data[0]);
            }).catch(function (reason) {
                console.log(reason);
            });
        },
        //获取县
        getxian: function (item) {
            zc.xian = [];
            axios.post('/city/xian', item).then(function (value) {
                zc.city.xian = value.data[0].cityname;
                for (var i = 0; i < value.data.length; i++) {
                    zc.xian.push(value.data[i]);
                }
            }).catch(function (reason) {
                console.log(reason);
            });
        },
        //注册
        registered: function () {
            //验证
            zc.i = true;
            zc.yzsjh();
            zc.yzpass();
            zc.yzpass2();
            zc.yzname();
            zc.yzhymc();
            zc.yzzczj();
            zc.yzxxdz();
            zc.yzjyfw();
            zc.yzclrq();
            //拼接省市县
            zc.qiye.dq = zc.city.sheng + zc.city.shi + zc.city.xian;
            if (zc.i) {
                zc.msg.qiye = zc.qiye;
                zc.msg.user = zc.user;
                axios.post('/registered/CreateQiye', zc.msg).then(function (value) {
                    $('#zcModal').modal('show');
                    zc.Modal = value.data.mess;
                    if (value.data.type != -1) {
                        $('#zcModal').on('hide.bs.modal',function () {
                            zc.back();
                        });
                    }
                }).catch(function (reason) {
                    console.log(reason);
                });
            } else {
                zc.Modal = '格式有误请检查';
                $('#zcModal').modal('show');
            }
        },
        //验证管理员账户
        yzsjh: function () {
            if (zc.user.sjh == '') {
                zc.mess.sjh = '账户不能为空';
                $("[name='sjh']").parent().addClass('has-error');
                zc.i = false;
            } else if (zc.user.sjh.length > 11 || zc.user.sjh.length < 6) {
                zc.mess.sjh = '账户需要为6到11位';
                $("[name='sjh']").parent().addClass('has-error');
                zc.i = false;
            } else {
                $("[name='sjh']").parent().removeClass('has-error');
                $("[name='sjh']").parent().addClass('has-success');
                zc.mess.sjh = '';
                axios.post('/registered/yzsjhPresence', zc.user).then(function (value) {
                    if (value.data.mess == '1') {
                        zc.mess.sjh = '账户已存在';
                        $("[name='sjh']").parent().addClass('has-error');
                        zc.i = false;
                    } else {
                        $("[name='sjh']").parent().removeClass('has-error');
                        $("[name='sjh']").parent().addClass('has-success');
                        zc.mess.sjh = '';
                    }
                }).catch(function (reason) {
                    console.log(reason);
                });
            }
        },
        //验证密码
        yzpass: function () {
            if (zc.user.pass == '') {
                zc.mess.pass = '密码不能为空';
                $("[name='pass']").parent().addClass('has-error');
                zc.i = false;
            } else if (zc.user.pass.length > 11 || zc.user.pass.length < 6) {
                zc.mess.pass = '密码需要为6到11位';
                $("[name='pass']").parent().addClass('has-error');
                zc.i = false;
            } else {
                $("[name='pass']").parent().removeClass('has-error');
                $("[name='pass']").parent().addClass('has-success');
                zc.mess.pass = '';
            }
        },
        //验证密码
        yzpass2: function () {
            if (zc.user.pass2 == '') {
                zc.mess.pass2 = '密码不能为空';
                $("[name='pass2']").parent().addClass('has-error');
                zc.i = false;
            } else if (zc.user.pass != zc.user.pass2) {
                zc.mess.pass2 = '两次密码不一致';
                $("[name='pass2']").parent().addClass('has-error');
                zc.i = false;
            } else {
                $("[name='pass2']").parent().removeClass('has-error');
                $("[name='pass2']").parent().addClass('has-success');
                zc.mess.pass2 = '';
            }
        },
        yzname: function () {
            if (zc.qiye.name == '') {
                zc.mess.name = '企业名称不能为空';
                $("[name='name']").parent().addClass('has-error');
                zc.i = false;
            } else {
                $("[name='name']").parent().removeClass('has-error');
                $("[name='name']").parent().addClass('has-success');
                zc.mess.name = '';
            }
        },
        yzhymc: function () {
            if (zc.qiye.hymc == '') {
                zc.mess.hymc = '行业名称不能为空';
                $("[name='hymc']").parent().addClass('has-error');
                zc.i = false;
            } else {
                $("[name='hymc']").parent().removeClass('has-error');
                $("[name='hymc']").parent().addClass('has-success');
                zc.mess.hymc = '';
            }
        },
        yzzczj: function () {
            if (zc.qiye.zczj == '') {
                zc.mess.zczj = '注册资金不能为空';
                $("[name='zczj']").parent().addClass('has-error');
                zc.i = false;
            } else {
                $("[name='zczj']").parent().removeClass('has-error');
                $("[name='zczj']").parent().addClass('has-success');
                zc.mess.zczj = '';
            }
        },
        yzxxdz: function () {
            if (zc.qiye.xxdz == '') {
                zc.mess.xxdz = '详细地址不能为空';
                $("[name='xxdz']").parent().addClass('has-error');
                zc.i = false;
            } else {
                $("[name='xxdz']").parent().removeClass('has-error');
                $("[name='xxdz']").parent().addClass('has-success');
                zc.mess.xxdz = '';
            }
        },
        yzjyfw: function () {
            if (zc.qiye.jyfw == '') {
                zc.mess.jyfw = '经营范围不能为空';
                $("[name='jyfw']").parent().addClass('has-error');
                zc.i = false;
            } else {
                $("[name='jyfw']").parent().removeClass('has-error');
                $("[name='jyfw']").parent().addClass('has-success');
                zc.mess.jyfw = '';
            }
        },
        yzclrq: function () {
            zc.qiye.clrq = $("#clrq").val();
            if (zc.qiye.clrq == '') {
                zc.mess.clrq = '成立日期不能为空';
                $("[name='clrq']").parent().addClass('has-error');
                zc.i = false;
            } else {
                $("[name='clrq']").parent().removeClass('has-error');
                $("[name='clrq']").parent().addClass('has-success');
                zc.mess.clrq = '';
            }
        }
    },
    mounted: function () {
        //日期弹窗初始化
        laydate.render({
            elem: '#clrq',
            done:function (value) {
                zc.qiye.clrq=value;
            }
        });
        //zc初始化
        this.$nextTick(function () {
            zc.getsheng();
        })
    }
});
