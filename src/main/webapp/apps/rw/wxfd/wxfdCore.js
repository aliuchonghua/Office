var wxfd = new Vue({
    el: '#wxfdapp',
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
            if (wxfd === undefined) {
                axios.post('/rw/rwgl/findWXF', {type: ''}).then(function (result) {
                    wxfd.rwlist = result.data;
                }).catch(function (err) {
                    console.log(err);
                });
            } else {
                axios.post('/rw/rwgl/findWXF', wxfd.rwzt).then(function (result) {
                    wxfd.rwlist = result.data;
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
                $('#cancel').show();
            }else {
                $('#cancel').hide();
            }
            $('#xqform').modal('show');
            wxfd.rw = item;
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
            if(new Date(time)>new Date()){
                return '正常';
            }else {
                return '已过期';
            }
        },
        //撤销
        cancel:function(){
            axios.post('/rw/rwgl/delete', wxfd.rw).then(function (result) {
                $('#xqform').modal('hide');
                wxfd.msg.mess = result.data.mess;
                $('#msg').modal('show');
            }).catch(function (err) {
                console.log(err);
            });
        }
    },
    mounted: function () {
        this.init();
        $('#xqform').on('hide.bs.modal',
            function () {
                wxfd.rw = {};
                wxfd.init();
            }
        );

    }
});
	
