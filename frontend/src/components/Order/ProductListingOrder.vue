<template>
  <table class="mx-auto">
    <tr>
      <th>Lp</th>
      <th></th>
      <th>Nazwa</th>
      <th>Cena</th>
      <th>Ilość</th>
      <th>Wartość</th>
    </tr>
    <tr v-for="(item, index) in props.items" :key="item.product._id">
      <td>{{ index + 1 }}</td>
      <td>
        <img
          class="w-10 h-10"
          :src="item.product.image"
          :alt="item.product.name"
        />
      </td>
      <td>{{ item.product.name }}</td>
      <td>{{ item.product.price }} zł</td>
      <td>{{ item.quantity }}</td>
      <td>{{ (item.product.price * item.quantity).toFixed(2) }} zł</td>
    </tr>
  </table>
</template>

<script setup>
const props = defineProps({
  items: {
    type: Object,
    required: true,
  },
});
</script>

<style scoped>
table,
th,
td {
  border: 1px solid black;
  border-collapse: collapse;
  border-style: dotted;
}
</style>
