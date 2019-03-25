var qygl = new Vue({
    el: '#qyglapp',
    data: {
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
        editqiye: {
            name: '', // 企业名称
            hymc: '', // 行业名称
            clrq: '', // 成立日期
            dq: '', // 地区
            xxdz: '', // 详细地址
            zczj: '', // 注册资金
            jyfw: '', // 经营范围
            qyjj: '' // 企业简介
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
            axios.get('/zzjg/qygl/find').then(function (result) {
                qygl.qiye = result.data;
                qygl.qiye.clrq = Global.Fun.Format(result.data.clrq, "yyyy-MM-dd");
                qygl.getsheng();
            }).catch(function (err) {
                console.log(err);
            });
        },
        editOpen: function () {
            $('#edit').modal('show');
            qygl.editqiye = qygl.qiye;
            //回填省市县
            Global.Fun.ajaxGet('/city/sheng', function (value) {
                qygl.sheng = value;
            });
            qygl.city.sheng = qygl.qiye.dq.split(",")[0];
            qygl.city.shi = qygl.qiye.dq.split(",")[1];
            qygl.city.xian = qygl.qiye.dq.split(",")[2];
            Global.Fun.ajaxPost('/city/getShengByName', {cityname: qygl.city.sheng}, function (data) {
                qygl.shi = [];
                qygl.xian = [];
                Global.Fun.ajaxPost('/city/shi', data, function (data) {
                    qygl.shi = data;
                    Global.Fun.ajaxPost('/city/getshiByName', {cityname: qygl.city.shi}, function (data) {
                        qygl.xian = [];
                        Global.Fun.ajaxPost('/city/xian', data, function (data) {
                            qygl.xian = data;
                        });
                    });

                })

            })
        },
        edit: function () {
            var modifyform = $("#editform").data('bootstrapValidator');
            modifyform.validate();
            if (modifyform.isValid()) {
                qygl.editqiye.dq = qygl.city.sheng + "," + qygl.city.shi + "," + qygl.city.xian;
                axios.post('/zzjg/qygl/modify', qygl.editqiye).then(function (result) {
                    qygl.msg.mess = result.data.mess;
                    $('#edit').modal('hide');
                    $('#msg').modal('show');
                }).catch(function (err) {
                    console.log(err);
                });
            }
        },
        logoutOpen: function () {
            $('#logout').modal('show');
        },
        logout: function () {
            axios.get('/zzjg/qygl/logout', qygl.editqiye).then(function (result) {
                if (result.data.type===3){
                    window.location.href = '/index.html';
                }else {
                    qygl.msg.mess = result.data.mess;
                    $('#logout').modal('hide');
                    $('#msg').modal('show');
                }
            }).catch(function (err) {
                console.log(err);
            });
        },
        //获取省份
        getsheng: function () {
            axios.get('/city/sheng').then(function (value) {
                qygl.city.sheng = value.data[0].cityname;
                qygl.sheng = value.data;
                qygl.getshi(value.data[0]);
            }).catch(function (reason) {
                console.log(reason);
            });
        },
        //获取城市
        getshi: function (item) {
            qygl.shi = [];
            qygl.xian = [];
            axios.post('/city/shi', item).then(function (value) {
                qygl.city.shi = value.data[0].cityname;
                qygl.shi = value.data;
                qygl.getxian(value.data[0]);
            }).catch(function (reason) {
                console.log(reason);
            });
        },
        //获取县
        getxian: function (item) {
            qygl.xian = [];
            axios.post('/city/xian', item).then(function (value) {
                qygl.xian = value.data;
                qygl.city.xian = value.data[0].cityname;
            }).catch(function (reason) {
                console.log(reason);
            });
        }

    },
    mounted: function () {
        this.init();
        $('#edit').on('hide.bs.modal',
            function () {
                editqiye = {
                    name: '', // 企业名称
                    hymc: '', // 行业名称
                    clrq: '', // 成立日期
                    dq: '', // 地区
                    xxdz: '', // 详细地址
                    zczj: '', // 注册资金
                    jyfw: '', // 经营范围
                    qyjj: '' // 企业简介
                }
                //表单验证初始化
                $("#editform").data("bootstrapValidator").resetForm();
            }
        );
    }
});

/**
 * 加载表单验证配置
 */
$(document).ready(function () {
    $("#editform").bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: '企业名称错误',
                validators: {
                    notEmpty: {
                        message: '企业名称不能为空'
                    }
                }
            },
            hymc: {
                message: '行业名称错误',
                validators: {
                    notEmpty: {
                        message: '行业名称不能为空'
                    }
                }
            },
            xxdz: {
                message: '详细地址错误',
                validators: {
                    notEmpty: {
                        message: '详细地址不能为空'
                    }
                }
            },
            jyfw: {
                message: '经营范围错误',
                validators: {
                    notEmpty: {
                        message: '经营范围不能为空'
                    }
                }
            }
        }
    });
})

