<template>
  <div class="overflow-auto listingMiddle">
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

<script lang="ts" setup>
import ActionButton from "@/components/Shared/ActionButton.vue";
import { useCartStore } from "@/store/CartStore";
import { reactive } from "vue";

const cartStore = useCartStore();
const cartItems = reactive(cartStore.cartItems);

function incrementProductQuantity(id) {
  this.cartStore.incrementProductQuantity(id);
}

function decrementProductQuantity(id) {
  this.cartStore.decrementProductQuantity(id);
}

function removeItemFromCart(id) {
  this.cartStore.removeProductFromCart(id);
}
</script>

<style scoped>
.listingMiddle {
  flex: 1;
}
</style>
