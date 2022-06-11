<template>
  <div class="h-5/6 md:max-h-7/12 overflow-y-scroll">
    <ul>
      <li v-for="cartItem in cartItems" :key="cartItem.id">
        <div
          class="inline-block w-full border-b border-gray-300 items-center text-center pr-2"
        >
          <div class="float-left w-4 align-top">
            <button @click="incrementProductQuantity(cartItem.id)">
              <font-awesome-icon :icon="['fas', 'angle-up']" class="h-4 w-4" />
            </button>

            <p class="text-center">{{ cartItem.quantity }}</p>

            <button
              :disabled="cartItem.quantity < 2"
              class="disabled:text-gray-300"
              @click="decrementProductQuantity(cartItem.id)"
            >
              <font-awesome-icon
                :icon="['fas', 'angle-down']"
                class="h-4 w-4"
              />
            </button>
          </div>
          <div class="float-left pt-4 pl-2">
            <img :src="cartItem.image" class="h-10 w-10" />
          </div>
          <div class="float-left w-24 pt-3 text-xs ml-2">
            {{ cartItem.name }}
          </div>
          <div class="float-right pl-1 first-line:text-xs pt-6">
            {{ (cartItem.quantity * cartItem.price).toFixed(2) }} zł
          </div>
          <div
            class="float-left ml-4 pt-4 right-9"
            @click="removeItemFromCart(cartItem.id)"
          >
            <action-button text="×" type="close2" />
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import ActionButton from "@/components/Shared/ActionButton.vue";
import { mapState, mapGetters } from "vuex";

export default {
  name: "ProductListingCart",
  components: {
    ActionButton,
  },
  computed: {
    ...mapGetters(["cartTotal"]),
    ...mapState(["cartItems", "isCartVisible"]),
  },
  methods: {
    incrementProductQuantity(id) {
      this.$store.dispatch("incrementProductQuantity", id);
    },
    decrementProductQuantity(id) {
      this.$store.dispatch("decrementProductQuantity", id);
    },
    removeItemFromCart(id) {
      this.$store.dispatch("removeItemFromCart", id);
    },
  },
};
</script>

<style></style>
