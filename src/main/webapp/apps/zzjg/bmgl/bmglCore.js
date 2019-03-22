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
            $('#add').modal('show');
        },
        modifyopen: function () {
            bmgl.formTitle = '编辑';
            $('#add').modal('show');
        },
        add: function () {
            var addform = $("#addform").data('bootstrapValidator');
            addform.validate();
            if (addform.isValid()) {
                var qx = [];
                $("#fjqx:selected").each(function(){
                    qx.push($(this).val());
                });
                for (var i = 0; i <qx.length; i++) {
                    bmgl.bm.fjqx+=qx[i];
                }
                axios.post('/zzjg/bmgl/add', bmgl.bm).then(function (result) {
                    bmgl.msg.mess = result.data.mess;
                    $('#add').modal('hide');
                    $('#msg').modal('show');
                    bmgl.init();
                }).catch(function (err) {
                    console.log(err);
                });
            }
        },
        modify: function (bm) {
            $('#modify').modal('show');
            bmgl.modifybm = bm
        },
        modifySubmit: function () {
            var modifyform = $("#modifyform").data('bootstrapValidator');
            modifyform.validate();
            if (modifyform.isValid()) {
                axios.post('/zzjg/bmgl/modify', bmgl.modifybm).then(function (result) {
                    bmgl.msg.mess = result.data.mess;
                    $('#modify').modal('hide');
                    $('#msg').modal('show');
                    bmgl.init();
                }).catch(function (err) {
                    console.log(err);
                });
            }
        },
        remove: function (bm) {
            axios.post('/zzjg/bmgl/remove', bm).then(function (result) {
                bmgl.msg.mess = result.data.mess;
                $('#msg').modal('show');
                bmgl.init();
            }).catch(function (err) {
                console.log(err);
            });
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
                $("#addform").data("bootstrapValidator").resetForm();
                $('.selectpicker').selectpicker('val', []);
            }
        );
        /*$('#modify').on('hide.bs.modal',
            function () {
                bmgl.modifybm = {
                    id: '',
                    name: ''
                }
                $("#modifyform").data("bootstrapValidator").resetForm();

            }
        );*/

    }
});
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
//表单验证
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
    $("#modifyform").bootstrapValidator({
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

