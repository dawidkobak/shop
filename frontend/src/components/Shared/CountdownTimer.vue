<template>
  <div id="timer">
    <div v-if="timePassed <= props.fullTime" class="base-timer mx-auto">
      <svg
        class="base-timer__svg"
        viewBox="0 0 100 100"
        xmlns="http://www.w3.org/2000/svg"
      >
        <g class="base-timer__circle">
          <circle
            class="base-timer__path-elapsed"
            cx="50"
            cy="50"
            r="45"
          ></circle>
          <path
            id="base-timer-path-remaining"
            :stroke-dasharray="currentStrokeDasharray"
            :class="['base-timer__path-remaining', remainingPathColor]"
            d="
          M 50, 50
          m -45, 0
          a 45,45 0 1,0 90,0
          a 45,45 0 1,0 -90,0
        "
          ></path>
        </g>
      </svg>
      <span id="base-timer-label" class="base-timer__label">{{
        formatTime(timeLeft())
      }}</span>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ref, computed, onMounted, onBeforeUnmount, watch } from "vue";

const props = defineProps({
  fullTime: {
    type: Number,
    required: true,
  },
});

const FULL_DASH_ARRAY = 283;
const timePassed = ref(0);
const timerInterval = ref<ReturnType<typeof setInterval>>();

const remainingPathColor = computed(() => {
  if (remainingTimeInPercent() > 50) {
    return "green";
  } else if (remainingTimeInPercent() > 25) {
    return "orange";
  } else {
    return "red";
  }
});

const currentStrokeDasharray = computed(() => {
  return (remainingTimeInPercent() * FULL_DASH_ARRAY) / 100 + " 283";
});

watch(timePassed, () => {
  if (timePassed.value == props.fullTime) {
    emit("countingOver");
  }
});

onMounted(() => {
  timerInterval.value = setInterval(() => {
    timePassed.value += 1;

    if (timeLeft() <= 0) {
      clearInterval(timerInterval.value);
    }
  }, 1000);
});

onBeforeUnmount(() => {
  clearInterval(timerInterval.value);
});

const timeLeft = () => {
  return props.fullTime - timePassed.value;
};

const formatTime = (time: number) => {
  const minutes = Math.floor(time / 60);
  return `${minutes} min`;
};

const remainingTimeInPercent = () => {
  return 100 - (timePassed.value / props.fullTime) * 100;
};

const emit = defineEmits(["countingOver"]);
</script>

<style scoped>
.base-timer {
  width: 150px;
  height: 150px;
}

.base-timer__svg {
  transform: scaleX(-1);
}

.base-timer__circle {
  fill: none;
  stroke: none;
}

.base-timer__path-elapsed {
  stroke-width: 7px;
  stroke: grey;
}

.base-timer__path-remaining {
  stroke-width: 7px;
  stroke-linecap: round;
  transform: rotate(90deg);
  transform-origin: center;
  transition: 1s linear all;
  fill-rule: nonzero;
  stroke: currentColor;
}

.base-timer__label {
  position: absolute;
  width: 150px;
  height: 150px;
  top: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 32px;
}

.green {
  color: rgb(42, 255, 42);
}

.orange {
  color: orange;
}

.red {
  color: red;
}
</style>
