<template>
  <div class="w-full">
    <product-filters-sidebar />
    <product-listing />
  </div>
</template>

<script lang="ts" setup>
import ProductFiltersSidebar from "@/components/Product/ProductFiltersSidebar.vue";
import ProductListing from "@/components/Product/ProductListing.vue";
</script>
