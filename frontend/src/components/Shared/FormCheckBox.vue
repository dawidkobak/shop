<template>
  <label :for="props.id" class="block pl-3 text-sm mb-1 mt-2">
    <input
      :id="props.id"
      type="checkbox"
      class="mr-1"
      :required="props.required"
    />
    {{ props.label }}
    <slot></slot>
    <span v-if="props.required" class="text-red-800">*</span>
  </label>
</template>

<script lang="ts" setup>
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
  required: {
    type: Boolean,
    required: false,
    default: true,
  },
});
</script>
