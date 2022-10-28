import { defineStore } from "pinia";

export const useOrderStore = defineStore({
  id: "OrderStore",
  state: () => ({
    _firstName: localStorage.getItem("firstName") ?? "",
    _lastName: localStorage.getItem("lastName") ?? "",
    _street: localStorage.getItem("street") ?? "",
    _streetNumber: localStorage.getItem("streetNumber") ?? "",
    _postalCode: localStorage.getItem("postalCode") ?? "",
    _city: localStorage.getItem("city") ?? "",
    _flatNumber: localStorage.getItem("flatNumber") ?? "",
    _phoneNumber: localStorage.getItem("phoneNumber") ?? "",
    _email: localStorage.getItem("email") ?? "",
    _notes: localStorage.getItem("notes") ?? "",
    _paymentType: localStorage.getItem("paymentType" ?? ""),
  }),
  getters: {
    firstName: (state) => state._firstName,
    lastName: (state) => state._lastName,
    street: (state) => state._street,
    streetNumber: (state) => state._streetNumber,
    postalCode: (state) => state._postalCode,
    city: (state) => state._city,
    flatNumber: (state) => state._flatNumber,
    phoneNumber: (state) => state._phoneNumber,
    email: (state) => state._email,
    notes: (state) => state._notes,
    paymentType: (state) => state._paymentType,
  },
  actions: {
    setFristName(firstName) {
      localStorage.setItem("firstName", firstName);
      this._firstName = firstName;
    },

    setLastName(lastName) {
      localStorage.setItem("lastName", lastName);
      this._lastName = lastName;
    },

    setStreet(street) {
      localStorage.setItem("street", street);
      this._street = street;
    },

    setStreetNumber(streetNumber) {
      localStorage.setItem("streetNumber", streetNumber);
      this._streetNumber = streetNumber;
    },

    setPostalCode(postalCode) {
      localStorage.setItem("postalCode", postalCode);
      this._postalCode = postalCode;
    },

    setCity(city) {
      localStorage.setItem("city", city);
      this._city = city;
    },

    setFlatNumber(flatNumber) {
      localStorage.setItem("flatNumber", flatNumber);
      this._flatNumber = flatNumber;
    },

    setPhoneNumber(phoneNumber) {
      localStorage.setItem("phoneNumber", phoneNumber);
      this._phoneNumber = phoneNumber;
    },

    setEmail(email) {
      localStorage.setItem("email", email);
      this._email = email;
    },

    setNotes(notes) {
      localStorage.setItem("notes", notes);
      this._notes = notes;
    },

    setPaymentType(paymentType) {
      localStorage.setItem("paymentType", paymentType);
      this._paymentType = paymentType;
    },
  },
});
