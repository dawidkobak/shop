import axios from "axios";

import type { LatLng } from "@/services/types";

const restClient = axios.create({
  baseURL: "http://localhost:9000",
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
  return restClient.get("/client/checkLocation", {
    params: {
      city: city,
      street: street,
      streetNumber: streetNumber,
    },
  });
};

const getRoute = (shopCoordinates: LatLng, clientCoordinates: LatLng) => {
  return restClient.get("/client/checkRoute", {
    params: {
      shopLat: shopCoordinates.lat,
      shopLng: shopCoordinates.lng,
      clientLat: clientCoordinates.lat,
      clientLng: clientCoordinates.lng,
    },
  });
};

export default { getClientLocation, getRoute };
