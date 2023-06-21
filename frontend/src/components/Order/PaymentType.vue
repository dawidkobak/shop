<template>
  <div class="">
    <fieldset class="block mt-8">
      <legend class="text-2xl">
        Metoda płatności
        <span class="text-red-800">*</span>
      </legend>
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

<script lang="ts" setup>
import FormRadio from "@/components/Shared/FormRadioButton.vue";
import { useOrderStore } from "@/stores/orders";

const orderStore = useOrderStore();
</script>
