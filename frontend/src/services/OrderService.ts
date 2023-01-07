import axios from "axios";

import type { Client, OrderItem } from "@/services/types";
import type { CartItem } from "@/stores/types";

const restClient = axios.create({
  baseURL: "http://localhost:9000",
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
    return restClient.post("/order", {
      client: client,
      items: items,
      notes: notes,
      paymentType: paymentType,
    });
  },

  getOrder(id: string) {
    return restClient.get(`/order/${id}`);
  },
};
