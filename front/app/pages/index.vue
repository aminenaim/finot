<script setup lang="ts">
const input = ref<string>("");
const response = ref<string>("");
const runtimeConfig = useRuntimeConfig();
const send = async () => {
  response.value = await $fetch("/ai/hello", {
    baseURL: runtimeConfig.public.apiUrl,
    method: "POST",
    body: JSON.stringify({ data: input.value }),
  });
};
</script>

<template>
  <div class="h-screen w-screen">
    <UContainer
      class="w-full h-full flex flex-col justify-center items-center pt-24"
    >
      <p class="text-center mt-4">{{ response }}</p>

      <div class="absolute w-full max-w-3xl bottom-24 flex gap-4">
        <UInput v-model="input" placeholder="Type something" class="w-full" />
        <UButton @click="send()"> Send </UButton>
      </div>
    </UContainer>
  </div>
</template>
