<template>
  <MyModal>
    <div
      v-if="cartStore.isCartVisible"
      class="fixed inset-0 w-full flex justify-center bg-semi-05"
      @click.self="close"
    >
      <div
        class="absolute right-0 w-full h-full max-w-xs bg-white shadow-lg rounded-lg p-4"
      >
        <div class="flex flex-col h-full">
          <cart-header />
          <product-listing-cart />
          <cart-footer />
        </div>
      </div>
    </div>
  </MyModal>
</template>

<script lang="ts" setup>
import MyModal from "@/components/Shared/MyModal.vue";
import CartHeader from "@/components/Cart/CartHeader.vue";
import CartFooter from "@/components/Cart/CartFooter.vue";
import ProductListingCart from "@/components/Cart/ProductListingCart.vue";
import { useCartStore } from "@/store/CartStore";

const cartStore = useCartStore();

function close() {
  cartStore.closeCart();
}
</script>
