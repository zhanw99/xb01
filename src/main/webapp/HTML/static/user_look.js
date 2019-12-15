new Vue({
    el:'#no-padding-bottom',
    data:{
        params: {
            id:'',

        }
    },
    methods:{
        /**
         * 查看详细
         * @param id
         */
        detailed:function(){
            let userInfo = JSON.parse(sessionStorage.getItem("userInfo"));
            axios({
                url:'manager/detailed',
                params:{
                    id:userInfo.id//账号id
                },
            }).then(response=>{
                console.log("******");
                this.params= response.data;
                console.log(this.params);
            }).catch(function (error) {
                console.log(error)
            })
        }
    },
    mounted:function () {
        //在vue对象创建后   获取layer父窗口传递的对象数据
        this.detailed()
    }
})