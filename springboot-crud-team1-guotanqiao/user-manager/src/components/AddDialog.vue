<template>

  <el-dialog title="添加|修改" :visible.sync="showDialog" :before-close="closeDialog">
    <el-row>
      <el-col :span="6" class="textCenter">用户名:</el-col>

      <el-col :span="18">
        <el-input v-model="user.username"></el-input>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="6" class="textCenter">密码:</el-col>

      <el-col :span="18">
        <el-input v-model="user.password"></el-input>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6" class="textCenter">性别:</el-col>

      <el-col :span="18">
        <el-select v-model="user.sex" placeholder="请选择">
          <el-option value="男">男</el-option>
          <el-option value="女">女</el-option>
        </el-select>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6" class="textCenter">邮箱</el-col>

      <el-col :span="18">
        <el-input v-model="user.email"></el-input>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6" class="textCenter">省份</el-col>

      <el-col :span="18">
        <el-input v-model="user.province"></el-input>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6" class="textCenter">兴趣:</el-col>

      <el-col :span="18" style="margin-top:15px">
          <el-checkbox-group  v-model="hobby">
              <el-checkbox  v-for="item in shobby" :label="item" :key="item"  ></el-checkbox>
              
          </el-checkbox-group>
            
            
 
        
 
 
      </el-col>
    </el-row>

    <div slot="footer" class="dialog-footer">
      <el-button @click="closeDialog">取 消</el-button>
      <el-button type="primary" @click="add">确 定</el-button>
    </div>
  </el-dialog>
</template>


<script>
export default {
    model:{
        prop:'user',
        event:'closeDialog'
    },
  props: {
    showDialog: Boolean,
    hobby:Array,
    user: {
     
    }
  },
  data() {
    return {
      shobby: ['篮球','游泳','足球','读书'],

   
    };
  },
  methods: {
    closeDialog() {
     //  this.hobby = []
      this.$emit("closeDialog",{});
    },
    add() {
      if (this.user.username == "") {
        this.$message.error("用户名不能为空！");
      } else if (this.user.password == "") {
        this.$message.error("密码不能为空！");
      } else {
 

        this.user.hobby = this.hobby;


        console.log(this.user);
   

        this.$axios.post("/api/user", this.user).then(res => {
          console.log(res);
          this.$message(res.data.msg);
        });
      }

   //  this.hobby = []
      this.$emit("closeDialog",{});
    }
  },
  beforeCreate(){

  },
  created() {
    console.log(this.user)
    this.$set(this.user,'hobby',[])

  },
  mounted() {
    this.$set(this.user,'hobby',[])
  },
  // computed:{
  //   hobby:function(){
  //     return this.user.hobby
  //   }
  // }
};
</script>

<style scoped>
.textCenter {
  line-height: 40px;
  height: 40px;
}
</style>


