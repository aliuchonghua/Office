var grxx = new Vue({
    el: '#grxxapp',
    data: {
        user: {
            sjh: '',
            name: '',
            csny: '',
            xb: '',
            zhlx_name: '',
            dq: '',
            qy_name: '',
            bm_name: ''
        }
    },
    methods: {
        init: function () {
            axios.get('/grzx/grxx/find').then(function (result) {
                grxx.user = result.data;
                grxx.user.csny = Global.Fun.Format(result.data.csny, "yyyy-MM-dd");
            }).catch(function (err) {
                console.log(err);
            });
        },
    },
    mounted: function () {
        this.init();
    }
});



