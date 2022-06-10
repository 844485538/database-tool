<template>
<div>
  <p>连接数据库</p>
  <el-form>
    <el-form-item label="主机">
      <el-input v-model="form.host" />
    </el-form-item>

    <el-form-item label="端口">
      <el-input v-model="form.port" />
    </el-form-item>

    <el-form-item label="用户名">
      <el-input v-model="form.username" />
    </el-form-item>

    <el-form-item label="密码">
      <el-input type="password" v-model="form.password" />
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="connection">连接</el-button>
    </el-form-item>

  </el-form>
</div>
</template>

<script>

import globalAPI from "@/api"

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Home",
  data() {
    return {
      form: {
        host: '',
        port: '',
        username: '',
        password: '',
      }
    }
  },
  methods:{
    connection(){
      const param = {
        "host":this.form.host,
        "port":this.form.port,
        "username":this.form.username,
        "password":this.form.password
      }
      globalAPI.connectionApi.connection(param).then(
          response => {
            console.log(response)
            window.sessionStorage.setItem("database-id", response.data)
            this.$router.push("/table")
          }
      )
    },
    cancel(){
      alert("取消")
    }
  }
}
</script>

<style scoped>

</style>
