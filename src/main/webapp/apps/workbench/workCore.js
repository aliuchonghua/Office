
var workbench = new Vue({
	el: '#workbench',
	data: {},
	methods: {
		inituser: function() {
			if (Global.user.zhlx == 0) {
                this.glyrytjech();
                this.glyjxtjech();
			}
		},
		glyrytjech: function() {
			var rytj = echarts.init(document.getElementById('rytj'), 'macarons');
			var option = {
				title: {
					text: '各部门员工统计'
				},
				tooltip: {},
				legend: {
					data: ['人数']
				},
				xAxis: {
					data: function () {
						return ["人事部", "研发部", "实施部", "财务部"];
					}
				},
				yAxis: {},
				series: [{
					name: '人数',
					type: 'bar',
					data: [5, 20, 36, 10]
				}]
			};
			rytj.setOption(option);
			window.addEventListener("resize", function() {
				rytj.resize();
			});
		},
		glyjxtjech: function() {
			var jxtj = echarts.init(document.getElementById('jxtj'), 'macarons');
			var option = {
				title: {
					text: '各部门绩效统计',
					x: 'center'
				},
				tooltip: {
					trigger: 'item',
					formatter: "{a} <br/>{b} : {c} ({d}%)"
				},
				legend: {
					orient: 'vertical',
					left: 'left',
					data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
				},
				series: [{
					name: '完成任务数量',
					type: 'pie',
					radius: '55%',
					center: ['50%', '60%'],
					data: [{
							value: 335,
							name: '直接访问'
						},
						{
							value: 310,
							name: '邮件营销'
						},
						{
							value: 234,
							name: '联盟广告'
						},
						{
							value: 135,
							name: '视频广告'
						},
						{
							value: 1548,
							name: '搜索引擎'
						}
					],
					itemStyle: {
						emphasis: {
							shadowBlur: 10,
							shadowOffsetX: 0,
							shadowColor: 'rgba(0, 0, 0, 0.5)'
						}
					}
				}]
			};
			jxtj.setOption(option);
			window.addEventListener("resize", function() {
				jxtj.resize();
			});
		}
	},
	mounted: function() {
		this.inituser();
	}
});
