<template>
  <label class="block pl-3 text-sm mb-1 mt-2">
    {{ props.label }}
  </label>
  <input
    :type="props.type"
    :value="props.value"
    :placeholder="props.placeholder"
    class="pl-2.5 pr-2.5 pt-1 pb-1 focus:outline-none border border-solid border-brand-gray-3 rounded-3xl w-full"
    @input="handleInput($event)"
  />
</template>

<script setup>
const props = defineProps({
  label: {
    type: String,
    required: true,
    default: "",
  },
  type: {
    type: String,
    required: false,
    default: "text",
  },
  placeholder: {
    type: String,
    required: false,
    default: "",
  },
  value: {
    type: String,
    required: false,
    default: "",
  },
});

const emit = defineEmits(["updatedInput"]);

function handleInput($event) {
  emit("updatedInput", $event.target.value);
}
</script>

<style scoped></style>
