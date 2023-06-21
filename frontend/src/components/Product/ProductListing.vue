<template>
  <div class="float-right mobile:w-full lg:w-4/5">
    <div
      class="sm:p-10 grid xl:grid-cols-5 md:grid-cols-3 grid-cols-2 gap-x-4 gap-y-4 pb-4"
    >
      <product-instance
        v-for="product in displayedProducts"
        :key="product._id"
        :product-object="product"
      />
    </div>

    <div class="flex items-center justify-center">
      <router-link
        v-if="page != 1"
        :to="{
          name: 'shop',
          query: { page: page - 1, category },
        }"
        class="sm:text-xl text-sm font-semibold text-brand-green-2 mb-10"
        >Poprzednia strona</router-link
      >
      <router-link
        v-if="hasNextPage"
        :to="{
          name: 'shop',
          query: { page: page + 1, category },
        }"
        class="sm:text-xl text-sm font-semibold text-brand-green-2 ml-10 mb-10"
        >Następna strona</router-link
      >
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ref, onMounted } from "vue";
import { computed } from "@vue/reactivity";
import { useRoute } from "vue-router";

import ProductInstance from "@/components/Product/ProductInstance.vue";
import { useProductsStore } from "@/stores/products";

const route = useRoute();
const productsStore = useProductsStore();

const perPage = 10;
const page = computed(() => {
  return parseInt(route.query.page as string) || 1;
});
const category = computed(() => {
  return route?.query?.category?.toString() || "";
});
const term = computed(() => {
  return route?.query?.q?.toString() || "";
});
const hasNextPage = computed(() => {
  return FILTERED_PRODUCTS.value.length > page.value * perPage;
});

onMounted(async () => {
  await productsStore.FETCH_PRODUCTS();
  productsStore.CHANGE_SELECTED_CATEGORY(category.value);
  productsStore.CHANGE_TERM_FOR_QUERY(term.value);
});

const FILTERED_PRODUCTS = computed(() => productsStore.FILTERED_PRODUCTS);

const displayedProducts = computed(() => {
  const firstJobIndex = (page.value - 1) * perPage;
  const lastJobIndex = page.value * perPage;
  return FILTERED_PRODUCTS.value.slice(firstJobIndex, lastJobIndex);
});
</script>
