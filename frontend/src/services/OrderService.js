import axios from "axios";

const restClient = axios.create({
  baseURL: "http://localhost:9000",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-type": "application/json",
  },
});

export default {
  createOrder(client, items, notes, paymentType) {
    return restClient.post("/order", {
      client: client,
      items: items,
      notes: notes,
      paymentType: paymentType,
    });
  },

  getOrder(id) {
    return restClient.get(`/order/${id}`);
  },
};
