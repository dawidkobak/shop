<template>
  <div style="margin: 0 auto">
    <h1 class="text-3xl">Podsumowanie zamówienia</h1>
    <h2 class="text-2xl">Klient</h2>
    <h3>Imię: {{ props.data.client.firstName }}</h3>
    <h3>Nazwisko: {{ props.data.client.lastName }}</h3>
    <h3>Email: {{ props.data.client.email.address }}</h3>
    <h3>Number telefonu: {{ props.data.client.phoneNumber.number }}</h3>
    <h2 class="text-2xl">Adres</h2>
    <h3>Miejscowość: {{ props.data.client.address.city }}</h3>
    <h3>Ulica: {{ props.data.client.address.street }}</h3>
    <h3>Numer budynku: {{ props.data.client.address.streetNumber }}</h3>
    <h3>Numer mieszkania: {{ props.data.client.address.flatNumber }}</h3>
    <h2 class="text-2xl">Produkty</h2>
    <div v-for="(product, index) in props.data.items" :key="product._id">
      {{ index }}
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  data: {
    type: Object,
    required: true,
  },
});
</script>
