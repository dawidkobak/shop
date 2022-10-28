<template>
  <div class="w-full">
    <product-filters-sidebar />
    <product-listing :page="page" :category="category" :phrase="phrase" />
  </div>
</template>

<script setup>
import { computed } from "@vue/reactivity";
import ProductFiltersSidebar from "@/components/Product/ProductFiltersSidebar.vue";
import ProductListing from "@/components/Product/ProductListing.vue";
import { useRoute } from "vue-router";

const route = useRoute();

const page = computed(() => {
  return parseInt(route.query.page) || 1;
});

const category = computed(() => {
  return route.query.category || "";
});

const phrase = computed(() => {
  return route.query.phrase || "";
});
</script>
