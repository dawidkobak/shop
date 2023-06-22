<template>
  <div>
    <h2 class="text-2xl text-left">{{ props.caption }}</h2>

    <div class="mx-2">
      <div class="flex" v-for="tuple in dataTuple">
        <span class="">{{ tuple.caption }}</span>
        <span class="flex-auto">
          <div class="float-right">{{ tuple.value }}</div>
        </span>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
const props = defineProps({
  caption: {
    type: String,
    required: false,
    default: "",
  },
  dataTuple: {
    type: Array,
    required: true,
  },
});
</script>
