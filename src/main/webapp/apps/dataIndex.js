var dataIndex = new Vue({
    el: '#app',
    data: {
        user: {
            id: '',
            sjh: '',
            name: '',
            csny: '',
            xb: '',
            zhlx: '',
            dq: '',
            qy_id: '',
            qy_name: '',
            bm_id: '',
            bm_name: '',
            pass: ''
        },
        msg: {
            user: {}
        }
    },
    methods: {
        init: function () {
            axios.get('/dataindex/finduser').then(function (result) {
                dataIndex.user=result.data.user;
            }).catch(function (err) {
                console.log(err);
            });
        }
    },
    mounted: function () {
        this.init();
    }
});