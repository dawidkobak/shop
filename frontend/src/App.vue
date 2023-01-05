<template>
  <div>
    <main-nav />
    <router-view class="2xl:pt-24 mobile:pt-16" />
    <cart-instance />
  </div>
</template>

<script lang="ts" setup>
import MainNav from "@/components/Navigation/MainNav.vue";
import CartInstance from "@/components/Cart/CartInstance.vue";
</script>
