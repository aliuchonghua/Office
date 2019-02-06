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
			pass: '' //密码
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
		sheng: [],
		shi: [],
		xian: []
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
				vue.city.sheng = value.data[0];
				for (var i = 0; i < value.data.length; i++) {
					vue.sheng.push(value.data[i]);
				}
				vue.getshi();
			}).catch(function(reason) {
				console.log(reason);
			});
		},
		//获取城市
		getshi: function() {
			vue.shi = [];
			vue.xian=[];
			axios.post('/city/shi', vue.city).then(function(value) {
				vue.city.shi = value.data[0];
				for (var i = 0; i < value.data.length; i++) {
					vue.shi.push(value.data[i]);
				}
				vue.getxian();
			}).catch(function(reason) {
				console.log(reason);
			});
		},
		//获取县
		getxian: function() {
			vue.xian = [];
			axios.post('/city/xian', vue.city).then(function(value) {
				vue.city.xian = value.data[0];
				for (var i = 0; i < value.data.length; i++) {
					vue.xian.push(value.data[i]);
				}
			}).catch(function(reason) {
				console.log(reason);
			});
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
