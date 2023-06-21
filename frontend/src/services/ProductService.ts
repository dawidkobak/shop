import axios from "axios";
import type { Product } from "@/services/types";

const restClient = axios.create({
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-type": "application/json",
  },
});

const getAllProducts = () => {
  const productApi = import.meta.env.VITE_PRODUCT_API;
  return restClient.get(`${productApi}products.json`);
};

export { getAllProducts };
