var bmgl = new Vue({
	el: '#bmglapp',
	data: {
		bmlist: [],
		bm: {
			id: '',
			name: ''
		},
		addbm: {
			id: '',
			name: ''
		},
		modifybm: {
			id: '',
			name: ''
		},
		msg: {
			mess: ''
		}
	},
	methods: {
		init: function() {
			axios.get('/zzjg/bmgl/bmgl').then(function (result) {
			    bmgl.bmlist = result.data;
			}).catch(function (err) {
			    console.log(err);
			});
			
		},
		add: function() {

		},
		modify: function(bm) {

		},
		remove: function(bm) {

		},

	},
	mounted: function() {
		this.init();
		$('#add').on('hide.bs.modal',
			function() {
				bmgl.addbm = {
					id: '',
					name: ''
				}
			}
		);
		$('#modify').on('hide.bs.modal',
			function() {
				bmgl.addbm = {
					id: '',
					name: ''
				}
			}
		);
	}
});
