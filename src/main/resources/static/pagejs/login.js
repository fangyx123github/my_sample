var element,$,laydate,upload,layer;
layui.use(['laydate','upload','layer'],function(){
    element=layui.element,$ = layui.jquery,laydate=layui.laydate,upload=layui.upload,layer=layui.layer;
    //日期控件
    laydate.render({
        elem: '#birthdate'
        , format: 'yyyy-MM-dd'
        , theme: 'molv'
    });
    //文件上传
    upload.render({
        elem : '#upload_img',
        url : '',
        done:function(res, index, upload){}
    });
});
var app = new Vue({
    el:'#app',
    data:{},
    methods : {}
});


