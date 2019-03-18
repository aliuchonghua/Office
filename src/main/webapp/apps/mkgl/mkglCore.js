var mkgl = new Vue({
    el: '#mkglapp',
    data: {
        modulelist: [],
        module: {
            id: '',
            name: '',
            code: '',
            link: '',
            zhlx: '',
            mdlx: '公告'
        },
        addmodule: {
            id: '',
            name: '',
            code: '',
            link: '',
            zhlx: '',
            mdlx: '',
            qy_id: ''
        },
        zhlx: {
            gly: '',
            ld: '',
            fzr: '',
            yg: ''
        },
        msg: ''
    },
    methods: {
        init: function () {
            axios.post('/mkgl/findlist', this.module).then(function (result) {
                mkgl.modulelist = result.data;
            }).catch(function (err) {
                console.log(err);
            });
        },
        updatemodule: function (module) {
            $('#addModal').modal('show');
            this.addmodule = module;
        },
        remove: function (module) {
            axios.post('/mkgl/remove', module).then(function (result) {
                mkgl.msg = result.data.mess;
                $('#msgModal').modal('show');
                mkgl.init();
            }).catch(function (err) {
                console.log(err);
            });
        },
        add: function () {
            var zhlxstr = "";
            if (this.zhlx.gly == true) {
                zhlxstr += '0,';
            }
            if (this.zhlx.ld == true) {
                zhlxstr += '1,';
            }
            if (this.zhlx.fzr == true) {
                zhlxstr += '2,';
            }
            if (this.zhlx.yg == true) {
                zhlxstr += '3,';
            }
            zhlxstr = zhlxstr.substr(0, zhlxstr.length - 1);
            this.addmodule.zhlx = zhlxstr;
            axios.post('/mkgl/add', this.addmodule).then(function (result) {
                mkgl.msg = result.data.mess;
                $('#msgModal').modal('show');
                mkgl.init();
            }).catch(function (err) {
                console.log(err);
            });
            $('#addModal').modal('hide')
        }
    },
    mounted: function () {
        this.init();
        $('#addModal').on('hide.bs.modal',
            function () {
                mkgl.addmodule = {
                    id: '',
                    name: '',
                    code: '',
                    link: '',
                    zhlx: '',
                    mdlx: ''
                };
                mkgl.zhlx = {
                    gly: '',
                    ld: '',
                    fzr: '',
                    yg: ''
                }
            });
    }
});
