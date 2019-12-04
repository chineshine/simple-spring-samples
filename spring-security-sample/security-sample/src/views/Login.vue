<template>
  <div>
    <el-form ref="form" :model="loginForm" :rules="loginFormRules" label-width="100px" size="mini">
      <el-form-item label="用户名" prop="username">
          <el-input placeholder="请输入用户名" v-model="loginForm.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
          <el-input type="password" placeholder="请输入密码" v-model="loginForm.password">
          </el-input>
      </el-form-item>
      <el-form-item size="large">
        <el-button type="primary" @click="login">登录</el-button>
      </el-form-item>
    </el-form>
    <div>
      用户名: user  密码: 123456
    </div>
  </div>
</template>
<script>
import {
  Login
} from "@/interface/login/";
export default{
  name: '',
  components: {},
  data(){
    return {
      loginForm: {
        username: '',
        password: ''
      },
      loginFormRules: {}
    };
  },
  methods: {
    login(){
      Login(this.loginForm.username,this.loginForm.password).then(data=> {
        console.log(data);
        if(data){
          this.$router.push({name: "home",})
        }
      })
    },
  },
  mounted(){

  }
}
</script>
<style lang="scss" scoped>

</style>
