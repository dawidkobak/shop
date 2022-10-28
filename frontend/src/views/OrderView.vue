<template>
  <div
    class="max-w-md left-0 right-0 pl-10 pr-10 pt-10 pb-2"
    style="margin: 0 auto"
  >
    <order-form />
    <div class="mt-10">
      <p class="text-2xl">
        Wartość koszyka:
        <span class="text-3xl">{{ cartStore.cartTotal }} zł</span>
      </p>
    </div>
    <div v-if="cartStore.cartTotal > 0" class="mt-4 mb-8">
      <action-button
        type="order"
        text="Kupuję i płacę"
        @click="handleOrder"
      ></action-button>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import ActionButton from "@/components/Shared/ActionButton.vue";
import OrderForm from "@/components/Order/OrderForm.vue";
import { useCartStore } from "@/store/CartStore";
import { useOrderStore } from "@/store/OrderStore";
import OrderService from "@/services/OrderService";

const router = useRouter();
const cartStore = useCartStore();
const orderStore = useOrderStore();

function handleOrder() {
  OrderService.createOrder();
  router.push({
    name: "orderDelivery",
    query: {
      city: orderStore.city,
      street: orderStore.street,
      streetNumber: orderStore.streetNumber,
    },
  });
  cartStore.setCartItems([]);
}
</script>
