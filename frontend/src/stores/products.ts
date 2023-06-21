import { defineStore } from "pinia";
import { computed, ref } from "vue";

import type { Product } from "@/services/types";
import { getAllProducts } from "@/services/ProductService";

export const useProductsStore = defineStore("products", () => {
  const products = ref<Product[]>([]);
  const totalProducts = ref(0);
  const selectedCategory = ref("");
  const termForQuery = ref("");

  const FETCH_PRODUCTS = async () => {
    const receivedProducts = await getAllProducts();
    totalProducts.value = parseInt(receivedProducts.headers["x-results-count"]);
    products.value = receivedProducts.data;
  };

  const CHANGE_SELECTED_CATEGORY = (category: string) => {
    selectedCategory.value = category;
  };

  const CHANGE_TERM_FOR_QUERY = (term: string) => {
    termForQuery.value = term;
  };

  const FILTERED_PRODUCTS = computed(() => {
    return products.value
      .filter((product) => INCLUDE_PRODUCT_BY_CATEGORY(product))
      .filter((product) => INCLUDE_PRODUCT_BY_TERM(product));
  });

  const INCLUDE_PRODUCT_BY_CATEGORY = (product: Product) => {
    if (
      selectedCategory.value === "" ||
      selectedCategory.value === "Wszystkie produkty"
    )
      return true;
    return product.categories.includes(selectedCategory.value);
  };

  const INCLUDE_PRODUCT_BY_TERM = (product: Product) => {
    return product.name
      .toLowerCase()
      .includes(termForQuery.value.toLowerCase());
  };

  const UNIQUE_CATEGORIES = computed(() => {
    return new Set(products.value.map((p) => p.categories[0]));
  });

  return {
    FILTERED_PRODUCTS,
    FETCH_PRODUCTS,
    CHANGE_SELECTED_CATEGORY,
    CHANGE_TERM_FOR_QUERY,
    totalProducts,
    selectedCategory,
    termForQuery,
    products,
    UNIQUE_CATEGORIES,
  };
});
