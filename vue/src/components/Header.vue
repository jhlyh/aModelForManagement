<template>
  <div id="Head">
    <div id="left">后台管理</div>
    <div id="center"></div>
    <div id="right">
      <el-dropdown>
        <span class="el-dropdown-link">
          JHLYH
          <el-icon class="el-icon--right">
            <arrow-down />
          </el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>个人信息</el-dropdown-item>
            <el-dropdown-item>退出系统</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
export default {

};
</script>

<style>
#Head {
  height: 3.125rem;
  line-height: 3.125rem;
  border-bottom: 0.0625rem solid #ccc;
  display: flex;
}
#left {
  width: 12.5rem;
  padding-left: 1.875rem;
  font-weight: bold;
  color: dodgerblue;
}
#center {
  flex: 1;
}
#right {
  width: 6.25rem;
}
.el-dropdown-link {
  text-align: center;
  line-height: 3.125rem;
}
</style>