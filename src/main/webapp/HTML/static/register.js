new Vue({
    el: '#form-bottom',
    data: {
        params: {
            email:'',
            username:'',
            password:'',
            password2:'',
        }
    },
    methods: {
        register:function () {
            this.params.checked = event.target.checked;
            axios({
                url:'manager/login/register',
                method:"post",
                data:this.params
            }).then(response => {
                console.log(response.data)
                let data = response.data;
                if(data.success==false){//注册失败
                    layer.msg(data.msg,{time:500},function(){
                        location.href='register.html';
                    });
                    layer.msg(response.data.msg)
                }else {//注册成功
                    layer.msg(data.msg,{time:500},function(){
                        location.href='index.html';
                    });
                }
                console.log(response.data)
            }).catch(function (error) {
                console.log(error);
            })
        }
    }

})
