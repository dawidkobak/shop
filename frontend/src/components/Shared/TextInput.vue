<template>
  <input
    type="text"
    :value="props.modelValue"
    :placeholder="props.placeholder"
    class="2xl:text-lg w-full mobile:text-xxs sm:text-sm font-normal focus:outline-none"
    @input="handleInput"
  />
</template>

<script lang="ts" setup>
const props = defineProps({
  placeholder: {
    type: String,
    required: false,
    default: "",
  },
  modelValue: {
    type: String,
    required: true,
  },
});

const emit = defineEmits(["update:modelValue"]);

function handleInput($event) {
  emit("update:modelValue", $event.target.value);
}
</script>
