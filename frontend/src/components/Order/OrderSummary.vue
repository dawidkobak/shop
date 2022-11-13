<template>
  <div class="leading-8 text-center pb-10">
    <h1 class="text-3xl">Podsumowanie zamówienia</h1>
    <h2 class="text-2xl">Klient</h2>
    <h3>Imię: {{ props.data.client.firstName }}</h3>
    <h3>Nazwisko: {{ props.data.client.lastName }}</h3>
    <h3>Email: {{ props.data.client.email.address }}</h3>
    <h3>Numer telefonu: {{ props.data.client.phoneNumber.number }}</h3>
    <h2 class="text-2xl">Adres</h2>
    <h3>Miejscowość: {{ props.data.client.address.city }}</h3>
    <h3>Ulica: {{ props.data.client.address.street }}</h3>
    <h3>Numer budynku: {{ props.data.client.address.streetNumber }}</h3>
    <h3>Numer mieszkania: {{ props.data.client.address.flatNumber }}</h3>
    <h2 class="text-2xl">Produkty</h2>
    <product-listing-order :items="props.data.items" />
    <h2 class="text-2xl leading-10">Suma: {{ calculateCartTotal() }} zł</h2>
    <h2 class="text-2xl leading-10">Płatność: {{ calculatePaymentType() }}</h2>
    <h2 class="text-2xl leading-10">Stan: {{ calculateOrderState() }}</h2>
    <h2 class="text-2xl leading-10">Notatki: {{ props.data.notes }}</h2>
  </div>
</template>

<script setup>
import ProductListingOrder from "@/components/Order/ProductListingOrder.vue";

const props = defineProps({
  data: {
    type: Object,
    required: true,
  },
});

function calculateCartTotal() {
  let sum = 0;
  props.data.items.forEach(
    (item) => (sum += item.quantity * item.product.price)
  );
  return sum.toFixed(2);
}

function calculatePaymentType() {
  if (props.data.paymentType === "Cash") {
    return "Gotówką przy odbiorze";
  } else if (props.data.paymentType === "CreditCard") {
    return "Kartą przy odbiorze";
  } else {
    return "PayU";
  }
}

function calculateOrderState() {
  if (props.data.state === "Accepted") {
    return "Przyjęte";
  } else if (props.data.state === "InProgress") {
    return "W realizacj";
  } else {
    return "W dostawie";
  }
}
</script>
