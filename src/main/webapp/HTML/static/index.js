new Vue({
    el: '#container',
    data: {
        params: {
            checkbox:false,
            checkCode:'',
            password:'',
            username:''
        }
    },
    methods: {
        login:function (event) {
            this.params.checked = event.target.checked;
            axios({
                url:'manager/login/login',
                method:"post",
                data:this.params
            }).then(response => {
                console.log(response.data)
                let data = response.data;
                if(data.success==false){//登录失败
                     layer.msg(data.msg,{time:500},function(){
                        location.href='index.html';
                    });
                    layer.msg(response.data.msg)
                }else {
                    sessionStorage.setItem("userInfo", JSON.stringify(response.data.obj));
                    //再将userInfo放入到前端的会话对象sessionStorage中，该sessionStorage对象是整个浏览器不关闭的时候都存在的
                    // sessionStorage  	只在当前对话框有效，关闭页面或浏览器后被清除
                    // localStorage 	除非被清除，否则永久保存
                    sessionStorage.getItem("userInfo");
                     layer.msg(data.msg,{time:500},function(){
                        location.href='html/user.html';
                    });
                }
                console.log(response.data)
            }).catch(function (error) {
                console.log(error);
            })
        },
        changeImg: function (e) {
            e.target.src = "/xb/getCode.jpg?" + new Date();
        },
    },

})
