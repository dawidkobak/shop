import { defineStore } from "pinia";
import { ref } from "vue";

export const useOrderStore = defineStore("orders", () => {
  const firstName = ref(localStorage.getItem("firstName") ?? "");
  const lastName = ref(localStorage.getItem("lastName") ?? "");
  const street = ref(localStorage.getItem("street") ?? "");
  const streetNumber = ref(localStorage.getItem("streetNumber") ?? "");
  const postalCode = ref(localStorage.getItem("postalCode") ?? "");
  const city = ref(localStorage.getItem("city") ?? "");
  const flatNumber = ref(localStorage.getItem("flatNumber") ?? "");
  const phoneNumber = ref(localStorage.getItem("phoneNumber") ?? "");
  const email = ref(localStorage.getItem("email") ?? "");
  const notes = ref(localStorage.getItem("notes") ?? "");
  const paymentType = ref(localStorage.getItem("paymentType") ?? "");

  const currentOrder = ref(localStorage.getItem("currentOrder" ?? "{}"));

  const setCurrentOrder = (value: string) => {
    localStorage.setItem("currentOrder", value);
    currentOrder.value = value;
  };

  const setFristName = (value: string) => {
    localStorage.setItem("firstName", value);
    firstName.value = value;
  };

  const setLastName = (value: string) => {
    localStorage.setItem("lastName", value);
    lastName.value = value;
  };

  const setStreet = (value: string) => {
    localStorage.setItem("street", value);
    street.value = value;
  };

  const setStreetNumber = (value: string) => {
    localStorage.setItem("streetNumber", value);
    streetNumber.value = value;
  };

  const setPostalCode = (value: string) => {
    localStorage.setItem("postalCode", value);
    postalCode.value = value;
  };

  const setCity = (value: string) => {
    localStorage.setItem("city", value);
    city.value = value;
  };

  const setFlatNumber = (value: string) => {
    localStorage.setItem("flatNumber", value);
    flatNumber.value = value;
  };

  const setPhoneNumber = (value: string) => {
    localStorage.setItem("phoneNumber", value);
    phoneNumber.value = value;
  };

  const setEmail = (value: string) => {
    localStorage.setItem("email", value);
    email.value = value;
  };

  const setNotes = (value: string) => {
    localStorage.setItem("notes", value);
    notes.value = value;
  };

  const setPaymentType = (value: string) => {
    localStorage.setItem("paymentType", value);
    paymentType.value = value;
  };

  return {
    firstName,
    lastName,
    street,
    streetNumber,
    postalCode,
    city,
    flatNumber,
    phoneNumber,
    email,
    notes,
    paymentType,
    setFristName,
    setLastName,
    setStreet,
    setStreetNumber,
    setPostalCode,
    setCity,
    setFlatNumber,
    setPhoneNumber,
    setEmail,
    setNotes,
    setPaymentType,
    currentOrder,
    setCurrentOrder,
  };
});
