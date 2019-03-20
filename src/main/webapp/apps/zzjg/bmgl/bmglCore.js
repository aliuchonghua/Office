var bmgl = new Vue({
    el: '#bmglapp',
    data: {
        bmlist: [],
        bm: {
            id: '',
            name: ''
        },
        addbm: {
            name: ''
        },
        modifybm: {
            id: '',
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
        add: function () {
            var addform = $("#addform").data('bootstrapValidator');
            addform.validate();
            if (addform.isValid()) {
                axios.post('/zzjg/bmgl/add', bmgl.addbm).then(function (result) {
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
            bmgl.modifybm=bm
        },
        modifySubmit:function(){
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
                bmgl.addbm = {
                    name: ''
                };
                $("#addform").data("bootstrapValidator").resetForm();
            }
        );
        $('#modify').on('hide.bs.modal',
            function () {
                bmgl.modifybm = {
                    id: '',
                    name: ''
                }
                $("#modifyform").data("bootstrapValidator").resetForm();

            }
        );

    }
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
