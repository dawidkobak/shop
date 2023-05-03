<template>
  <dialog ref="dialog" @click="closeBoundary">
    <div>
      <button class="float-right">
        <font-awesome-icon
          :icon="['fas', 'x']"
          class="hover:cursor-pointer h-5 w-5 text-red-500"
          @click="close"
        />
      </button>
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
        formmethod="dialog"
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
        formmethod="dialog"
      >
        <font-awesome-icon icon="shopping-cart" class="mr-1" />Do koszyka
      </button>

      <button
        v-show="product.quantity > 0"
        class="rounded-md bg-green-500 px-1"
        @click="addToCart"
        formmethod="dialog"
      >
        <font-awesome-icon icon="plus" />
      </button>
    </div>
  </dialog>
</template>

<script lang="ts" setup>
import { computed } from "@vue/reactivity";
import { useCartStore } from "@/stores/cart";
import { ref, type Ref, type PropType, watch } from "vue";
import type { Product } from "@/services/types";

const props = defineProps({
  productObject: {
    type: Object as PropType<Product>,
    required: true,
  },
  isVisible: {
    type: Boolean,
    required: true,
  },
});

watch(
  () => props.isVisible,
  () => {
    if (props.isVisible) {
      dialog.value.showModal();
    } else {
      dialog.value.close();
    }
  }
);

const dialog = ref() as Ref<HTMLDialogElement>;

const emit = defineEmits(["close"]);

function close() {
  emit("close");
}

const cartStore = useCartStore();

const product = computed(() => {
  const item = cartStore.cartItems.find(
    (element) => element._id === props.productObject._id
  );
  if (item) {
    return item;
  } else {
    return {
      ...props.productObject,
      quantity: 0,
    };
  }
});

const closeBoundary = (e) => {
  const dialogDimensions = dialog.value.getBoundingClientRect();
  if (
    e.clientX < dialogDimensions.left ||
    e.clientX > dialogDimensions.right ||
    e.clientY < dialogDimensions.top ||
    e.clientY > dialogDimensions.bottom
  ) {
    close();
  }
};

function addToCart() {
  cartStore.addProductToCart(product.value);
}

function removeOneFromCart() {
  if (product.value.quantity > 1) {
    cartStore.decrementProductQuantity(product.value._id);
  } else {
    cartStore.removeProductFromCart(product.value._id);
  }
}
</script>
