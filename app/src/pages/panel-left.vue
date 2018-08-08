<template>
  <f7-page>
    <f7-navbar title="Menu"></f7-navbar>
    <!--<f7-block strong>-->
      <!--<p>Left panel content goes here</p>-->
    <!--</f7-block>-->
    <f7-block-title>Associazione "Banda Mosson"</f7-block-title>
    <f7-list>
      <f7-list-item link="/" title="Accesso" view="#main-view" panel-close></f7-list-item>
      <f7-list-item link="/form/" title="Calendario" view="#main-view" panel-close></f7-list-item>
    </f7-list>
    <f7-block-title>---</f7-block-title>
    <f7-list>
      <f7-list-item link="/about/" title="?" view="#main-view" panel-close></f7-list-item>
      <f7-list-item link="/login/" title="Esci" view="#main-view" panel-close></f7-list-item>
      <!--<f7-list-item link="/form/" title="Form" view="#main-view" panel-close></f7-list-item>-->
    </f7-list>
  </f7-page>
</template>
<script>
export default {}
</script>
