<template>
  <div class="">
    <fieldset class="block mt-4 pl-2.5">
      <legend class="text-2xl">Metoda płatności</legend>
      <form-radio
        id="cdfPaymentCash"
        name="cdfPayment"
        label="Gotówką przy odbiorze"
        @change="orderStore.setPaymentType('Cash')"
      ></form-radio>
      <form-radio
        id="cdfPaymentCard"
        name="cdfPayment"
        label="Kartą przy odbiorze"
        @change="orderStore.setPaymentType('CreditCard')"
      ></form-radio>
      <form-radio
        id="cdfPaymentPayU"
        name="cdfPayment"
        label="Płatność online PayU"
        @change="orderStore.setPaymentType('PayU')"
      ></form-radio>
    </fieldset>
  </div>
</template>

<script setup>
import FormRadio from "@/components/Order/FormRadioButton.vue";
import { useOrderStore } from "@/store/OrderStore";

const orderStore = useOrderStore();
</script>
