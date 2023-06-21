import axios from "axios";

import type { LatLng } from "@/services/types";

import { useOrderStore } from "@/stores/orders";

const clientApiUrl = import.meta.env.VITE_CLIENT_API_URL;

const restClient = axios.create({
  baseURL: clientApiUrl,
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-type": "application/json",
  },
});

const getClientLocation = (
  city: string,
  street: string,
  streetNumber: string
) => {
  // return restClient.get("/client/checkLocation", {
  //   params: {
  //     city: city,
  //     street: street,
  //     streetNumber: streetNumber,
  //   },
  // });
  return {
    data: {
      lat: 50.068521667536636,
      lng: 19.95388576690215,
    },
  };
};

const getRoute = (shopCoordinates: LatLng, clientCoordinates: LatLng) => {
  // return restClient.get("/client/checkRoute", {
  //   params: {
  //     shopLat: shopCoordinates.lat,
  //     shopLng: shopCoordinates.lng,
  //     clientLat: clientCoordinates.lat,
  //     clientLng: clientCoordinates.lng,
  //   },
  // });
  const clientApi = import.meta.env.VITE_CLIENT_API;
  return restClient.get(`${clientApi}route.json`);
};

export default { getClientLocation, getRoute };
