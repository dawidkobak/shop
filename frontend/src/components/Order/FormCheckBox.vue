<template>
  <label :for="props.id" class="block pl-3 text-sm mb-1 mt-2">
    <input :id="props.id" type="checkbox" class="mr-1" />
    {{ props.label }}
  </label>
</template>

<script setup>
const props = defineProps({
  id: {
    type: String,
    required: false,
    default: "",
  },
  label: {
    type: String,
    required: false,
    default: "",
  },
});
</script>
