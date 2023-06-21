<template>
  <div class="mt-3">
    <label class="block text-sm font-medium leading-6 text-gray-900">
      {{ props.label }}
      <span v-if="props.required" class="text-red-800">*</span>
    </label>
    <input
      :type="props.type"
      :required="props.required"
      :value="props.value"
      :disabled="props.disabled"
      :placeholder="props.placeholder"
      class="form-input block w-full rounded-md border-0 py-1.5 px-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-sky-600 sm:text-sm sm:leading-6"
      :class="props.styles"
      @input="handleInput($event)"
    />
  </div>
</template>

<script lang="ts" setup>
const props = defineProps({
  modelValue: {
    type: String,
    required: false,
  },
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
  required: {
    type: Boolean,
    required: false,
    default: false,
  },
  disabled: {
    required: false,
    type: Boolean,
    default: false,
  },
  styles: {
    required: false,
    type: Object,
    default: {},
  },
});

const emit = defineEmits(["updatedInput", "update:modelValue"]);

function handleInput($event: Event) {
  const target = $event.target as HTMLInputElement;
  emit("updatedInput", target.value);
  emit("update:modelValue", target.value);
}
</script>

<style scoped></style>
