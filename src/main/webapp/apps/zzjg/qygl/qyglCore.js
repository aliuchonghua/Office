var qygl = new Vue({
    el: '#qyglapp',
    data: {
        formTitle: '',
        bmlist: [],
        bm: {
            id: '',
            fjqx: '',
            name: ''
        },
        msg: {
            mess: ''
        }
    },
    methods: {
        init: function () {
            axios.get('/zzjg/qygl/findlist').then(function (result) {
                qygl.bmlist = result.data;
            }).catch(function (err) {
                console.log(err);
            });

        },
        addopen: function () {
            qygl.formTitle = '新增';
            $("#qxfrom").show();
            $('#add').modal('show');
        },
        modifyopen: function (bm) {
            if (bm.id === '') {
                $("#qxfrom").hide();
            } else {
                $("#qxfrom").show();
            }
            qygl.formTitle = '编辑';
            qygl.bm = bm;
            if (bm.fjqx !== null) {
                //回填多选下拉框
                Global.Fun.ajaxPost('/mkgl/fingModuleByname', bm, function (data) {
                    var arr = data.fjqx.split(',');
                    $('.selectpicker').selectpicker('val', arr);
                })
            }
            $('#add').modal('show');
        },
        /**
         * 新增方法
         */
        add: function () {
            var addform = $("#addform").data('bootstrapValidator');
            addform.validate();
            if (addform.isValid()) {
                var qx = $("#fjqx").val();
                //拼接附加权限id
                if (qx !== null) {
                    qygl.bm.fjqx='';
                    for (var i = 0; i < qx.length; i++) {
                        qygl.bm.fjqx += qx[i];
                        qygl.bm.fjqx += ',';
                    }
                    qygl.bm.fjqx = qygl.bm.fjqx.substr(0, qygl.bm.fjqx.length - 1);
                }
                if (qygl.bm.id===''){//新增
                    axios.post('/zzjg/qygl/add', qygl.bm).then(function (result) {
                        qygl.msg.mess = result.data.mess;
                        $('#add').modal('hide');
                        $('#msg').modal('show');
                        qygl.init();
                    }).catch(function (err) {
                        console.log(err);
                    });
                }else {//编辑
                    axios.post('/zzjg/qygl/modify', qygl.bm).then(function (result) {
                        qygl.msg.mess = result.data.mess;
                        $('#add').modal('hide');
                        $('#msg').modal('show');
                        qygl.init();
                    }).catch(function (err) {
                        console.log(err);
                    });
                }
            }
        },
        remove: function (bm) {
            if(bm.rs!=='0'){
                qygl.msg.mess='无法删除,还存在绑定的员工';
                $('#msg').modal('show');
            }else {
                axios.post('/zzjg/qygl/remove', bm).then(function (result) {
                    qygl.msg.mess = result.data.mess;
                    $('#msg').modal('show');
                    qygl.init();
                }).catch(function (err) {
                    console.log(err);
                });
            }
        },

    },
    mounted: function () {
        this.init();
        $('#add').on('hide.bs.modal',
            function () {
                qygl.bm = {
                    id: '',
                    fjqx: '',
                    name: ''
                };
                //表单验证初始化
                $("#addform").data("bootstrapValidator").resetForm();
                //多选下拉框初始化
                $('.selectpicker').selectpicker('val', []);
            }
        );
    }
});
/**
 * 下拉多选框初始化
 */
$(function () {
    $(".selectpicker").selectpicker({
        noneSelectedText: '请选择'//默认显示内容
    });
    var select = $("#fjqx");
    Global.Fun.ajaxGet("/mkgl/findMk", function (data) {
        for (var i = 0; i < data.length; i++) {
            select.append("<option value=" + data[i].id + ">" + data[i].name + "</option>");
        }
    });
    $(window).on('load', function () {
        $('.selectpicker').selectpicker('refresh');
    });
});
/**
 * 加载表单验证配置
 */
$(document).ready(function () {
    $("#addform").bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            addname: {
                message: '部门名错误',
                validators: {
                    notEmpty: {
                        message: '部门名不能为空'
                    }
                }
            }

        }
    });
})

