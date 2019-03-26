var wdgg = new Vue({
    el: '#wdggapp',
    data: {
		gglist:[],
		gg:{},
        msg: {
            mess:''
        }
    },
    methods: {
        init: function () {
            axios.get('/gg/gggl/findZjList').then(function (result) {
                wdgg.gglist = result.data;
            }).catch(function (err) {
                console.log(err);
            });
        },
        //简介
        summary:function(nr){
            if (nr.length>18){
                return nr.substr(0,18)+"...";
            }else {
                return nr;
            }
        },
        //详情
        detail:function(item){
			$('#ggform').modal('show');
			wdgg.gg=item;
        },
        //删除
        remove:function(){
			axios.post('/gg/gggl/delete',wdgg.gg).then(function (result) {
                wdgg.msg.mess = result.data.mess;
                $('#ggform').modal('hide');
                $('#msg').modal('show');
			}).catch(function (err) {
			    console.log(err);
			});
        },
        format:function (cjsj) {
            return Global.Fun.Format(cjsj,'yyyy-MM-dd HH:mm:ss');
        }
    },
    mounted: function () {
        this.init();
        $('#ggform').on('hide.bs.modal',
            function () {
				wdgg.gg={};
                wdgg.init();
            }
        );
    }
});


