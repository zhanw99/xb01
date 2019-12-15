new Vue({
    el: '#no-padding-bottom',
    data: {
        params: {
            pageNum: 1,
            pageSize: 5,
            name: '',
            id:''
        },
        pageInfo: {
            pageNum: 1,
            pageSize: 5,
            name: '',
            loginId: '',
            id: '',
            checkbox: '',
            success: "false",
        },
        userfocus:{
            id:'',
            focusId:'',
            checked:false
        }
    },
    methods: {
        selectAll: function (pageNum, pageSize) {
            this.params.pageNum = pageNum;
            this.params.pageSize = pageSize;
            axios({
                url: 'manager/user',
                method: "post",
                data: this.params
            }).then(response => {
                this.pageInfo = response.data;
                // let userInfo = JSON.parse(sessionStorage.getItem("userInfo"));//获取账号id
                // this.pageInfo.loginId = userInfo.id;
                console.log(this.pageInfo)
            }).catch(function (error) {
                console.log(error);
            })
        },
        /**
         * 查看详细
         * @param id
         */
        detailed:function(id){
          axios({
            url:'manager/detailed',
              params:{
                  id:id,
              },
          }).then(response=>{
              layer.appVersion = response.data
              console.log(layer.appVersion)
              layer.open({
                      type: 2,
                      title: '详细信息',
                      area: ['80%', '60%'],
                      fixed: false, //不固定
                      content: 'user_detail.html',
                      maxmin: true,//开启最大化最小化按钮
                      /*end: () => {//将then函数中的this传递到end的回调函数中
                          //刷新页面数据    1.直接查询selectAll实现    2.获取layer.appVersion更新当前pageInfo的该数据
                          this.selectAll();
                      }*/
                  })

          }).catch(function (error) {
              console.log(error)
          })
        },
        //点击 关注id
        openId: function (id, event) {
            let userInfo = JSON.parse(sessionStorage.getItem("userInfo"));
            this.userfocus.checked = event.target.checked;
            if (this.userfocus.checked == true) {
                this.userfocus.success = "true";
            } else {
                this.userfocus.success = "false";
            }
            console.log(this.userfocus.checked)
             // console.log(userInfo)//个人信息
            this.userfocus.id = userInfo.id;//账号id
            this.userfocus.focusId = id;//用户ID
            axios({
                url: 'manager/openId',
                method: "post",
                data: this.userfocus
            }).then(response => {
                console.log(response.data)
                console.log("*******")
            }).catch(function (error) {
                console.log(error);
            })
        }
    },
    created: function () {
        this.selectAll(this.params.pageNum, this.params.pageSize);
    },
})
