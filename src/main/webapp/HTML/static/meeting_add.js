new Vue({
    el: '#block-body',
    data: {
        params: {
            title:'',
            state:''
        },
        Release: {
            title:'',//绑定
            deptId:'',//绑定
            makeUser:[],
            startTime:'',
            endTime:'',
            status:''
        },
        Depts:{
            id:'',
            name:''
        },
        users:{
            id:''
        }
    },
    methods: {
        selectDept:function(){
            axios({
                url: 'manager/dept/selectAll',
                method:"post",
            }).then(response => {
                this.Depts=response.data;
            }).catch(function (error) {
                console.log(error);
            })
        },
        selectDeptUser:function(id){
            axios({
                url: '/xb/manager/mettingAdd/selectDeptUser',
                params:{
                    deptId:id
                }
            }).then(response => {
                this.users=response.data;
                console.log("--------")
                console.log(this.users)
            }).catch(function (error) {
                console.log(error);
            })
        },
        /**
         * 发布会议
         */
        insertMeetingAdd: function (){
            console.log(this.Release.startTime)
            console.log(this.Release.endTime)
            axios({
                url: '/xb/manager/mettingAdd/insertMeetingAdd',
                method:"post",
                data: this.Release
            }).then(response => {
                // this.params=response.data;
                console.log(response.data)
            }).catch(function (error) {
                console.log(error);
            })
        }
    },
    mounted: function () {
        this.selectDept();
    },
})