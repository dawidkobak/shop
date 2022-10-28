<template>
  <div id="timer" class="w-full">
    <div v-if="timePassed <= TIME_LIMIT" class="base-timer">
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

<script setup>
import { ref, computed, onMounted, onBeforeUnmount } from "vue";

const props = defineProps({
  fullTime: {
    type: Number,
    required: true,
  },
});

const FULL_DASH_ARRAY = 283;
const TIME_LIMIT = parseInt(props.fullTime);
const timePassed = ref(0);
const timerInterval = ref(null);

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
  return (
    parseInt((remainingTimeInPercent(timeLeft()) * FULL_DASH_ARRAY) / 100, 10) +
    " 283"
  );
});

onMounted(() => {
  timerInterval.value = setInterval(() => {
    timePassed.value += 1;
    setCircleDasharray();

    if (timeLeft() <= 0) {
      clearInterval(timerInterval.value);
    }
  }, 1000);
});

onBeforeUnmount(() => {
  clearInterval(timerInterval.value);
});

function timeLeft() {
  return TIME_LIMIT - timePassed.value;
}

function formatTime(time) {
  const minutes = Math.floor(time / 60);
  return `${minutes} min`;
}

function calculateTimeFraction() {
  const rawTimeFraction = timeLeft() / TIME_LIMIT;
  return -(1 / TIME_LIMIT) * (1 - rawTimeFraction);
}

function setCircleDasharray() {
  const circleDasharray = `${(
    calculateTimeFraction() * FULL_DASH_ARRAY.value
  ).toFixed(0)} 283`;
  document
    .getElementById("base-timer-path-remaining")
    .setAttribute("stroke-dasharray", circleDasharray);
}

function remainingTimeInPercent() {
  return 100 - (timePassed.value / TIME_LIMIT) * 100;
}
</script>

<style scoped>
.base-timer {
  position: absolute;
  width: 300px;
  height: 300px;
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
  width: 300px;
  height: 300px;
  top: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 48px;
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
