<template>
  <label :for="props.id" class="block pl-3 text-sm mb-1 mt-2">
    <input
      :id="props.id"
      type="checkbox"
      class="mr-1"
      :required="props.obligatory"
    />
    {{ props.label }}
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
  obligatory: {
    type: Boolean,
    required: false,
    default: true,
  },
});
</script>
