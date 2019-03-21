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
            var split = module.zhlx.split(',');
            for (var i = 0; i < split.length; i++) {
                if (split[i]==='0') {
                    mkgl.zhlx.gly = true;
                }
                if (split[i]==='1') {
                    mkgl.zhlx.ld = true;
                }
                if (split[i]==='2') {
                    mkgl.zhlx.fzr = true;
                }
                if (split[i]==='3') {
                    mkgl.zhlx.yg = true;
                }
            }
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
            if (mkgl.zhlx.gly === true) {
                zhlxstr += '0,';
            }
            if (mkgl.zhlx.ld === true) {
                zhlxstr += '1,';
            }
            if (mkgl.zhlx.fzr === true) {
                zhlxstr += '2,';
            }
            if (mkgl.zhlx.yg === true) {
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
