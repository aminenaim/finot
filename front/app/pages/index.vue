<script setup lang="ts">
const input = ref<string>("");
const response = ref<string>("");
const isLoading = ref<boolean>(false);
const runtimeConfig = useRuntimeConfig();
const send = async () => {
  isLoading.value = true;
  response.value = await $fetch("/ai/request", {
    baseURL: runtimeConfig.public.apiUrl,
    method: "POST",
    body: JSON.stringify({ data: input.value }),
  });
  isLoading.value = false;
};
</script>

<template>
  <div class="h-screen w-screen">
    <UContainer
      class="w-full h-full flex flex-col justify-center items-center pt-24"
    >
      <p v-if="!isLoading" class="text-center mt-4">{{ response }}</p>
      <UButton v-else disabled>Loading...</UButton>

      <div class="absolute w-full max-w-3xl bottom-24 flex gap-4">
        <UInput
          v-model="input"
          placeholder="Type something"
          class="w-full"
          @keyup.enter="send()"
        />
        <UButton @click="send()"> Send </UButton>
      </div>
    </UContainer>
  </div>
</template>
