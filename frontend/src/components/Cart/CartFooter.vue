<template>
  <div
    v-if="isFooterVisible"
    class="mx-auto border-t border-gray-700 pt-3 w-full pr-2 cartFooter"
  >
    <div class="text-xl font-bold text-gray-900 mb-10">
      <p class="float-left">Podsuma:</p>
      <p class="float-right">{{ cartStore.cartTotal }} zł</p>
    </div>
    <action-button
      v-if="isOrderButtonActive"
      text="Zamów"
      type="order"
      @click="handleOrder"
    />
  </div>
</template>

<script lang="ts" setup>
import ActionButton from "@/components/Shared/ActionButton.vue";
import { useCartStore } from "@/store/CartStore";
import { useRouter, useRoute } from "vue-router";
import { computed } from "vue";

const router = useRouter();
const route = useRoute();
const cartStore = useCartStore();
const isFooterVisible = computed(() => {
  return cartStore.cartTotal > 0;
});
const isOrderButtonActive = computed(() => {
  return route.name == "shop" || route.name == "shopView";
});

function handleOrder() {
  cartStore.closeCart();
  router.push({ name: "order" });
}
</script>

<style scoped>
.cartFooter {
  flex: 0 0 auto;
}
</style>
