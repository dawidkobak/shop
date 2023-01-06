import { defineStore } from "pinia";
import { computed, ref } from "vue";

import type { CartItem } from "@/store/types";
import type { Product } from "@/services/types";

export const useCartStore = defineStore("cart", () => {
  const cartItems = ref<CartItem[]>([]);
  const isCartVisible = ref(false);

  const itemsInCart = computed(() => {
    return cartItems.value.length;
  });

  const cartTotal = computed(() => {
    let sum = 0;
    cartItems.value.forEach((item) => (sum += item.price * item.quantity));
    return sum.toFixed(2);
  });

  const setCartItems = (items: CartItem[]) => {
    cartItems.value = items;
  };

  const setCartVisibility = (isVisible: boolean) => {
    isCartVisible.value = isVisible;
  };

  const addProductToCart = (product: Product) => {
    const alreadyInCart = cartItems.value.findIndex(
      (item) => item._id === product._id
    );
    if (alreadyInCart >= 0) {
      cartItems.value[alreadyInCart].quantity++;
    } else {
      cartItems.value.push({
        ...product,
        quantity: 1,
      });
    }
  };

  const removeProductFromCart = (productId: string) => {
    const productToRemoveIndex = cartItems.value.findIndex(
      (item) => item._id === productId
    );
    if (productToRemoveIndex >= 0) {
      cartItems.value.splice(productToRemoveIndex, 1);
    }
  };

  const incrementProductQuantity = (productId: string) => {
    const product = cartItems.value.find((item) => item._id === productId);
    if (product) {
      product.quantity++;
    }
  };

  const decrementProductQuantity = (productId: string) => {
    const product = cartItems.value.find((item) => item._id === productId);
    if (product && product.quantity >= 2) {
      product.quantity--;
    }
  };

  const showCart = () => {
    isCartVisible.value = true;
  };

  const closeCart = () => {
    isCartVisible.value = false;
  };

  return {
    cartItems,
    isCartVisible,
    itemsInCart,
    cartTotal,
    setCartItems,
    setCartVisibility,
    addProductToCart,
    removeProductFromCart,
    incrementProductQuantity,
    decrementProductQuantity,
    showCart,
    closeCart,
  };
});
