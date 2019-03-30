var wdrw = new Vue({
    el: '#wdrwapp',
    data: {
        rwlist: [],
        rw: {},
        rwzt: {
            type: ''
        },
        msg: {
            mess: ''
        }
    },
    methods: {
        init: function () {
            if (wdrw === undefined) {
                axios.post('/rw/rwgl/findMyRw', {type: ''}).then(function (result) {
                    wdrw.rwlist = result.data;
                }).catch(function (err) {
                    console.log(err);
                });
            } else {
                axios.post('/rw/rwgl/findMyRw', wdrw.rwzt).then(function (result) {
                    wdrw.rwlist = result.data;
                }).catch(function (err) {
                    console.log(err);
                });
            }
        },
        summary: function (nr) {
            if (nr.length > 10) {
                return nr.substr(0, 10) + "...";
            } else {
                return nr;
            }
        },
        //详情
        detail: function (item) {
            if (item.type==='未开始') {
                $('#processing').show();
                $('#completed').hide();
            }else if (item.type==='进行中') {
                $('#processing').hide();
                $('#completed').show();
            }else {
                $('#processing').hide();
                $('#completed').hide();
            }
            $('#xqform').modal('show');
            wdrw.rw = item;
        },
        format: function (cjsj) {
            if (cjsj!=null&&cjsj!==''){
                return Global.Fun.Format(cjsj, 'yyyy-MM-dd HH:mm:ss');
            } else {
                return '--'
            }
        },
        //过期状态
        expiredStatus: function (time) {
            console.log(time);
            console.log("time");
            console.log(new Date());
            return time;
        },
        //已完成
        completed: function () {
            axios.post('/rw/rwgl/fulfill', wdrw.rw).then(function (result) {
                $('#xqform').modal('hide');
                wdrw.msg.mess = result.data.mess;
                $('#msg').modal('show');
                wdrw.init();
            }).catch(function (err) {
                console.log(err);
            });
        },
        //进行中
        processing: function () {
            axios.post('/rw/rwgl/hasNotStarted', wdrw.rw).then(function (result) {
                $('#xqform').modal('hide');
                wdrw.msg.mess = result.data.mess;
                $('#msg').modal('show');
                wdrw.init();
            }).catch(function (err) {
                console.log(err);
            });
        }

    },
    mounted: function () {
        this.init();
        $('#xqform').on('hide.bs.modal',
            function () {
                wdrw.rw = {};
                wdrw.init();
            }
        );

    }
});
	
