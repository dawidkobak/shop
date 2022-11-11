<template>
  <div class="">
    <div class="w-full">
      <form-input
        :value="orderStore.firstName"
        label="Imię"
        :obligatory="true"
        @updated-input="(firstName) => orderStore.setFristName(firstName)"
      ></form-input>
      <form-input
        :value="orderStore.lastName"
        label="Nazwisko"
        :obligatory="true"
        @updated-input="(lastName) => orderStore.setLastName(lastName)"
      ></form-input>
      <form-input
        :value="orderStore.city"
        label="Miejscowość"
        :obligatory="true"
        @updated-input="(value) => orderStore.setCity(value)"
      ></form-input>
      <form-input
        :value="orderStore.streetNumber"
        label="Numer budynku"
        :obligatory="true"
        @updated-input="(value) => orderStore.setStreetNumber(value)"
      ></form-input>
      <form-input
        :value="orderStore.street"
        label="Ulica (opcjonalnie)"
        @updated-input="(value) => orderStore.setStreet(value)"
      ></form-input>
      <form-input
        :value="orderStore.flatNumber"
        label="Number mieszkania (opcjonalne)"
        @updated-input="(value) => orderStore.setFlatNumber(value)"
      ></form-input>
      <form-input
        :value="orderStore.phoneNumber"
        label="Numer telefonu"
        type="tel"
        :obligatory="true"
        @updated-input="(value) => orderStore.setPhoneNumber(value)"
      ></form-input>
      <form-input
        :value="orderStore.email"
        label="Adres e-mail"
        type="email"
        :obligatory="true"
        @updated-input="(value) => orderStore.setEmail(value)"
      ></form-input>
      <form-input
        :value="orderStore.notes"
        label="Dodaj notatkę (opcjonalne)"
        placeholder="Np. uwagi dotyczące parkowania, wjazdu na osiedle itp."
        @updated-input="(value) => orderStore.setNotes(value)"
      ></form-input>
    </div>
  </div>
</template>

<script setup>
import FormInput from "@/components/Order/FormInput.vue";
import { useOrderStore } from "@/store/OrderStore";

const orderStore = useOrderStore();
</script>
