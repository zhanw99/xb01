new Vue({
    el: '#no-padding-bottom',
    data: {
        params: {
            pageNum: '',
            pageSize: '',
            id:'',
            title:''
        },
        pageInfo: {
            pageNum: 1,
            pageSize: 5,
            id:'',
            title:''//绑定
        }
    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            let item = sessionStorage.getItem("userInfo");
            let parse = JSON.parse(item);
            this.pageInfo.id=parse.id;

            console.log(this.pageInfo.id)
            this.pageInfo.pageNum=pageNum;
            this.pageInfo.pageSize=pageSize;
            axios({
                url: '/xb/manager/article/selectFavoriteArticle',
                method:"post",
                data: this.pageInfo
            }).then(response => {
                this.params=response.data;
                console.log(response.data)
            }).catch(function (error) {
                console.log(error);
            })
        }
    },
    created: function () {
        this.selectAll();
    },

})