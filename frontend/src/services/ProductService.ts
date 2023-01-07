import axios from "axios";

import type { Product } from "@/services/types";

const restClient = axios.create({
  baseURL: "http://localhost:9000",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-type": "application/json",
  },
});

const getAllProducts = () => {
  return restClient.get<Product[]>("/product");
};

export { getAllProducts };
