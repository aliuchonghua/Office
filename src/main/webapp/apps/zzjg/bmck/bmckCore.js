var bmck = new Vue({
    el: '#bmckapp',
    data: {
        bmlist: [],
        bm: {
            id: '',
            name: ''
        }
    },
    methods: {
        init: function () {
            axios.get('/zzjg/bmgl/findlist').then(function (result) {
                bmck.bmlist = result.data;
            }).catch(function (err) {
                console.log(err);
            });
        }
    },
    mounted: function () {
        this.init();
    }
});

