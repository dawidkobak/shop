<template>
  <button :class="buttonClass">{{ props.text }}</button>
</template>

<script setup>
import { computed } from "vue";

const props = defineProps({
  text: {
    type: String,
    required: false,
    default: "",
  },
  type: {
    type: String,
    required: false,
    default: "primary",
  },
});

const buttonClass = computed(() => {
  return {
    [props.type]: true,
  };
});
</script>

<style scoped>
button {
  @apply font-medium;
}

.primary {
  @apply px-5 py-3 text-brand-green-2 bg-transparent hover:bg-brand-green-2 hover:text-white;
}

.searchCategory {
  @apply 2xl:w-72 lg:w-44 xl:w-52 lg:py-3 mobile:py-2 my-3 mobile:px-2 lg:text-2xl mobile:text-xs text-white bg-brand-green-2 rounded-full uppercase mb-5 hover:shadow-green whitespace-nowrap;
}

.order {
  @apply px-5 py-3 w-full text-white bg-brand-green-2 rounded-md hover:bg-brand-green-1;
}

.close {
  @apply px-5 py-3 absolute top-0 right-0 text-4xl text-red-300 my-2 mx-4;
}

.close2 {
  @apply text-2xl text-red-600;
}

.searchForm {
  @apply float-right xl:px-5 xl:py-2.5 text-xxs xl:text-base text-brand-green-2 bg-transparent hover:bg-brand-green-2 hover:text-white rounded-r-3xl mobile:pt-1.5;
}
</style>
