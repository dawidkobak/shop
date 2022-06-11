<template>
  <div class="border-b border-gray-700 pb-2">
    <span class="text-xl font-bold text-gray-900">
      {{ cartItems.length }} {{ productCaption() }}
    </span>
    <font-awesome-icon
      :icon="['fas', 'x']"
      class="hover:cursor-pointer h-5 w-5 float-right pt-2 text-red-500 pr-1"
      @click="closeCart()"
    />
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
  name: "CartHeader",
  computed: {
    ...mapState(["cartItems"]),
    ...mapActions(["closeCart"]),
  },
  methods: {
    productCaption() {
      if (this.cartItems.length === 1) return "produkt";
      else if (
        this.cartItems.length === 2 ||
        this.cartItems.length === 3 ||
        this.cartItems.length === 4
      )
        return "produkty";
      else return "produtków";
    },
  },
};
</script>
