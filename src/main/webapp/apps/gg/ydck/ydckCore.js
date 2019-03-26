var ydck = new Vue({
    el: '#ydckapp',
    data: {
		gglist:[],
		gg:{}
    },
    methods: {
        init: function () {
            axios.get('/gg/gggl/findYdList').then(function (result) {
                ydck.gglist = result.data;
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
			ydck.gg=item;
        },
        format:function (cjsj) {
            return Global.Fun.Format(cjsj,'yyyy-MM-dd HH:mm:ss');
        }

    },
    mounted: function () {
        this.init();
        $('#ggform').on('hide.bs.modal',
            function () {
				ydck.gg={};
                ydck.init();
            }
        );
    }
});


