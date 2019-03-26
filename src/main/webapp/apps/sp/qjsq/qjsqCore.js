var qjsq = new Vue({
    el: '#qjsqapp',
    data: {
        sp: {
            spr_id: '', //审批人
            spr_name: '',
            start_time: '', //开始时间
            end_time: '', //结束时间
            yy: '' //原因
        },
        sprlist: [],
        msg: {
            mess: ''
        }
    },
    methods: {
        add: function () {
            var addform = $("#add").data('bootstrapValidator');
            addform.validate();
            if (addform.isValid()) {
                axios.post('/sp/spgl/askForLeave', qjsq.sp).then(function (result) {
                    qjsq.msg.mess = result.data.mess;
                    $('#msg').modal('show');
                }).catch(function (err) {
                    console.log(err);
                });
            }
        },
        setspr: function (user) {
            qjsq.sp.spr_id = user.id;
            qjsq.sp.spr_name = user.name;
        },
        findspr: function () {
            axios.get('/sp/spgl/findspr').then(function (result) {
                qjsq.sprlist = result.data;
                qjsq.sp.spr_id=result.data[0].id;
                qjsq.sp.spr_name=result.data[0].name;
            }).catch(function (err) {
                console.log(err);
            });
        }
    },
    mounted: function () {
        this.findspr();
        laydate.render({
            elem: '#kssj',
            type: 'datetime',
            done: function (value) {
                qjsq.sp.start_time = value;
            }
        });
        laydate.render({
            elem: '#jssj',
            type: 'datetime',
            done: function (value) {
                qjsq.sp.end_time = value;
            }
        });
        $('#msg').on('hide.bs.modal',
            function () {
                qjsq.sp = {
                    yy: '' //原因
                };
                $("#add").data("bootstrapValidator").resetForm();
            }
        );
    }
});
$(document).ready(function () {
    $("#add").bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            yy: {
                message: '请假原因错误',
                validators: {
                    notEmpty: {
                        message: '内容不能为空'
                    },
                    stringLength: {
                        max: 200,
                        message: '字数不能大于200'
                    }
                }
            },
            spr: {
                message: '审批人错误',
                validators: {
                    notEmpty: {
                        message: '内容不能为空'
                    }
                }
            }
        }
    });
});
