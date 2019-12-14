new Vue({
    el: '#page-content',
    data: {
        params: {
            pageNum: 1,
            pageSize: 5,
            id:'',
            item:''
        },
        parse:''
    },
    methods: {
        focusId: function (pageNum, pageSize,id) {
            let item = sessionStorage.getItem("userInfo");
            let parse = JSON.parse(item);
            this.parse=parse.id

            this.params.pageNum=pageNum;
            this.params.pageSize=pageSize;
            this.params.id=parse.id;
            axios({
                url:'/xb/userfocus/focusId',
                method:"post",
                data: this.params
            }).then(response => {
                this.params=response.data;
                console.log(this.parse)
            }).catch(function (error) {
                console.log(error);
            })
        },
        deleDetaid: function (id) {
            let item = sessionStorage.getItem("userInfo");
            let parse = JSON.parse(item);
            console.log(this.params)
            axios({
                url: '/xb/userfocus/deleDetaid',
                params:{
                    id:id,
                    item:parse.id
                }
            }).then(response => {
                let data = response.data;
                let success = data.success;
                let msg = data.setMsg;
                if (success){
                    layer.msg(msg);
                    this.focusId()
                }
                console.log(data);
            }).catch(function (error) {
                console.log(error);
            })
        }
    },
    created: function () {
        this.focusId();
    },

})
