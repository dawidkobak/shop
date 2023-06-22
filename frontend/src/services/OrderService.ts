import axios from "axios";

import type { Client, OrderItem } from "@/services/types";
import type { CartItem } from "@/stores/types";

import { useOrderStore } from "@/stores/orders";

const orderApiUrl = import.meta.env.VITE_ORDER_API_URL;

const restClient = axios.create({
  baseURL: orderApiUrl,
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-type": "application/json",
  },
});

export default {
  createOrder(
    client: Client,
    items: CartItem[],
    notes: string,
    paymentType: string
  ) {
    //   return restClient.post("/order", {
    //     client: client,
    //     items: items,
    //     notes: notes,
    //     paymentType: paymentType,
    //   });
    // },

    const order = {
      _id: "f1f563747vc6xhzvxzc",
      client,
      items,
      notes,
      paymentType,
      state: "InDelivery",
      shipmentType: "Delivery",
    };
    const orderStore = useOrderStore();

    orderStore.setCurrentOrder(JSON.stringify(order));
    const response = {
      data: order,
    };
    return response;
  },

  getOrder(id: string) {
    const orderStore = useOrderStore();
    const order = JSON.parse(orderStore.currentOrder ?? "{}");
    return {
      data: order,
    };
  },

  // getOrder(id: string) {
  //   return restClient.get(`/order/${id}`);
  // },
};
