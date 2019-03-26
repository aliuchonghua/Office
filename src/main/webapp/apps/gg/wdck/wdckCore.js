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
            return nr.substr(0,25)+"...";
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


