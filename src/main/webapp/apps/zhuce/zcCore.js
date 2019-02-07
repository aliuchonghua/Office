var vue = new Vue({
	el: '#zc',
	data: {
		pass2: '',
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
		user: {
			sjh: '', // 手机号
			pass: '', //密码
			pass2: '' //密码
		},
		mess: {
			sjh: '',
			pass: '',
			pass2: '',
			name: '',
			hymc: '',
			clrq: '',
			zczj: '',
			xxdz: '',
			jyfw: ''
		},
		city: {
			sheng: '',
			shi: '',
			xian: ''
		},
		msg:{
			qiye: {},
			user: {}
		},
		sheng: [],
		shi: [],
		xian: [],
		i: false,
		Modal:''
	},
	methods: {
		back: function() {
			$("#app").show();
			$("#app2").hide();
			$("#app2").html('');
		},
		//获取省份
		getsheng: function() {
			axios.get('/city/sheng').then(function(value) {
				vue.city.sheng = value.data[0].cityname;
				for (var i = 0; i < value.data.length; i++) {
					vue.sheng.push(value.data[i]);
				}
				vue.getshi(value.data[0]);
			}).catch(function(reason) {
				console.log(reason);
			});
		},
		//获取城市
		getshi: function(item) {
			vue.shi = [];
			vue.xian = [];
			axios.post('/city/shi', item).then(function(value) {
				vue.city.shi = value.data[0].cityname;
				for (var i = 0; i < value.data.length; i++) {
					vue.shi.push(value.data[i]);
				}
				vue.getxian(value.data[0]);
			}).catch(function(reason) {
				console.log(reason);
			});
		},
		//获取县
		getxian: function(item) {
			vue.xian = [];
			axios.post('/city/xian', item).then(function(value) {
				vue.city.xian = value.data[0].cityname;
				for (var i = 0; i < value.data.length; i++) {
					vue.xian.push(value.data[i]);
				}
			}).catch(function(reason) {
				console.log(reason);
			});
		},
		//注册
		registered: function() {
			//验证
			vue.i = true;
			vue.yzsjh();
			vue.yzpass();
			vue.yzpass2();
			vue.yzname();
			vue.yzhymc();
			vue.yzzczj();
			vue.yzxxdz();
			vue.yzjyfw();
			vue.yzclrq();
			//拼接省市县
			vue.qiye.dq=vue.city.sheng+vue.city.shi+vue.city.xian;
			if (vue.i) {
				vue.msg.qiye=vue.qiye;
				vue.msg.user=vue.user;
				axios.post('/registered/CreateQiye', vue.msg).then(function(value) {
					vue.Modal=value.data.mess
					// 启动模态框
					$('#zcModal').modal('show');
				}).catch(function(reason) {
					console.log(reason);
				});
			} else {
				vue.Modal='填写有误请检查';
				$('#zcModal').modal('show');
				// 模态框
			}
		},
		//验证管理员账户
		yzsjh: function() {
			if (vue.user.sjh == '') {
				vue.mess.sjh = '账户不能为空';
				$("[name='sjh']").parent().addClass('has-error');
				vue.i = false;
			} else if (vue.user.sjh.length > 11 || vue.user.sjh.length < 6) {
				vue.mess.sjh = '账户需要为6到11位';
				$("[name='sjh']").parent().addClass('has-error');
				vue.i = false;
			} else {
				$("[name='sjh']").parent().removeClass('has-error');
				$("[name='sjh']").parent().addClass('has-success');
				vue.mess.sjh = '';
				axios.post('/registered/yzsjhPresence', vue.user).then(function(value) {
					if (value.data.mess == '1') {
						vue.mess.sjh = '账户已存在';
						$("[name='sjh']").parent().addClass('has-error');
						vue.i = false;
					} else {
						$("[name='sjh']").parent().removeClass('has-error');
						$("[name='sjh']").parent().addClass('has-success');
						vue.mess.sjh = '';
					}
				}).catch(function(reason) {
					console.log(reason);
				});
			}
		},
		//验证密码
		yzpass: function() {
			if (vue.user.pass == '') {
				vue.mess.pass = '密码不能为空';
				$("[name='pass']").parent().addClass('has-error');
				vue.i = false;
			} else if (vue.user.pass.length > 11 || vue.user.pass.length < 6) {
				vue.mess.pass = '密码需要为6到11位';
				$("[name='pass']").parent().addClass('has-error');
				vue.i = false;
			} else {
				$("[name='pass']").parent().removeClass('has-error');
				$("[name='pass']").parent().addClass('has-success');
				vue.mess.pass = '';
			}
		},
		//验证密码
		yzpass2: function() {
			if (vue.user.pass2 == '') {
				vue.mess.pass2 = '密码不能为空';
				$("[name='pass2']").parent().addClass('has-error');
				vue.i = false;
			} else if (vue.user.pass != vue.user.pass2) {
				vue.mess.pass2 = '两次密码不一致';
				$("[name='pass2']").parent().addClass('has-error');
				vue.i = false;
			} else {
				$("[name='pass2']").parent().removeClass('has-error');
				$("[name='pass2']").parent().addClass('has-success');
				vue.mess.pass2 = '';
			}
		},
		yzname: function() {
			if (vue.qiye.name == '') {
				vue.mess.name = '企业名称不能为空';
				$("[name='name']").parent().addClass('has-error');
				vue.i = false;
			} else {
				$("[name='name']").parent().removeClass('has-error');
				$("[name='name']").parent().addClass('has-success');
				vue.mess.name = '';
			}
		},
		yzhymc: function() {
			if (vue.qiye.hymc == '') {
				vue.mess.hymc = '行业名称不能为空';
				$("[name='hymc']").parent().addClass('has-error');
				vue.i = false;
			} else {
				$("[name='hymc']").parent().removeClass('has-error');
				$("[name='hymc']").parent().addClass('has-success');
				vue.mess.hymc = '';
			}
		},
		yzzczj: function() {
			if (vue.qiye.zczj == '') {
				vue.mess.zczj = '注册资金不能为空';
				$("[name='zczj']").parent().addClass('has-error');
				vue.i = false;
			} else {
				$("[name='zczj']").parent().removeClass('has-error');
				$("[name='zczj']").parent().addClass('has-success');
				vue.mess.zczj = '';
			}
		},
		yzxxdz: function() {
			if (vue.qiye.xxdz == '') {
				vue.mess.xxdz = '详细地址不能为空';
				$("[name='xxdz']").parent().addClass('has-error');
				vue.i = false;
			} else {
				$("[name='xxdz']").parent().removeClass('has-error');
				$("[name='xxdz']").parent().addClass('has-success');
				vue.mess.xxdz = '';
			}
		},
		yzjyfw: function() {
			if (vue.qiye.jyfw == '') {
				vue.mess.jyfw = '经营范围不能为空';
				$("[name='jyfw']").parent().addClass('has-error');
				vue.i = false;
			} else {
				$("[name='jyfw']").parent().removeClass('has-error');
				$("[name='jyfw']").parent().addClass('has-success');
				vue.mess.jyfw = '';
			}
		},
		yzclrq: function() {
			vue.qiye.clrq = $("#clrq").val();
			if (vue.qiye.clrq == '') {
				vue.mess.clrq = '成立日期不能为空';
				$("[name='clrq']").parent().addClass('has-error');
				vue.i = false;
			} else {
				$("[name='clrq']").parent().removeClass('has-error');
				$("[name='clrq']").parent().addClass('has-success');
				vue.mess.clrq = '';
			}
		}
	},
	mounted: function() {
		//日期弹窗初始化
		laydate.render({
			elem: '#clrq'
		});
		//vue初始化
		this.$nextTick(function() {
			vue.getsheng();
		})
	}
});
