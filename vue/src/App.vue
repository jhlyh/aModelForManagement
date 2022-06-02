<template>
  <div>
    <!-- 头部 -->
    <Header />

    <!-- 主体 -->
    <div class="main">
      <!-- 侧边栏 -->
      <Aside /> 
      <!-- 内容区域 -->
      <router-view class="router_view"/>
    </div>
  </div>

</template>

<script>
import Header from "@/components/Header.vue"
import Aside from '@/components/Aside.vue'

export default {
  name:"Layout",
  components:{
    Header,
    Aside,
  }

}

</script>

<style>
.main{
  display: flex;
}
.router_view{
  flex: 1;
}
</style>