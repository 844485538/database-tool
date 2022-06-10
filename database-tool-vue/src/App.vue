<template>
  <div id="app">
    <el-header id="header">
    </el-header>
    <el-main id="main">
      <router-view/>
    </el-main>
    <el-footer id="footer">
    </el-footer>
  </div>
</template>

<script>

export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
