// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
// import router from './router'
import Framework7 from 'framework7'
import Framework7Vue from 'framework7-vue'
import 'framework7/css/framework7.min.css'

Vue.config.productionTip = false

// First of all, we need to initialize/enable Framework7 Vue plugin:
// We need to pass Framework7Vue plugin to Framework7's .use() method
Framework7.use(Framework7Vue)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  // router,
  components: { App },
  template: '<App/>'
})

// // Init Vue App
// new Vue({
//   // App Root Element
//   el: '#app',
//   components: { App },
//   template: '<App/>',
//   // App root data
//   data () {
//     return {
//       // Framework7 parameters that we pass to <f7-app> component
//       f7params: {
//         // Array with app routes
//         // routes: [...]
//         // App Name
//         name: 'My App',
//         // App id
//         id: 'com.myapp.test'
//       }
//     }
//   }
// })
