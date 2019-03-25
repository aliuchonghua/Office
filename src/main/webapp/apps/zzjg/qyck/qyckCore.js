var qyck = new Vue({
    el: '#qyckapp',
    data: {
        qiye: {
            name: '', // 企业名称
            hymc: '', // 行业名称
            clrq: '', // 成立日期
            dq: '', // 地区
            xxdz: '', // 详细地址
            zczj: '', // 注册资金
            jyfw: '', // 经营范围
            qyjj: '' // 企业简介
        }
    },
    methods: {
        init: function () {
            axios.get('/zzjg/qygl/find').then(function (result) {
                qyck.qiye = result.data;
                qyck.qiye.clrq = Global.Fun.Format(result.data.clrq, "yyyy-MM-dd");
            }).catch(function (err) {
                console.log(err);
            });
        },
    },
    mounted: function () {
        this.init();
    }
});



