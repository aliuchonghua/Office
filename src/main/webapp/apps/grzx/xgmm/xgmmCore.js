var xgmm = new Vue({
    el: '#xgmmapp',
    data: {
        pass: {
            pass: '',
            xpass: '',
            xpass2: ''
        },
        user: {
            pass: ''
        },
        msg: {
            mess: ''
        }
    },
    methods: {
        modify: function () {
            xgmm.user.pass = '';
            var modifyform = $("#editform").data('bootstrapValidator');
            modifyform.validate();
            if (modifyform.isValid()) {
                xgmm.user.pass = xgmm.pass.xpass2;
                axios.post('/grzx/grxx/modify', xgmm.user).then(function (result) {
                    xgmm.msg.mess = result.data.mess;
                    $('#edit').modal('hide');
                    $('#msg').modal('show');
                }).catch(function (err) {
                    console.log(err);
                });
            }
        },
    },
    mounted: function () {
        $('#msg').on('hide.bs.modal',
            function () {
                xgmm.pass = {
                    pass: '',
                    xpass: '',
                    xpass2: ''
                };
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
            pass: {
                message: '原始密码错误',
                validators: {
                    notEmpty: {
                        message: '原始密码不能为空'
                    },
                    stringLength: {
                        min: 4,
                        max: 30,
                        message: '密码长度必须在6到11之间'
                    },
                    remote: {
                        url: '/grzx/grxx/verification',
                        message: '原始密码错误',
                        type: 'get',
                        dataType: 'json',
                        delay: 500
                    }
                }
            },
            xpass: {
                message: '新密码错误',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 4,
                        max: 30,
                        message: '密码长度必须在6到11之间'
                    },
                    different: {
                        field: 'pass',
                        message: '不能和原始密码相同'
                    }
                }
            },
            xpass2: {
                message: '再次输入错误',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 4,
                        max: 30,
                        message: '密码长度必须在6到11之间'
                    },
                    identical: {
                        field: 'xpass',
                        message: '两次密码不一致'
                    },
                    different: {
                        field: 'pass',
                        message: '不能和原始密码相同'
                    }
                }
            }
        }
    });
})





