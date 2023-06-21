<template>
  <div class="mt-8">
    <form-check-box>
      Przeczytałem/am i akceptuję
      <span class="cursor-pointer underline text-blue-500" @click="regulations"
        >regulamin</span
      >
    </form-check-box>
  </div>
</template>

<script lang="ts" setup>
import FormCheckBox from "@/components/Shared/FormCheckBox.vue";

const regulations = () => {
  alert("Serio chciałeś przeczytać?");
};
</script>
