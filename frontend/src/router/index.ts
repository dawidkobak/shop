import { createRouter, createWebHistory } from "vue-router";
import ShopView from "@/views/ShopView.vue";
import OrderView from "@/views/OrderView.vue";
import OrderDelivery from "@/views/OrderDelivery.vue";

const routes = [
  {
    path: "/shop",
    name: "shop",
    component: ShopView,
  },
  {
    path: "/",
    component: ShopView,
  },
  {
    path: "/shop/app",
    redirect: {
      name: "shop",
    },
  },
  {
    path: "/shop/app/index.html",
    redirect: {
      name: "shop",
    },
  },
  {
    path: "/order",
    name: "order",
    component: OrderView,
  },
  {
    path: "/orderDelivery/:orderId",
    name: "orderDelivery",
    component: OrderDelivery,
    props: true,
  },
  {
    path: "/:pathMatch(.*)*",
    name: "NotFound",
    component: ShopView,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
  scrollBehavior() {
    return {
      top: 0,
      left: 0,
      behavior: "smooth",
    };
  },
});

export default router;
