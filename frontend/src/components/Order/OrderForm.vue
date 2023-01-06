<template>
  <form @submit.prevent="handleOrder">
    <client-data />
    <payment-type />
    <client-consents />
    <div class="mt-10">
      <p class="text-2xl">
        Wartość koszyka:
        <span class="text-3xl">{{ cartStore.cartTotal.toFixed(2) }} zł</span>
      </p>
    </div>
    <div v-if="cartStore.cartTotal > 0" class="mt-4 mb-8">
      <action-button type="order" text="Kupuję i płacę"></action-button>
    </div>
  </form>
</template>

<script lang="ts" setup>
import ClientData from "@/components/Order/ClientData.vue";
import PaymentType from "@/components/Order/PaymentType.vue";
import ClientConsents from "@/components/Order/ClientConsents.vue";
import ActionButton from "@/components/Shared/ActionButton.vue";
import { useRouter } from "vue-router";
import { useCartStore } from "@/store/CartStore";
import { useOrderStore } from "@/store/OrderStore";
import OrderService from "@/services/OrderService";

const router = useRouter();
const cartStore = useCartStore();
const orderStore = useOrderStore();

async function handleOrder() {
  const order = await createOrder();
  router.push({
    name: "orderDelivery",
    params: {
      orderId: order.data._id,
    },
  });
  cartStore.setCartItems([]);
}

function createOrder() {
  const client = {
    firstName: orderStore.firstName,
    lastName: orderStore.lastName,
    email: {
      address: orderStore.email,
    },
    phoneNumber: {
      number: orderStore.phoneNumber,
    },
    address: {
      city: orderStore.city,
      street: orderStore.street,
      streetNumber: parseInt(orderStore.streetNumber),
      flatNumber: parseInt(orderStore.flatNumber),
    },
  };

  const items = cartStore.cartItems.map((item) => ({
    product: {
      _id: item._id,
      name: item.name,
      price: item.price,
      image: item.image,
      description: item.description,
      categories: [],
    },
    quantity: item.quantity,
  }));

  return OrderService.createOrder(
    client,
    items,
    orderStore.notes,
    orderStore.paymentType
  );
}
</script>

<style></style>
