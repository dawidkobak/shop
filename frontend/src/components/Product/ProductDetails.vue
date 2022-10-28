<template>
  <my-modal>
    <div
      v-if="props.isVisible"
      class="fixed inset-0 w-full flex justify-center bg-semi-05"
      @click.stop.self="close"
    >
      <div class="absolute self-center bg-white p-10 rounded-xl z-10">
        <div>
          <font-awesome-icon
            :icon="['fas', 'x']"
            class="hover:cursor-pointer h-5 w-5 float-right text-red-500"
            @click.stop.self="close"
          />
        </div>
        <img
          class="w-64 h-64 sm:w-80 sm:h-80 mr-auto ml-auto"
          :src="productObject.image"
          :alt="productObject.name"
        />
        <div class="px-6 py-4">
          <div class="font-bold text-xl mb-2">
            {{ productObject.name }}
          </div>
          <p class="text-gray-700 text-base">{{ productObject.price }} zł</p>
        </div>
        <p>{{ productObject.description }}</p>
        <div class="px-6 pt-4 pb-2">
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
    </div>
  </my-modal>
</template>

<script setup>
import MyModal from "@/components/Shared/MyModal.vue";
import { computed } from "@vue/reactivity";
import { useCartStore } from "@/store/CartStore";

const props = defineProps({
  productObject: {
    type: Object,
    required: true,
  },
  isVisible: {
    type: Boolean,
    required: true,
  },
});

const emit = defineEmits(["close"]);

function close() {
  emit("close");
}

const cartStore = useCartStore();

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
</script>
