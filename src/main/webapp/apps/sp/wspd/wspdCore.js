var wspd = new Vue({
	el: '#wspdapp',
	data: {
		splist: [],
		sp: {},
		spzt:{
			type:'待审批'
		},
		msg: {
			mess: ''
		}
	},
	methods: {
		init: function() {
			if (wspd===undefined){
				axios.post('/sp/spgl/findMyWsp',{type:'待审批'}).then(function(result) {
					wspd.splist = result.data;
				}).catch(function(err) {
					console.log(err);
				});
			}else {
				axios.post('/sp/spgl/findMyWsp',wspd.spzt).then(function(result) {
					wspd.splist = result.data;
				}).catch(function(err) {
					console.log(err);
				});
			}
		},
		summary:function(nr){
			if (nr.length>10){
				return nr.substr(0,10)+"...";
			}else {
				return nr;
			}
		},
		//详情
		detail: function(item) {
			$('#xqform').modal('show');
			if (item.splx==='出差') {
				$(".chuchai").show();
			}else {
				$(".chuchai").hide();
			}
			if (item.type==='待审批') {
				$("#approve").show();
				$("#refuse").show();
			}else {
				$("#approve").hide();
				$("#refuse").hide();
			}
			wspd.sp = item;
		},
		format: function(cjsj) {
			return Global.Fun.Format(cjsj, 'yyyy-MM-dd HH:mm:ss');
		},
		//批准
		approve:function(){
			axios.post('/sp/spgl/approve', wspd.sp).then(function (result) {
				$('#xqform').modal('hide');
				wspd.msg.mess = result.data.mess;
				$('#msg').modal('show');
				wspd.init();
			}).catch(function (err) {
				console.log(err);
			});
		},
		//拒绝
		refuse:function(){
			axios.post('/sp/spgl/refuse', wspd.sp).then(function (result) {
				$('#xqform').modal('hide');
				wspd.msg.mess = result.data.mess;
				$('#msg').modal('show');
				wspd.init();
			}).catch(function (err) {
				console.log(err);
			});
		}
	},
	mounted: function() {
		this.init();
		$('#xqform').on('hide.bs.modal',
			function() {
				wspd.sp = {};
				wspd.init();
			}
		);

	}
});
	
