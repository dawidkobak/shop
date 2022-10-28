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

<script setup>
import router from "@/router";
import ActionButton from "../Shared/ActionButton.vue";

const categories = [
  "Wszystkie produkty",
  "Warzywa",
  "Owoce",
  "Nabiał",
  "Napoje",
  "Alkohole",
  "Pieczywo",
  "Słodycze",
  "Przekąski",
];

function changeCategory(category) {
  if (category == "Wszystkie produkty") {
    router.push({
      name: "shopView",
      query: {
        page: 1,
      },
    });
  } else {
    router.push({
      name: "shopView",
      query: {
        page: 1,
        category: category,
      },
    });
  }
}
</script>
