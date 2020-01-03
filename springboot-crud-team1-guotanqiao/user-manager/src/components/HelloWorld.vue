/* eslint-disable */ 
<template>
  <div class="hello">
   
   
  
       

    <el-button @click="addUser">添加</el-button>
        <table>
            <tr>
                <th>编号</th>
                <th>用户名</th>
                <th>邮箱</th>
                <th>性别</th>
                <th>省份</th>
                <th>爱好</th>
                <th>操作</th>
            </tr>
            <tr v-for="(item,index) in userList" v-bind:key ="index">
                
                <td>{{index+1}}</td>
                <td>{{item.username}}</td>
                <td>{{item.email}}</td>
                <td>{{item.sex}}</td>
                <td>{{item.province}}</td>
                <td>{{item.hobby.join(' | ')}}</td>
                <td><a href="javascript:;" @click="edit(item)">修改</a> | <a href="javascript:;" @click="deleteUser(item.id)">删除</a></td>
            </tr>
        </table>
        <!--这里使用v-model 会绑定组件的model 中的 prop-->
        <app-addDialog v-bind:user="selectUser" v-bind:hobby="selectHobby" v-bind:showDialog="addShow" @closeDialog="closeDialog"></app-addDialog>
 </div>

   
    
  
</template>

<script>
import AddDialog from './AddDialog'
export default {
  name: 'HelloWorld',
  data() {
    return {
      userList:Array, //用户列表
      selectUser:Object,//传递给弹窗的变量
      selectHobby:[],
      searchlist:Array,
      addShow: false,//控制弹窗
     
    };
  },
  methods:{

    edit(item){
      console.log('发送请求')
      //传递变量给弹窗
      this.selectUser = item
      this.selectHobby = item.hobby
      console.log(this.selectHobby)
      this.addShow = true

      

    },
    closeDialog() {
     
      this.addShow = false;
      this.selectHobby = []
      this.getUserList();
        
      
    },
    addUser(){
        this.addShow = true
        //清空弹窗变量
        this.selectUser= {}

    },
    deleteUser(id){
        console.log(id)
        this.$axios.post("/api/user/del",{"id":id}).then(res=>{
            console.log(res)
            this.getUserList()
            
        })
    },
    getUserList(){
        this.$axios.get("/api/user",{}).then(res=>{
        console.log(res);
        this.userList = res.data
        console.log(this.userList)
      })
    }

  },

  props: {
    msg: String,
  
  },
  created() {
    console.log("初始化、。。。");
    this.getUserList()
  },
  components:{
      "app-addDialog":AddDialog
  }
 
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 .container,
        .st {
            width: 1000px;
            margin: 10px auto 0;
            font-size: 13px;
            font-family: 'Microsoft YaHei'
        }
        .container .search {
            font-size: 15px;
            padding: 4px;
        }
        .container .add {
            padding: 5px 15px;
        }
  table {
            border: 1px solid #ccc;
            padding: 0;
            border-collapse: collapse;
            table-layout: fixed;
            margin-top: 10px;
            width: 100%;
        }
        table td,
        table th {
            height: 30px;
            border: 1px solid #ccc;
            background: #fff;
            font-size: 15px;
            padding: 3px 3px 3px 8px;
        }
        table th:first-child {
            width: 30px;
        }
</style>
