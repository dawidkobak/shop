<template>
  <div class="">
    <fieldset class="block mt-4 pl-2.5">
      <legend class="text-2xl">Metoda płatności</legend>
      <form-radio
        id="cdfPaymentCash"
        name="cdfPayment"
        label="Gotówką przy odbiorze"
      ></form-radio>
      <form-radio
        id="cdfPaymentCard"
        name="cdfPayment"
        label="Kartą przy odbiorze"
      ></form-radio>
      <form-radio
        id="cdfPaymentPayU"
        name="cdfPayment"
        label="Płatność online PayU"
      ></form-radio>
    </fieldset>
  </div>
</template>

<script setup>
import FormRadio from "@/components/Order/FormRadioButton.vue";
</script>
