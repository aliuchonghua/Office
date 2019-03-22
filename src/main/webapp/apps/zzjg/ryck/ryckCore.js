var ryck = new Vue({
    el: '#ryckapp',
    data: {
        formTitle: '',
        userlist: [],
        bmlist: [],
        bm: {
            id: '',
            name: ''
        }
    },
    methods: {
        init: function () {
            axios.post('/zzjg/rygl/findlist', ryck.bm).then(function (result) {
                ryck.userlist = result.data;
            }).catch(function (err) {
                console.log(err);
            });
        },
        getbm: function () {
            axios.get('/zzjg/bmgl/findlist').then(function (result) {
                ryck.bmlist = result.data;
                ryck.bm = result.data[0];
                ryck.init();
            }).catch(function (err) {
                console.log(err);
            });
        },
        setbm: function (bm) {
            ryck.bm = bm;
            ryck.init();
        },
    },
    mounted: function () {
        this.getbm();
    }
});


