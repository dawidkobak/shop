<template>
  <div class="sm:h-82 rounded shadow-lg text-center">
    <product-details
      :isVisible="areDetailsVisible"
      :product-object="props.productObject"
      @close="closeProductDetails"
    ></product-details>
    <img
      class="w-28 h-28 sm:w-40 sm:h-40 mr-auto ml-auto hover:cursor-pointer"
      :src="productObject.image"
      :alt="productObject.name"
      @click="showDetails"
    />
    <div class="sm:px-6 sm:py-4">
      <div class="font-bold text-xl mb-2">
        {{ productObject.name }}
      </div>
      <p class="text-gray-700 text-base">{{ productObject.price }} zł</p>
    </div>

    <div class="sm:px-6 px-2 pt-4 pb-2 sm:text-base text-sm">
      <button
        v-show="product.quantity > 0"
        class="rounded-md bg-red-500 px-1"
        @click="removeOneFromCart"
      >
        <font-awesome-icon icon="minus" />
      </button>

      <span v-show="product.quantity > 0" class="mx-1">
        {{ product.quantity }} w koszyku
      </span>

      <button
        v-show="product.quantity === 0"
        class="rounded-md px-1 bg-brand-gray-1"
        @click="addToCart"
      >
        <font-awesome-icon icon="shopping-cart" class="mr-1" />Do koszyka
      </button>

      <button
        v-show="product.quantity > 0"
        class="rounded-md bg-green-500 px-1"
        @click="addToCart"
      >
        <font-awesome-icon icon="plus" />
      </button>
    </div>
  </div>
</template>

<script lang="ts" setup>
import ProductDetails from "@/components/Product/ProductDetails.vue";
import { ref } from "vue";
import { computed } from "@vue/reactivity";
import { useCartStore } from "@/store/CartStore";

const props = defineProps({
  productObject: {
    type: Object,
    required: true,
  },
});

const cartStore = useCartStore();
let areDetailsVisible = ref(false);

const product = computed(() => {
  const item = cartStore.cartItems.find(
    (element) => element.id === props.productObject._id
  );
  if (item) {
    return item;
  } else {
    return {
      id: props.productObject._id,
      name: props.productObject.name,
      price: props.productObject.price,
      image: props.productObject.image,
      description: props.productObject.description,
      quantity: 0,
    };
  }
});

function addToCart() {
  cartStore.addProductToCart(product.value);
}

function removeOneFromCart() {
  if (product.value.quantity > 1) {
    cartStore.decrementProductQuantity(product.value.id);
  } else {
    cartStore.removeProductFromCart(product.value.id);
  }
}

function showDetails() {
  areDetailsVisible.value = true;
}

function closeProductDetails() {
  areDetailsVisible.value = false;
}
</script>
