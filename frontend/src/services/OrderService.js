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
  createOrder() {
    return restClient.post("/order", {
      params: {
        city: "city",
        street: "street",
        streetNumber: "streetNumber",
      },
    });
  },
};
