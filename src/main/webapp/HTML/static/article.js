new Vue({
    el: '#no-padding-bottom',
    data: {
        params: {
            pageNum: 1,
            pageSize: 5,
            id:'',
            title:''
        },
        //传到后台
        pageInfo: {
            pageNum: '',
            pageSize: '',
            id:'',
            title:''
        }
    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            let item = sessionStorage.getItem("userInfo");
            let parse = JSON.parse(item);
            this.params.id=parse.id;
            // console.log(this.params.id);
            this.pageInfo.pageNum=pageNum;
            this.pageInfo.pageSize=pageSize;
            axios({
                url: '/xb/manager/article/selectAll',
                method:"post",
                data: this.pageInfo
            }).then(response => {
                this.params=response.data;
                console.log(response.data)
                console.log(this.params.title)
            }).catch(function (error) {
                console.log(error);
            })
        }
    },
    created: function () {
        this.selectAll();
        console.log("*****")
    }

})