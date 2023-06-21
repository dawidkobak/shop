<template>
  <header>
    <div class="h-full bg-white">
      <div
        class="flex flex-nowrap h-full px-2 mx-auto border-b border-solid border-brand-gray-1"
      >
        <nav class="h-full w-full">
          <ul class="flex h-full w-full p-0 m-0 list-none md:text-xl">
            <li class="h-4/5 my-auto 2xl:w-24 w-16">
              <router-link :to="{ name: 'shop' }" class="h-full">
                <logo-shop />
              </router-link>
            </li>
            <li class="h-full xl:ml-9" data-test="shop-nav">
              <router-link
                :to="{ name: 'shop' }"
                class="flex items-center h-full py-2.5"
                >Sklep</router-link
              >
            </li>
            <li class="h-full ml-9 hidden sm:flex" data-test="order-nav">
              <router-link
                :to="{ name: 'order' }"
                class="flex items-center h-full py-2.5"
                >Zamówienie</router-link
              >
            </li>
            <li class="h-1/2 my-auto mx-2 xl:mx-8">
              <product-search-form />
            </li>
            <li class="absolute right-0 top-4 2xl:top-8 xl:right-3">
              <div
                class="flex items-center h-full hover:cursor-pointer"
                @click="showCart"
              >
                <cart-icon />
                <span
                  class="bg-brand-orange-1 text-black text-xs font-semibold px-1 py-0.5 rounded"
                  >{{ cartStore.itemsInCart }}</span
                >
              </div>
            </li>
          </ul>
        </nav>
      </div>
    </div>
  </header>
</template>

<script lang="ts" setup>
import ProductSearchForm from "@/components/Navigation/ProductSearchForm.vue";
import LogoShop from "@/components/Navigation/LogoShop.vue";
import CartIcon from "@/components/Cart/CartIcon.vue";
import { useCartStore } from "@/stores/cart";

const cartStore = useCartStore();

function showCart() {
  cartStore.showCart();
}
</script>

<style scoped>
span {
  position: relative;
  left: -10px;
  top: -10px;
}

header {
  @apply fixed w-full 2xl:text-lg text-sm 2xl:h-24 h-16;
}
</style>
