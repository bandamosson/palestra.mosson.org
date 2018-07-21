<template>
  <f7-page>
    <f7-navbar>
      <f7-nav-left>
        <f7-link icon-if-ios="f7:menu" icon-if-md="material:menu" panel-open="left"></f7-link>
      </f7-nav-left>
      <f7-nav-title>Palestra Mosson</f7-nav-title>
      <!--
      <f7-nav-right>
        <f7-link icon-if-ios="f7:menu" icon-if-md="material:menu" panel-open="right"></f7-link>
      </f7-nav-right>
      -->
    </f7-navbar>
<!--    <f7-toolbar>
      <f7-link>Associazione ABC di Caltrano</f7-link>
      &lt;!&ndash;<f7-link>Right Link</f7-link>&ndash;&gt;
    </f7-toolbar>-->
    <f7-block-title>Apertura Automatica</f7-block-title>
    <f7-block strong>
      <f7-icon f7="radio"></f7-icon>
      <p>Avvicina lo smartphone al sensore NFC per sbloccare automaticamente la porta.</p>
    </f7-block>
    <!--<f7-card-->
      <!--content="Avvicina lo smartphone al sensore NFC per sbloccare automaticamente la porta.">-->
    <!--</f7-card>-->
    <!--<f7-block-title>Navigation</f7-block-title>-->
    <!--<f7-list>-->
      <!--<f7-list-item link="/about/" title="About"></f7-list-item>-->
      <!--<f7-list-item link="/form/" title="Form"></f7-list-item>-->
    <!--</f7-list>-->
    <f7-block-title>Apertura Manuale</f7-block-title>
    <f7-list>
      <f7-list-item title="Porta" smart-select :smart-select-params="{openIn: 'popover'}">
        <select name="superhero" multiple>
          <option value="1" selected>1 - Entrata lato Sud</option>
          <option value="2">2 - Entrata lato Nord</option>
        </select>
      </f7-list-item>
    </f7-list>
    <f7-block>
      <f7-row>
        <f7-col width="100">
          <f7-button fill raised popup-open="#popup" icon-f7="unlock" icon-size="16"> Sblocca Porta</f7-button>
        </f7-col>
        <!--<f7-col width="50">-->
          <!--<f7-button fill raised login-screen-open="#login-screen">Login Screen</f7-button>-->
        <!--</f7-col>-->
      </f7-row>
      <p>Una volta sbloccata, utilizzare il pulsante a lato della porta per aprirla.</p>
    </f7-block>
    <!--<f7-block-title>Panels</f7-block-title>-->
    <!--<f7-block strong>-->
      <!--<f7-row>-->
        <!--<f7-col width="50">-->
          <!--<f7-button fill raised panel-open="left">Left Panel</f7-button>-->
        <!--</f7-col>-->
        <!--<f7-col width="50">-->
          <!--<f7-button fill raised panel-open="right">Right Panel</f7-button>-->
        <!--</f7-col>-->
      <!--</f7-row>-->
    <!--</f7-block>-->
    <!--<f7-list>-->
      <!--<f7-list-item link="/dynamic-route/blog/45/post/125/?foo=bar#about" title="Dynamic Route"></f7-list-item>-->
      <!--<f7-list-item link="/load-something-that-doesnt-exist/" title="Default Route (404)"></f7-list-item>-->
    <!--</f7-list>-->
  </f7-page>
</template>
<script>
export default {}
</script>
