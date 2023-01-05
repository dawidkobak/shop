import { defineStore } from "pinia";

export const useCartStore = defineStore({
  id: "CartStore",

  state: () => ({
    _cartItems: localStorage.getItem("cartItems") ?? [],
    _isCartVisible: localStorage.getItem("isCartVisible") ?? false,
  }),

  getters: {
    cartItems: (state) => state._cartItems,
    isCartVisible: (state) => state._isCartVisible,
    itemsInCart: (state) => {
      return state._cartItems.length;
    },
    cartTotal: (state) => {
      let sum = 0;
      state._cartItems.forEach((item) => (sum += item.price * item.quantity));
      return sum.toFixed(2);
    },
  },

  actions: {
    setCartItems(cartItems) {
      //localStorage.setItem("cartItems", JSON.stringify(cartItems));
      this._cartItems = cartItems;
    },

    setCartVisibility(isCartVisible) {
      localStorage.setItem("isCartVisible", isCartVisible);
      this._isCartVisible = isCartVisible;
    },

    addProductToCart(product) {
      const alreadyInCart = this._cartItems.findIndex(
        (item) => item.id === product.id
      );
      if (alreadyInCart >= 0) {
        this._cartItems[alreadyInCart].quantity++;
      } else {
        this._cartItems.push({
          ...product,
          quantity: 1,
        });
      }
    },

    removeProductFromCart(productId) {
      const productToRemoveIndex = this._cartItems.findIndex(
        (item) => item.id === productId
      );
      if (productToRemoveIndex >= 0) {
        this._cartItems.splice(productToRemoveIndex, 1);
      }
    },

    incrementProductQuantity(productId) {
      const product = this._cartItems.find((item) => item.id === productId);
      if (product) {
        product.quantity++;
      }
    },

    decrementProductQuantity(productId) {
      const product = this._cartItems.find((item) => item.id === productId);
      if (product.quantity >= 2) {
        product.quantity--;
      }
    },

    showCart() {
      this._isCartVisible = true;
    },

    closeCart() {
      this._isCartVisible = false;
    },
  },
});
