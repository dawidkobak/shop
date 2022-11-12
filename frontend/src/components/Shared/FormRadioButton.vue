<template>
  <label :for="props.id" class="block pl-3 text-sm mb-1 mt-2">
    <input
      :id="props.id"
      :name="props.name"
      type="radio"
      class="mr-1"
      :required="props.obligatory"
    />
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
  obligatory: {
    type: Boolean,
    required: false,
    default: true,
  },
});
</script>
