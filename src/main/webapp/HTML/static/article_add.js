new Vue({
    el: '#page-content',
    data: {
        params: {
            Title: '',
            Article: '',
            LoginId:'',
            realName:''
        }
    },
    methods: {
        updateArticle: function () {
            let item = sessionStorage.getItem("userInfo");
            let parse = JSON.parse(item);
            this.params.LoginId=parse.id;
            this.params.realName=parse.realName;
            axios({
                url: '/xb/manager/articleAdd/updateArticle',
                method:"post",
                data: this.params
            }).then(response => {
                this.params=response.data;
                let success= response.data
                if (success.success == true){
                    layer.msg(response.data.msg);
                    // layer.alert(response.data.msg, {
                    //     icon: 1,
                    //     skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
                    // })
                    window.setTimeout(2000)
                    window.open('/xb/HTML/html/article.html');
                }
            }).catch(function (error) {
                console.log(error);
            })
        }
    }
})