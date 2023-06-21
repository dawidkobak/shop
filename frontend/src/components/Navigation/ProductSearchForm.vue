<template>
  <form
    class="w-full h-full my-auto border border-solid border-brand-gray-3 rounded-3xl"
    @submit.prevent="searchForProducts"
  >
    <font-awesome-icon
      :icon="['fas', 'search']"
      class="float-left xl:mx-4 h-1/2 xl:my-3 mx-2 my-2"
    />

    <div
      class="float-left xl:my-2 mobile:w-16 sm:w-32 md:w-36 xl:w-48 mobile:pt-0.5"
    >
      <text-input v-model="term" placeholder="Szukaj produktu" />
    </div>

    <action-button text="Szukaj" type="searchForm" />
  </form>
</template>

<script lang="ts" setup>
import { ref } from "vue";
import { useRouter } from "vue-router";

import ActionButton from "../Shared/ActionButton.vue";
import TextInput from "../Shared/TextInput.vue";
import { useProductsStore } from "@/stores/products";

const router = useRouter();
const productsStore = useProductsStore();

const term = ref("");

function searchForProducts() {
  productsStore.CHANGE_TERM_FOR_QUERY(term.value);
  productsStore.CHANGE_SELECTED_CATEGORY("");
  router.push({
    name: "shop",
    query: { page: "1", category: "", q: term.value },
  });
}
</script>
