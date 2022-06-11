<template>
  <label
    :for="id"
    class="block pl-3 text-sm mb-1 mt-2"
  >
    {{label}}
  </label>
  <input
    :id="id"
    :type="type"
    :placeholder="placeholder"
    class="pl-2.5 pr-2.5 pt-1 pb-1 focus:outline-none border border-solid border-brand-gray-3 rounded-3xl w-full"
  >
</template>

<script>
export default {
  name: "FormInput",
  props: {
    id: {
      type: String,
      required: true,
      default: "",
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
    }
  }
};
</script>

<style scoped>

</style>