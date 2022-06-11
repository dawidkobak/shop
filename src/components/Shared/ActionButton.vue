<template>
  <button :class="buttonClass">{{ text }}</button>
</template>

<script>
export default {
  name: "ActionButton",
  props: {
    text: {
      type: String,
      required: false,
      default: "",
    },
    type: {
      type: String,
      required: false,
      default: "primary",
    },
  },
  computed: {
    buttonClass() {
      return {
        [this.type]: true,
      };
    },
  },
};
</script>

<style scoped>
button {
  @apply font-medium;
}

.primary {
  @apply px-5 py-3 text-brand-green-2 bg-transparent hover:bg-brand-green-2 hover:text-white;
}

.searchCategory {
  @apply w-56 px-5 py-3 text-white bg-brand-green-2 rounded-full uppercase mb-5 first:mt-5 hover:shadow-green;
}

.order {
  @apply px-5 py-3 w-full text-white bg-brand-green-2 rounded-md hover:bg-brand-green-1;
}

.close {
  @apply px-5 py-3 absolute top-0 right-0 text-4xl text-red-300 my-2 mx-4;
}

.close2 {
  @apply text-2xl text-red-600;
}
</style>
