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

const getProducts = (
  perPage: string,
  page: string,
  category: string,
  phrase: string
) => {
  return restClient.get<Product[]>("/product", {
    params: {
      perPage: perPage,
      page: page,
      categories: category,
      q: phrase,
    },
  });
};

const getAllProducts = () => {
  return restClient.get<Product[]>("/allProducts");
};

export { getProducts, getAllProducts };
