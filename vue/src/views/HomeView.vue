<template>
  <div class="main">
    <!-- 功能区域 -->
    <div class="can">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>

    <!-- 搜索区域 -->
    <div class="find">
      <el-input
        v-model="search"
        placeholder="请输入关键字"
        style="width: 20%"
        clearable
      />
      <el-button type="primary" style="margin-left: 0.3125rem" @click="load"
        >查询</el-button
      >
    </div>
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column prop="ID" label="ID" sortable />
      <el-table-column prop="username" label="用户名" />
      <el-table-column prop="nickName" label="昵称" />
      <el-table-column prop="age" label="年龄" />
      <el-table-column prop="sex" label="性别" />
      <el-table-column prop="address" label="地址" />

      <el-table-column fixed="right" label="操作">
        <template #default="{ row }">
          <el-button type="text" @click="handleEdit(row)">编辑</el-button>

          <el-popconfirm title="确认删除吗?" @confirm="handleDelete(row.id)">
            <template #reference>
              <el-button type="text">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <div class="page">
      <el-pagination
        v-model:currentPage="currentPage"
        v-model:page-size="pageSize"
        :page-sizes="[5, 10, 20]"
        :small="small"
        :disabled="disabled"
        :background="background"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />

      <el-dialog v-model="dialogVisible" title="提示" width="30%">
        <el-form label-width="7.5rem">
          <el-form-item :model="form" label="用户名">
            <el-input v-model="form.username" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item :model="form" label="昵称">
            <el-input v-model="form.nickName" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item :model="form" label="年龄">
            <el-input v-model="form.age" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item :model="form" label="性别">
            <el-radio v-model="form.sex" label="男" size="large">男</el-radio>
            <el-radio v-model="form.sex" label="女" size="large">女</el-radio>
            <el-radio v-model="form.sex" label="未知" size="large"
              >未知</el-radio
            >
          </el-form-item>
          <el-form-item :model="form" label="地址">
            <el-input
              type="textarea"
              v-model="form.address"
              style="width: 80%"
            ></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible = false">取消</el-button>
            <el-button type="primary" @click="save">确定</el-button>
          </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "HomeView",
  components: {},
  data() {
    return {
      form: {},
      dialogVisible: false,
      search: "",
      currentPage: 1,
      total: 10,
      pageSize: 10,
      small: false,
      background: false,
      disabled: false,
      tableData: [],
    };
  },
  created() {
    this.load();
  },
  methods: {
    load() {
      request
        .get("/api/user", {
          params: {
            pageNum: this.currentPage,
            pageSize: this.pageSize,
            search: this.search,
          },
        })
        .then((res) => {
          console.log(res);
          this.tableData = res.data.records;
          this.total = res.data.total;
        });
    },
    add() {
      this.dialogVisible = true;
      this.form = {};
    },
    save() {
      if (this.form.id) {
        //更新
        request.put("/api/user", this.form).then((res) => {
          console.log(res);
          if (res.code === "0") {
            this.$message({
              type: "success",
              message: "更新成功",
            });
          } else {
            this.$message({
              type: "error",
              message: res.msg,
            });
          }
          this.load();
          this.dialogVisible = false;
        });
      } else {
        //新增
        request.post("/api/user", this.form).then((res) => {
          console.log(res);
          if (res.code === "0") {
            this.$message({
              type: "success",
              message: "新增成功",
            });
          } else {
            this.$message({
              type: "error",
              message: res.msg,
            });
          }
        });
        this.load();
        this.dialogVisible = false;
      }
    },
    handleEdit(row) {
      this.form = JSON.parse(JSON.stringify(row));
      this.dialogVisible = true;
    },
    handleSizeChange() {
      this.load()
    },
    handleCurrentChange() {
      this.load()
    },
    handleDelete(id){
      request.delete("/api/user/"+id).then(res =>{
         if (res.code === "0") {
            this.$message({
              type: "success",
              message: "删除成功",
            });
          } else {
            this.$message({
              type: "error",
              message: res.msg,
            });
          }
          this.load()
      })
    },
  },
};
</script>
<style scoped>
.main {
  padding: 0.625rem;
  display: inline;
}
.can {
  margin: 0.625rem 0;
}
.find {
  margin: 0.625rem 0;
}
.page {
  margin: 0.625rem 0;
}
</style>