import Vue from 'vue'
import App from './App.vue'
import router from './router'

import axios from 'axios'
import Vuex from 'vuex'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.prototype.$axios = axios
axios.defaults.headers.post['Content-Type'] = 'application/json'

Vue.config.productionTip = false

Vue.use(Vuex)
Vue.use(ElementUI)

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
