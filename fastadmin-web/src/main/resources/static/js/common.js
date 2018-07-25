define(['jquery'], function ($) {
    var Common = {
        /**
         * 获取指定的URL参数值
         * 参数：paramName URL参数
         * 返回值:value
         */
        urlParam: function(paramName) {
            var paramValue = "", isFound = !1;
            if (location.search.indexOf("?") == 0 && location.search.indexOf("=") > 1) {
                arrSource = unescape(location.search).substring(1, location.search.length).split("&"), i = 0;
                while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++
            }
            return paramValue == "" && (paramValue = null), paramValue
        },
        /**
         * 获取所有的URL参数
         * 返回值 {}
         */
        urlParams: function (){
            var args=new Object();
            var query=location.search.substring(1);//获取查询串
            var pairs=query.split(",");//在逗号处断开
            for(var i=0;i<pairs.length;i++){
                var pos=pairs[i].indexOf('=');//查找name=value
                if(pos==-1){//如果没有找到就跳过
                    continue;
                }
                var argname=pairs[i].substring(0,pos);//提取name
                var value=pairs[i].substring(pos+1);//提取value
                args[argname]=unescape(value);//存为属性
            }
            return args;//返回对象
        }
    };
    return Common;
});
