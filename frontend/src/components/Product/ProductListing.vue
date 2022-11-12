<template>
  <div class="float-right mobile:w-full lg:w-4/5">
    <div
      class="sm:p-10 grid xl:grid-cols-5 md:grid-cols-3 grid-cols-2 gap-x-4 gap-y-4 pb-4"
    >
      <product-instance
        v-for="product in products"
        :key="product._id"
        :product-object="product"
      />
    </div>

    <div class="flex items-center justify-center">
      <router-link
        v-if="page != 1"
        :to="{
          name: 'shopView',
          query: { page: page - 1, category: category, phrase: phrase },
        }"
        class="sm:text-xl text-sm font-semibold text-brand-green-2 mb-10"
        >Poprzednia strona</router-link
      >
      <router-link
        v-if="hasNextPage"
        :to="{
          name: 'shopView',
          query: { page: page + 1, category: category, phrase: phrase },
        }"
        class="sm:text-xl text-sm font-semibold text-brand-green-2 ml-10 mb-10"
        >Następna strona</router-link
      >
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import ProductService from "@/services/ProductService";
import ProductInstance from "@/components/Product/ProductInstance.vue";
import { computed } from "@vue/reactivity";
import { useRouter } from "vue-router";

const router = useRouter();

const perPage = 10;
const products = ref([]);
const page = ref(1);
const category = ref("");
const phrase = ref("");
const totalProducts = ref(0);
const hasNextPage = computed(() => {
  return totalProducts.value > page.value * perPage;
});

onMounted(() => {
  getProducts();
});

router.afterEach((to, from) => {
  if (to.name === "shop" || to.name === "shopView") {
    const parsedPage = parseInt(to.query.page);
    if (isNaN(parsedPage)) {
      page.value = 1;
    } else {
      page.value = parsedPage;
    }
    category.value = to.query.category;
    phrase.value = to.query.phrase;
    getProducts(page.value, category.value, phrase.value);
  }
});

function getProducts(page = 1, category = "", phrase = "") {
  ProductService.getProducts(perPage, page, category, phrase).then(
    (response) => {
      products.value = response.data;
      totalProducts.value = parseInt(response.headers["all-products-count"]);
    }
  );
}
</script>
