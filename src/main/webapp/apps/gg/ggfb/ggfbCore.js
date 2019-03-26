var ggfb = new Vue({
	el: '#ggfbapp',
	data: {
		gg: {
			bt: '',
			nr: ''
		},
		msg: {
			mess: ''
		}
	},
	methods: {
		add: function() {
			var addform = $("#add").data('bootstrapValidator');
			addform.validate();
			if (addform.isValid()) {
				axios.post('/gg/gggl/add', ggfb.gg).then(function(result) {
					ggfb.msg.mess = result.data.mess;
					$('#msg').modal('show');
				}).catch(function(err) {
					console.log(err);
				});
			}
		}

	},
	mounted: function() {
		$('#msg').on('hide.bs.modal',
			function() {
				ggfb.gg = {
					bt: '',
					nr: ''
				};
				$("#add").data("bootstrapValidator").resetForm();
			}
		);


	}
});
$(document).ready(function() {
	$("#add").bootstrapValidator({
		message: 'This value is not valid',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			bt: {
				message: '标题错误',
				validators: {
					notEmpty: {
						message: '标题不能为空'
					}
				}
			},
			nr: {
				message: '内容错误',
				validators: {
					notEmpty: {
						message: '内容不能为空'
					},
					stringLength: {
						max: 2000,
						message: '字数不能大于2000'
					}
				}
			}
		}
	});
});
