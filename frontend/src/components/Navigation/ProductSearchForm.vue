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
      <text-input v-model="productName" placeholder="Szukaj produktu" />
    </div>

    <action-button text="Szukaj" type="searchForm" />
  </form>
</template>

<script setup>
import { ref } from "vue";
import ActionButton from "../Shared/ActionButton.vue";
import TextInput from "../Shared/TextInput.vue";
import router from "@/router";

const productName = ref("");

function searchForProducts() {
  router.push({
    name: "shopView",
    query: { page: 1, category: "", phrase: productName.value },
  });
}
</script>
