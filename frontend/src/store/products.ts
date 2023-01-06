import { defineStore } from "pinia";
import { ref } from "vue";

import type { Product } from "@/services/types";
import { getAllProducts } from "@/services/ProductService";

export const useProductsStore = defineStore("products", () => {
  const products = ref<Product[]>([]);

  const FETCH_PRODUCTS = async () => {
    const receivedProducts = await getAllProducts();
    products.value = receivedProducts.data;
  };

  return { products, FETCH_PRODUCTS };
});
