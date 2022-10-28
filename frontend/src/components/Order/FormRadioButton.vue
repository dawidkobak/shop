<template>
  <label :for="props.id" class="block pl-3 text-sm mb-1 mt-2">
    <input :id="props.id" :name="props.name" type="radio" class="mr-1" />
    {{ props.label }}
  </label>
</template>

<script setup>
const props = defineProps({
  id: {
    type: String,
    required: true,
    default: "",
  },
  name: {
    type: String,
    required: true,
    default: "",
  },
  label: {
    type: String,
    required: true,
    default: "",
  },
});
</script>
