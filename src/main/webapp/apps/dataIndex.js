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
        },
        dataModal: ''
    },
    methods: {
        init: function () {
            axios.get('/dataindex/finduser').then(function (result) {
                if (result.data.user != null) {
                    dataIndex.user = result.data.user;
                    Global.user=result.data.user;
                    dataIndex.gztinit();
                }
            }).catch(function (err) {
                console.log(err);
            });
        },
        gztinit: function () {
            $("#datacontent").load("workbench/workbench.html");
            $.getScript("workbench/workCore.js");
        }
    },
    mounted: function () {
        this.init();

    }
});