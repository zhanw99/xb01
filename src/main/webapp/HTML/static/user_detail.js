new Vue({
    el:'#no-padding-bottom',

    methods:{
    },
    created:function () {
        //在vue对象创建后   获取layer父窗口传递的对象数据
        this.appVersion=parent.layer.appVersion;
        console.log(this.appVersion)
    }
})