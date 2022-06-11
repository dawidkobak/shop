<template>

  <label :for="id" class="block pl-3 text-sm mb-1 mt-2">
    <input :id="id" :name="name" type="radio" class="mr-1">
    {{label}}
  </label>
</template>

<script>
export default {
  name: "FormRadio",
  props: {
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
    }
  }
};
</script>

<style scoped>

</style>