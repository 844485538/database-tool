<template>
  <div style="display: flex;flex-direction: column;">
    <div style="display: flex;flex-direction: row;">
      <div style="flex-basis: 30%;">
        <el-card class="box-card">
          <template #header>
            <div class="card-header">
              <span>数据库</span>
            </div>
          </template>
          <div v-for="o in databaseList" :key="o.database" class="text item" v-on:click="showInfo(o.database)">{{ o.database }}</div>
        </el-card>
      </div>
      <div style="flex-basis: 70%;">
        <el-table
            ref="multipleTableRef"
            :data="tableList"
            style="width: 100%"
            @selection-change="handleSelectionChange"
            height="100%"
        >
          <el-table-column fixed type="selection" width="55" />
          <el-table-column property="name" label="表名" width="220" />
          <el-table-column property="comment" label="注释"  />
        </el-table>
      </div>
    </div>
    <div style="margin-top: 20px">
      <el-button type="success" plain @click="selection()">下载数据字典</el-button>
    </div>
  </div>
</template>

<script>
import globalAPI from "@/api"

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "database",
  data(){
    return {
      databaseList: '',
      tableList: '',
      selectDb: '',
      selectTable: ''
    }
  }, created() {
    const param = {
      "id": window.sessionStorage.getItem("database-id")
    }
    globalAPI.tableInfoApi.dbInfo(param).then(
        response => {
          this.databaseList = response.data;
        }
    )
  }, methods: {
    showInfo(dbName) {
      const param = {
        "id": window.sessionStorage.getItem("database-id"),
        "dbName": dbName
      }
      globalAPI.tableInfoApi.tableInfo(param).then(
          response => {
            this.selectDb = dbName;
            this.tableList = response.data;
          }
      )
    },
    handleSelectionChange(row){
      let select = new Array(row.length)
      for (let i=0; i < row.length; i++){
        select[i] = row[i].name;
      }
      this.selectTable = select;
      console.log(select)
    },
    selection(){
      let tables = [];
      for (let i=0; i < this.selectTable.length; i++){
        tables[i] = this.selectTable[i];
      }
      const param = {
        "id": window.sessionStorage.getItem("database-id"),
        "dbName": this.selectDb,
        "tableName": tables
      }
      globalAPI.exportApi.export(param).then(
      )
      console.log(param)
    }
  }
}

</script>

<style scoped>
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.box-card {
  width: 480px;
}
</style>
