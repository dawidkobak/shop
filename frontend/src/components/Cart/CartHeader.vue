<template>
  <div class="border-b border-gray-700 pb-2">
    <span class="text-xl font-bold text-gray-900">
      {{ cartStore.itemsInCart }} {{ productCaption() }}
    </span>
    <font-awesome-icon
      :icon="['fas', 'x']"
      class="hover:cursor-pointer h-5 w-5 float-right pt-2 text-red-500 pr-1"
      @click="cartStore.closeCart()"
    />
  </div>
</template>

<script lang="ts" setup>
import { useCartStore } from "@/store/CartStore";

const cartStore = useCartStore();

function productCaption() {
  if (cartStore.cartItems.length === 1) return "produkt";
  else if (
    cartStore.cartItems.length === 2 ||
    cartStore.cartItems.length === 3 ||
    cartStore.cartItems.length === 4
  )
    return "produkty";
  else return "produtków";
}
</script>
