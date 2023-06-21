<template>
  <div
    class="bg-white border-l border-solid border-brand-gray-1 lg:w-1/5 lg:float-left w-full lg:pl-8 mobile:px-2 lg:px-0"
  >
    <ul class="flex flex-row overflow-y-auto lg:block">
      <li
        v-for="category in categories"
        :key="category"
        class="mobile:float-left lg:float-none mobile:pr-1"
      >
        <action-button
          type="searchCategory"
          :text="category"
          @click="changeCategory(category)"
        />
      </li>
    </ul>
  </div>
</template>

<script lang="ts" setup>
import { computed, ref, watch, toRef } from "vue";
import { useRouter } from "vue-router";

import ActionButton from "../Shared/ActionButton.vue";
import { useProductsStore } from "@/stores/products";

const produtctsStore = useProductsStore();
const router = useRouter();

const productCategoires = computed(() => produtctsStore.UNIQUE_CATEGORIES);

watch(productCategoires, () => {
  categories.value = ["Wszystkie produkty", ...productCategoires.value];
});

const categories = ref(["Wszystkie produkty", ...productCategoires.value]);

function changeCategory(category: string) {
  produtctsStore.CHANGE_SELECTED_CATEGORY(category);
  produtctsStore.CHANGE_TERM_FOR_QUERY("");
  router.push({ name: "shop", query: { page: "1", category: category } });
}
</script>
