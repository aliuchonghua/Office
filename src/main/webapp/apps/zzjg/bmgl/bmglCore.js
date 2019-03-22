var bmgl = new Vue({
    el: '#bmglapp',
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
            axios.get('/zzjg/bmgl/findlist').then(function (result) {
                bmgl.bmlist = result.data;
            }).catch(function (err) {
                console.log(err);
            });

        },
        addopen: function () {
            bmgl.formTitle = '新增';
            $("#qxfrom").show();
            $('#add').modal('show');
        },
        modifyopen: function (bm) {
            if (bm.id === '') {
                $("#qxfrom").hide();
            } else {
                $("#qxfrom").show();
            }
            bmgl.formTitle = '编辑';
            bmgl.bm = bm;
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
                    bmgl.bm.fjqx='';
                    for (var i = 0; i < qx.length; i++) {
                        bmgl.bm.fjqx += qx[i];
                        bmgl.bm.fjqx += ',';
                    }
                    bmgl.bm.fjqx = bmgl.bm.fjqx.substr(0, bmgl.bm.fjqx.length - 1);
                }
                if (bmgl.bm.id===''){//新增
                    axios.post('/zzjg/bmgl/add', bmgl.bm).then(function (result) {
                        bmgl.msg.mess = result.data.mess;
                        $('#add').modal('hide');
                        $('#msg').modal('show');
                        bmgl.init();
                    }).catch(function (err) {
                        console.log(err);
                    });
                }else {//编辑
                    axios.post('/zzjg/bmgl/modify', bmgl.bm).then(function (result) {
                        bmgl.msg.mess = result.data.mess;
                        $('#add').modal('hide');
                        $('#msg').modal('show');
                        bmgl.init();
                    }).catch(function (err) {
                        console.log(err);
                    });
                }
            }
        },
        remove: function (bm) {
            if(bm.rs!=='0'){
                bmgl.msg.mess='无法删除,还存在绑定的员工';
                $('#msg').modal('show');
            }else {
                axios.post('/zzjg/bmgl/remove', bm).then(function (result) {
                    bmgl.msg.mess = result.data.mess;
                    $('#msg').modal('show');
                    bmgl.init();
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
                bmgl.bm = {
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

