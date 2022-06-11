<template>
  <div class="flex items-center justify-center pl-10 pr-10 pt-2 pb-2">
    <form class="sm:w-full md:w-1/2 lg:w-1/2 xl:w-1/2">

      <div class="w-full">
        <form-input id="cdfFirstName" label="Imię"></form-input>
        <form-input id="cdfLastName" label="Nazwisko"></form-input>
        <form-input id="cdfStreetAndHouse" label="Ulica" placeholder="Nazwa ulicy, numer budynku / numer lokalu"></form-input>
        <form-input id="cdfPostalCode" label="Kod pocztowy"></form-input>
        <form-input id="cdfCity" label="Miasto"></form-input>
        <form-input id="cdfPhoneNumber" label="Numer telefonu" type="tel"></form-input>
        <form-input id="cdfMail" label="Adres e-mail" type="email"></form-input>
      </div>

      <div class="w-full">
        <div class="mt-4">
          <p class="text-2xl">
            Do zapłaty: <span class="text-3xl">{{ cartTotal }} zł</span>
          </p>
        </div>

        <fieldset class="block mt-4 pl-2.5">
          <legend class="text-sm">Metoda płatności</legend>
          <form-radio id="cdfPaymentCash" name="cdfPayment" label="Przy odbiorze"></form-radio>
          <form-radio id="cdfPaymentPayU" name="cdfPayment" label="Płatność online z PayU"></form-radio>
          <form-radio id="cdfPaymentCard" name="cdfPayment" label="Płatność online kartą"></form-radio>
        </fieldset>

        <div class="mt-4">
          <form-check-box id="cdfAcceptTerms" label="Przeczytałem/am i akceptuję regulamin"></form-check-box>
          <form-check-box id="cdfAcceptPrivacy" label="Przeczytałem/am i akceptuję politykę prywatności"></form-check-box>
        </div>

        <div class="mt-4 mb-8">
          <action-button type="order" text="Kupuję i płacę"></action-button>
        </div>

      </div>
    </form>
  </div>
</template>

<script>
import FormInput from "@/components/Order/FormInput";
import FormCheckBox from "@/components/Order/FormCheckBox";
import ActionButton from "@/components/Shared/ActionButton";
import FormRadio from "@/components/Order/FormRadioButton";
import { mapGetters } from "vuex";

export default {
  name: "ClientDataForm",
  components: { FormRadio, ActionButton, FormCheckBox, FormInput },
  computed: {
    ...mapGetters(["cartTotal"]),
  },
};
</script>

<style></style>
