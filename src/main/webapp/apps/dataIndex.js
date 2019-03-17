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
                    Global.user = result.data.user;
                    if (Global.user.zhlx==0){
                        $("#modgl").show();
                    }
                    dataIndex.gztinit();
                }
            }).catch(function (err) {
                console.log(err);
            });
        },
        gztinit: function () {
            $("#datacontent").load("workbench/workbench.html");
            $.getScript("workbench/workCore.js");
        },
        mkgl: function () {
            $("#datacontent").load("mkgl/mkgl.html");
            $.getScript("mkgl/mkglCore.js");
        }
    },
    mounted: function () {
        this.init();
    }
});