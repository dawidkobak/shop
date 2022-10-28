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
  getProducts(perPage, page, category, phrase) {
    return restClient.get("/product", {
      params: {
        perPage: perPage,
        page: page,
        categories: category,
        q: phrase,
      },
    });
  },
};
