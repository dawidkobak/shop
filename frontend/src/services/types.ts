export interface Product {
  _id: string;
  name: string;
  categories: string[];
  price: number;
  image: string;
  description: string;
}

export interface LatLng {
  lat: string;
  lng: string;
}

export interface OrderItem {
  product: Product;
  quantity: number;
}

export interface Client {
  firstName: string;
  lastName: string;
  email: {
    address: string;
  };
  phoneNumber: {
    number: string;
  };
  address: {
    city: string;
    street: string;
    streetNumber?: number;
    flatNumber?: number;
  };
}
