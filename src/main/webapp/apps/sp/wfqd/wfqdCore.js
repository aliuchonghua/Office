var wfqd = new Vue({
	el: '#wfqdapp',
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
			if (wfqd===undefined){
				axios.post('/sp/spgl/findMyWFQ',{type:'待审批'}).then(function(result) {
					wfqd.splist = result.data;
				}).catch(function(err) {
					console.log(err);
				});
			}else {
				axios.post('/sp/spgl/findMyWFQ',wfqd.spzt).then(function(result) {
					wfqd.splist = result.data;
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
				$("#cancel").show();
			}else {
				$("#cancel").hide();
			}
			wfqd.sp = item;
		},
		format: function(cjsj) {
			return Global.Fun.Format(cjsj, 'yyyy-MM-dd HH:mm:ss');
		},
		cancel:function () {
			axios.post('/sp/spgl/cancel', wfqd.sp).then(function (result) {
				$('#xqform').modal('hide');
				wfqd.msg.mess = result.data.mess;
				$('#msg').modal('show');
				wfqd.init();
			}).catch(function (err) {
				console.log(err);
			});
		}
	},
	mounted: function() {
		this.init();
		$('#xqform').on('hide.bs.modal',
			function() {
				wfqd.sp = {};
				wfqd.init();
			}
		);

	}
});
	
