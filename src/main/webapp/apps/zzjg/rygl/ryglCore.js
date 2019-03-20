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
			xb: '',
			zhlx: '',
			zhlx_name: '',
			dq: '',
			qy_id: '',
			qy_name: '',
			bm_id: '',
			bm_name: '',
			pass: ''
		},
		msg: {
			mess: ''
		}
	},
	methods: {
		init: function() {
            global.Fun.ssxView($("#dq"));
			/*axios.get('/zzjg/bmgl/findlist').then(function (result) {
			    bmgl.bmlist = result.data;
			}).catch(function (err) {
			    console.log(err);
			});*/
		},
        addOpen:function(){
            $('#ryglform').modal('show');
            rygl.formTitle='新增';
        },
		modifyOpen: function(item) {
            $('#ryglform').modal('show');
            rygl.formTitle='修改';
            rygl.user=item;
		},
		submit: function() {
			var modifyform= $("#userform").data('bootstrapValidator');
			modifyform.validate();
			if (modifyform.isValid()) {
			    /*axios.post('/zzjg/bmgl/modify', bmgl.modifybm).then(function (result) {
			        bmgl.msg.mess = result.data.mess;
			        $('#modify').modal('hide');
			        $('#msg').modal('show');
			        bmgl.init();
			    }).catch(function (err) {
			        console.log(err);
			    });*/
			    console.log("通过");
			}
		},
		remove: function(bm) {
			/*axios.post('/zzjg/bmgl/remove', bm).then(function (result) {
			    bmgl.msg.mess = result.data.mess;
			    $('#msg').modal('show');
			    bmgl.init();
			}).catch(function (err) {
			    console.log(err);
			});*/
		},

	},
	mounted: function() {
		this.init();
		$('#ryglform').on('hide.bs.modal',
			function() {
				rygl.user = {
					id: '',
					sjh: '',
					name: '',
					csny: '',
					xb: '',
					zhlx: '',
					zhlx_name: '',
					dq: '',
					qy_id: '',
					qy_name: '',
					bm_id: '',
					bm_name: '',
					pass: ''
				};
                $("#userform").data("bootstrapValidator").resetForm();
			}
		);
		laydate.render({
			elem: '#csny',
            done:function (value) {
                rygl.user.csny=value;
            }
		});
	}
});
//表单验证
$(document).ready(function() {
	$("#userform").bootstrapValidator({
		message: 'This value is not valid',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			name: {
				message: '名称错误',
				validators: {
					notEmpty: {
						message: '名称不能为空'
					}
				}
			}
		}
	});
})
