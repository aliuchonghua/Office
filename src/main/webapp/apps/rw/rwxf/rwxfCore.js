var rwxf = new Vue({
	el: '#rwxfapp',
	data: {
		rw: {
			name: '',
			ms: '',
			zx_id: '',
			zx_name: '',
			start_time: '',
			expected_time: '',
			yxj: '',
		},
		zxrlist: [],
		msg: {
			mess: ''
		}
	},
	methods: {
		add: function() {
			var addform = $("#add").data('bootstrapValidator');
			addform.validate();
			if (addform.isValid()) {
				rwxf.rw.start_time=Global.Fun.formatDate(rwxf.rw.start_time);
				rwxf.rw.expected_time=Global.Fun.formatDate(rwxf.rw.expected_time);
				axios.post('/rw/rwgl/add', rwxf.rw).then(function(result) {
					rwxf.msg.mess = result.data.mess;
					$('#msg').modal('show');
				}).catch(function(err) {
					console.log(err);
				});
			}
		},
		setzxr: function(user) {
			rwxf.rw.zx_id = user.id;
			rwxf.rw.zx_name = user.name;
		},
		findzxr: function() {
			axios.get('/rw/rwgl/findXs').then(function(result) {
				rwxf.zxrlist = result.data;
				rwxf.rw.zx_id = result.data[0].id;
				rwxf.rw.zx_name = result.data[0].name;
			}).catch(function(err) {
				console.log(err);
			});
		}
	},
	mounted: function() {
		this.findzxr();
		laydate.render({
			elem: '#start_time',
			type: 'datetime',
			done: function(value) {
				rwxf.rw.start_time = value;
			}
		});
		laydate.render({
			elem: '#expected_time',
			type: 'datetime',
			done: function(value) {
				rwxf.rw.expected_time = value;
            }
		});
		$('#msg').on('hide.bs.modal',
			function() {
				rwxf.rw = {
					id: '',
					name: '',
					ms: '',
					u_id: '',
					u_name: '',
					zx_id: '',
					zx_name: '',
					start_time: '',
					end_time: '',
					expected_time: '',
					type: '',
					yxj: '',
					qy_id: '',
					bm_id: ''
				};
				$("#start_time").val('');
				$("#expected_time").val('');
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
			yxj: {
				message: '内容错误',
				validators: {
					notEmpty: {
						message: '优先级不能为空'
					}
				}
			},
			name: {
				message: '内容错误',
				validators: {
					notEmpty: {
						message: '标题不能为空'
					}
				}
			},
			zxr: {
				message: '内容错误',
				validators: {
					notEmpty: {
						message: '执行人员不能为空'
					}
				}
			},
			ms: {
				message: '内容错误',
				validators: {
					notEmpty: {
						message: '描述不能为空'
                    ,
                    stringLength: {
                        max: 2000,
                        message: '描述内容字数不能大于2000'
                    }
					}
				}
			},
            start_time: {
                message: '内容错误',
                validators: {
                    notEmpty: {
                        message: '开始时间不能为空'
                    }
                }
            },
            expected_time: {
                message: '内容错误',
                validators: {
                    notEmpty: {
                        message: '结束时间不能为空'
                    }
                }
            }
		}
	});
});
