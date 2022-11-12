<template>
  <form @submit.prevent="handleOrder">
    <client-data-form />
    <payment-form />
    <client-consents />
    <div class="mt-10">
      <p class="text-2xl">
        Wartość koszyka:
        <span class="text-3xl">{{ cartStore.cartTotal }} zł</span>
      </p>
    </div>
    <div v-if="cartStore.cartTotal > 0" class="mt-4 mb-8">
      <action-button type="order" text="Kupuję i płacę"></action-button>
    </div>
  </form>
</template>

<script setup>
import ClientDataForm from "@/components/Order/ClientDataForm.vue";
import PaymentForm from "@/components/Order/PaymentForm.vue";
import ClientConsents from "@/components/Order/ClientConsents.vue";
import ActionButton from "@/components/Shared/ActionButton.vue";
import { useRouter } from "vue-router";
import { useCartStore } from "@/store/CartStore";
import { useOrderStore } from "@/store/OrderStore";
import OrderService from "@/services/OrderService";

const router = useRouter();
const cartStore = useCartStore();
const orderStore = useOrderStore();

function handleOrder() {
  createOrder();
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
      _id: item.id,
      name: item.name,
      price: item.price,
      image: item.image,
      description: item.description,
      categories: [],
    },
    quantity: item.quantity,
  }));

  OrderService.createOrder(
    client,
    items,
    orderStore.notes,
    orderStore.paymentType
  );
}
</script>

<style></style>
