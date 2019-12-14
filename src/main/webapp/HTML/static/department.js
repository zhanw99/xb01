new Vue({
    el: '#header',
    data: {
        params: {
            pageNum: 1,
            pageSize: 5,
        }
    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            this.params.pageNum=pageNum;
            this.params.pageSize=pageSize;
            axios({
                url: 'manager/dept/selectAll',
                method:"post",
                data: this.params
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
    }

})