var wdck = new Vue({
    el: '#wdckapp',
    data: {
		gglist:[],
		gg:{}
    },
    methods: {
        init: function () {
            axios.get('/gg/gggl/findWdList').then(function (result) {
                wdck.gglist = result.data;
            }).catch(function (err) {
                console.log(err);
            });
        },
        //简介
        summary:function(nr){
            if (nr.length>15){
                return nr.substr(0,15)+"...";
            }else {
                return nr;
            }
        },
        //详情
        detail:function(item){
			$('#ggform').modal('show');
			wdck.gg=item;
        },
        //已读
        haveRead:function(){
			axios.post('/gg/gggl/haveRead',wdck.gg).then(function (result) {
			    $('#ggform').modal('hide');
				wdck.gg={};
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
				wdck.gg={};
                wdck.init();
            }
        );
    }
});


