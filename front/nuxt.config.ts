// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  compatibilityDate: "2024-11-01",
  css: ["~/assets/css/main.css"],
  devtools: { enabled: true },
  eslint: {
    config: {
      stylistic: true,
    },
  },
  future: {
    compatibilityVersion: 4,
  },

  modules: ["@nuxt/eslint", "@nuxt/ui", "@nuxt/icon"],
  runtimeConfig: {
    public: {
      apiUrl: "",
    },
  },
  ssr: false,
});
