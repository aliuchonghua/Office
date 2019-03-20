var global={};
global.path={};
global.Fun={};
// 路径
global.path.root="http://localhost:9090/";

global.Fun.ssxView=function (container) {
    container.html('<div class="row">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t<div class="col-md-4">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t<label for="sheng">省份/地区：</label>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t<select class="form-control" v-model="city.sheng">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option v-for="item in sheng" v-on:click="getshi(item)">{{item.cityname}}</option>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t<div class="col-md-4">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t<label for="shi">城市：</label>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t<select class="form-control" v-model="city.shi">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option v-for="item in shi" v-on:click="getxian(item)">{{item.cityname}}</option>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t<div class="col-md-4">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t<label for="xian">区/县：</label>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t<select class="form-control" v-model="city.xian">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option v-for="item in xian">{{item.cityname}}</option>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t</div>');

}