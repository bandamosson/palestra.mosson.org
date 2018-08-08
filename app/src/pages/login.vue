<template>
  <f7-page no-toolbar no-navbar no-swipeback login-screen>
    <f7-login-screen-title>Palestra SMART</f7-login-screen-title>
    <f7-list form>
      <f7-list-item>
        <f7-label>Username</f7-label>
        <f7-input type="text" placeholder="Tuo utente" @input="username = $event.target.value"></f7-input>
      </f7-list-item>
      <f7-list-item>
        <f7-label>Password</f7-label>
        <f7-input type="password" placeholder="Tua password" @input="password = $event.target.value"></f7-input>
      </f7-list-item>
    </f7-list>
    <f7-list>
      <f7-list-button @click="signIn" icon-f7="unlock"><f7-icon f7="login_fill" size="22"></f7-icon> Accedi</f7-list-button>
      <!--<f7-block-footer>Accesso Automatico:<br>E' possibile accedere automaticamente con il proprio numero di telefono (se abilitato).</f7-block-footer>-->
    </f7-list>

    <f7-list inset>
      <f7-list-button @click="signIn"><f7-icon f7="login" size="22"></f7-icon> Accesso Automatico</f7-list-button>
      <f7-block-footer>Abilita Accesso Automatico:<br>Accedi automaticamente con il tuo numero di telefono (se abilitato).</f7-block-footer>
    </f7-list>
  </f7-page>
</template>

<script>
  export default {
    data() {
      return {
        username: '',
        password: '',
      };
    },
    methods: {
      signIn() {
        const self = this;
        const app = self.$f7;
        const router = self.$f7router;
        // app.dialog.alert(`Username: ${self.username}<br>Password: ${self.password}`, () => {
          router.back();
        // });
      },
    },
  };
</script>
