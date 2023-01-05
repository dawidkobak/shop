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
  getClientLocation(city, street, streetNumber) {
    return restClient.get("/client/checkLocation", {
      params: {
        city: city,
        street: street,
        streetNumber: streetNumber,
      },
    });
  },

  getRoute(shopCoordinates, clientCoordinates) {
    return restClient.get("/client/checkRoute", {
      params: {
        shopLat: shopCoordinates.lat,
        shopLng: shopCoordinates.lng,
        clientLat: clientCoordinates.lat,
        clientLng: clientCoordinates.lng,
      },
    });
  },
};
