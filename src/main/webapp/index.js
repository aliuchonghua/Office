//创建vue对象
var vue = new Vue({
	el: '#app',
	data: {
		msg: '',
		student: {
			stuid: '',
			pass: ''
		},
		yzm:''
	},
	methods: {
		login: function() {
			if (vue.student.stuid == '') {
				vue.msg = '手机号不能为空';
				$("#rem").show();
				vue.yzm='';
			} else if (vue.student.pass == '') {
				vue.msg = '密码不能为空';
				$("#rem").show();
				vue.yzm='';
			} else if(vue.yzm!='1'){
				vue.msg = '请滑动验证';
				$("#rem").show();
			}else  {
				axios.post('/login/stulogin', this.student).then(function(result) {
					if (result.data.msg.indexOf("登陆成功") != -1) {
						$("#rem").hide();
						$('#myModal').modal('show');//触发模态框
						window.location.href = result.data.html;
					}else{
						$("#rem").show();
						vue.msg=result.data.msg;
					}
				}).catch(function(err) {
					console.log(err);
					vue.msg = '服务器错误';
					$("#rem").show();
				});
			}
		},
		back: function() {
			vue.msg = "";
			$("#rem").hide();
		},

	},
	mounted: function() {
		$("#rem").hide();
		switch (Math.floor(Math.random() * 3)) {
			case 0:
				// $("#logobg").load("http://localhost:9090/manager_page.html");
				$("#logobg").html("<img class='image2' src='img/indexbg01.png'>");
				break;
			case 1:
				$("#logobg").html("<img class='image2' src='img/indexbg02.png'>");
				break;
			case 2:
				$("#logobg").html("<img class='image2' src='img/indexbg03.png'>");
				break;
		}
		$('#mpanel1').slideVerify({
			type: 1, //类型
			vOffset: 5, //误差量，根据需求自行调整
			barSize: {
				width: '100%',
				height: '34px',
			},
			ready: function() {},
			success: function() {
				vue.yzm='1';
				$("#rem").hide();
			},
			error: function() {
				vue.yzm='';
			}
		});
	}
});
