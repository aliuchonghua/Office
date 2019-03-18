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
        dataModal: '',
        gglist:[],
        splist:[],
        rwlist:[],
        zzjglist:[],
        grzxlist:[]

    },
    methods: {
        /**
         * 初始化
         */
        init: function () {
            axios.get('/dataindex/finduser').then(function (result) {
                if (result.data.user != null) {
                    dataIndex.user = result.data.user;
                    Global.user = result.data.user;
                    if (Global.user.zhlx==0){
                        $("#modgl").show();
                    }
                    dataIndex.kztinit();
                }
            }).catch(function (err) {
                console.log(err);
            });
        },
        /**
         * 控制台初始化
         */
        kztinit: function () {
            $("#datacontent").load("workbench/workbench.html");
            $.getScript("workbench/workCore.js");
        },
        /**
         * 加载模块管理模块
         */
        mkgl: function () {
            $("#datacontent").load("mkgl/mkgl.html");
            $.getScript("mkgl/mkglCore.js");
        },
        /**
         * 获取当前用户全部的模块
         */
        loadModel:function () {
            axios.get('/dataindex/loadModel').then(function (result) {
				for (var i = 0; i < result.data.length; i++) {
					if(result.data[i].mdlx=='公告'){
                        dataIndex.gglist.push(result.data[i]);
					}
					if(result.data[i].mdlx=='审批'){
                        dataIndex.splist.push(result.data[i]);
					}
					if(result.data[i].mdlx=='任务'){
                        dataIndex.rwlist.push(result.data[i]);
					}
					if(result.data[i].mdlx=='组织架构'){
                        dataIndex.zzjglist.push(result.data[i]);
					}
					if(result.data[i].mdlx=='个人中心'){
                        dataIndex.grzxlist.push(result.data[i]);
					}
				}
				if(dataIndex.gglist.length==0){
					$("#gg").hide();
				}
				if(dataIndex.splist.length==0){
					$("#sp").hide();
				}
				if(dataIndex.rwlist.length==0){
					$("#rw").hide();
				}
				if(dataIndex.zzjglist.length==0){
					$("#zzjg").hide();
				}
				if(dataIndex.grzxlist.length==0){
					$("#grzx").hide();
				}
            }).catch(function (err) {
                console.log(err);
            });
        },
        /**
         * 加载模块
         * @param item 模块对象
         */
		loadapp:function(item){
            $("#datacontent").load(item.link+item.code+".html");
            $.getScript(item.link+item.code+"Core.js");
		}
    },
    mounted: function () {
        this.init();
        this.loadModel();
    }
});