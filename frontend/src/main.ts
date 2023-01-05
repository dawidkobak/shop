import { createApp } from "vue";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { library } from "@fortawesome/fontawesome-svg-core";
import {
  faSearch,
  faCartShopping,
  faPlus,
  faMinus,
  faAngleUp,
  faAngleDown,
  faX,
  faLocationCrosshairs,
  faHouseUser,
  faHouse,
  faLocationPin,
} from "@fortawesome/free-solid-svg-icons";

import App from "@/App.vue";
import router from "@/router";
import "@/assets/tailwind.css";

import { createPinia } from "pinia";
const pinia = createPinia();

library.add(
  faSearch,
  faCartShopping,
  faPlus,
  faMinus,
  faAngleUp,
  faAngleDown,
  faX,
  faLocationCrosshairs,
  faHouseUser,
  faHouse,
  faLocationPin
);

createApp(App)
  .use(pinia)
  .use(router)
  .component("font-awesome-icon", FontAwesomeIcon)
  .mount("#app");
