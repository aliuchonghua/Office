//创建vue对象
var vue = new Vue({
	el: '#app',
	data: {
		yzxx: '',
		user:{
			sjh:'',
			pass:''
		},
		msg:{
			user:'',
			mess:''
		},
		yzm: ''
	},
	methods: {
		login: function() {
			if (vue.user.sjh == '') {
				vue.yzxx = '手机号不能为空';
				$("#rem").show();
				vue.yzm = '';
			} else if (vue.user.pass == '') {
				vue.yzxx = '密码不能为空';
				$("#rem").show();
				vue.yzm = '';
			} else if (vue.yzm != '1') {
				vue.yzxx = '请滑动验证';
				$("#rem").show();
			} else {
				vue.msg.user=vue.user;
				$('#myModal').modal('show'); //触发模态框
				axios.post('/login/login', vue.msg).then(function(result) {
					if (result.data.type== 1) {
						$("#rem").hide();
						window.location.href = '/apps/dataIndex.html';
					} else {
						$("#rem").show();
						vue.yzxx = result.data.mess;
					}
				}).catch(function(err) {
					console.log(err);
					$('#myModal').modal('hide');
					vue.yzxx = '服务器错误';
					$("#rem").show();
				});
			}
		},
		back: function() {
			vue.msg = {
                user:'',
                mess:''
            };
			$("#rem").hide();
		},
		zhuce: function() {
			$("#app").hide();
			$("#app2").show();
			$("#app2").load("apps/zhuce/zcView.html");
			$.getScript("apps/zhuce/zcCore.js");
		}

	},
	mounted: function() {
		var i = 1;
		$("#rem").hide();
		// 初始化轮播图
		$("#myCarousel").carousel('cycle');
		//验证码
		$('#mpanel1').slideVerify({
			type: 1, //类型
			vOffset: 5, //误差量，根据需求自行调整
			barSize: {
				width: '100%',
				height: '34px',
			},
			ready: function() {},
			success: function() {
				vue.yzm = '1';
				$("#rem").hide();
			},
			error: function() {
				vue.yzm = '';
			}
		});
	}
});
