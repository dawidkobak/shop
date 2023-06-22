<template>
  <div class="leading-8 text-center pb-10 pt-5">
    <div class="w-96 mx-auto">
      <div class="mb-2 border-b-2">
        <h1 class="text-3xl">Podsumowanie zamówienia</h1>
      </div>

      <OrderSummaryDetails caption="Klient" :dataTuple="clientData" />

      <OrderSummaryDetails
        caption="Adres dostawy"
        :dataTuple="deliveryAddressData"
      />

      <div class="mt-2">
        <h2 class="text-2xl text-left">Produkty</h2>
        <product-listing-order :items="props.data.items" />
      </div>

      <OrderSummaryDetails :dataTuple="summaryData" />
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ref } from "vue";
import ProductListingOrder from "@/components/Order/ProductListingOrder.vue";
import OrderSummaryDetails from "@/components/Order/OrderSummaryDetails.vue";

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
  } else if (props.data.state === "InDelivery") {
    return "W drodze do Ciebie";
  } else {
    return "W realiacji";
  }
}

const clientData = ref([
  { caption: "Imię", value: props.data.client.firstName },
  { caption: "Nazwisko", value: props.data.client.lastName },
  { caption: "Email", value: props.data.client.email.address },
  { caption: "Numer telefonu", value: props.data.client.phoneNumber.number },
]);

const deliveryAddressData = ref([
  { caption: "Miejscowość", value: props.data.client.address.city },
  { caption: "Ulica", value: props.data.client.address.street },
  { caption: "Numer budynku", value: props.data.client.address.streetNumber },
  { caption: "Numer mieszkania:", value: props.data.client.address.flatNumber },
]);

const summaryData = ref([
  { caption: "Suma", value: calculateCartTotal() },
  { caption: "Płatność", value: calculatePaymentType() },
  { caption: "Stan", value: calculateOrderState() },
  { caption: "Notatki", value: props.data.notes },
]);
</script>
