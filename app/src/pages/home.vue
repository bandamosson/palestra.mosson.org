<template>
  <f7-page>
    <f7-navbar>
      <f7-nav-left>
        <f7-link icon-if-ios="f7:menu" icon-if-md="material:menu" panel-open="left"></f7-link>
      </f7-nav-left>
      <f7-nav-title>Palestra di Mosson</f7-nav-title>
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
    <f7-block-title v-show="!nfcAvailable">
      <f7-icon f7="radio"></f7-icon>
      Apertura automatica con NFC non disponibile.
    </f7-block-title>
    <f7-block-title v-show="nfcAvailable">Apertura Automatica</f7-block-title>
    <f7-block strong v-show="nfcAvailable">
      <f7-icon f7="radio"></f7-icon>
      <!--<f7-icon material="nfc"></f7-icon>-->
      <p>Avvicina lo smartphone al sensore NFC per sbloccare automaticamente la porta.</p>
    </f7-block>

    <!--<f7-block-title v-show="gpsAvailable">Localizzazione GPS Disponibile</f7-block-title>
    <f7-block strong v-show="gpsAvailable">
      <f7-icon material="gps_fixed"></f7-icon>
      <p>{{curLocation}}</p>
    </f7-block>-->

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

      <f7-list-item>
        <f7-label>Test IOT Gateway</f7-label>
        <f7-input type="text" :value="url" @input="url = $event.target.value" placeholder="url for an http get" clear-button></f7-input>
      </f7-list-item>
    </f7-list>

    <f7-block>
      <f7-row>
        <f7-col width="100">
          <!--<f7-button fill raised popup-open="#popup" icon-f7="unlock" icon-size="16" @click="apriPorta()"> Sblocca-->
          <f7-button fill raised icon-f7="unlock" icon-size="16" @click="apriPorta()"> Sblocca
            Porta
          </f7-button>
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

    <!-- Popup -->
    <f7-popup id="popup" :opened="popupOpened" @popup:closed="popupOpened = false">
      <f7-view>
        <f7-page>
          <f7-navbar title="Apertura">
            <f7-nav-right>
              <f7-link popup-close>Annulla</f7-link>
            </f7-nav-right>
          </f7-navbar>
          <f7-block v-show="!comandoRicevuto">
            <p>Attendi sblocco apertura porta in corso...</p>
            <p>
              <f7-progressbar infinite></f7-progressbar>
            </p>
          </f7-block>
          <f7-block v-show="comandoRicevuto">
            <f7-row>
              <!--<f7-col></f7-col>-->
              <f7-col>
                <f7-button fill color="red" v-show="comandoErr"><f7-icon material="lock"></f7-icon> Problema</f7-button>
                <f7-button fill color="green" v-show="comandoOk"><f7-icon material="lock_open"></f7-icon> Porta sbloccata</f7-button>

                <!--<p v-show="comandoOk">Porta sbloccata</p>
                <f7-icon material="lock_open" color="green" size="96" v-show="comandoOk"></f7-icon>
                <p v-show="comandoErr">Problema</p>
                <f7-icon material="lock" color="red" size="96" v-show="comandoErr"></f7-icon>-->
              </f7-col>
              <!--<f7-col></f7-col>-->
            </f7-row>
            <f7-row>
              <f7-col>
                <pre>{{restResponse}}</pre>
              </f7-col>
            </f7-row>
          </f7-block>
          <!--<f7-icon material="login_fill"></f7-icon>-->
        </f7-page>
      </f7-view>
    </f7-popup>
  </f7-page>
</template>
<script>
  import axios from 'axios'

  const baseURL = (process.env.NODE_ENV !== 'production') ? 'http://localhost:8090' : ''

  export default {
    data() {
      return {
        nfcAvailable: true,
        gpsAvailable: false,
        curLocation: null,
        comandoRicevuto: false,
        comandoOk: false,
        comandoErr: false,
        popupOpened: false,
        url: 'https://httpbin.org/get',
        restResponse: ''
      };
    },
    methods: {
      testNfc() {
        if ('nfc' in navigator) {
          this.nfcAvailable = true
          navigator.nfc.watch(function (message) {
            console.log("NFC message received from URL " + message.url);
            // if (message.data[0].recordType === 'empty') {
            //   navigator.nfc.push([{
            //     url: message.url,
            //     data: [{
            //       recordType: "text",
            //       data: 'Hello World'
            //     }]
            //   }]);
            // }
            this.processMessage(message);
          }, {mode: 'any'})
            .then(() => console.log("Added a watch."))
            .catch(err => console.error("Adding watch failed: " + err.name));
        } else {
          console.log('NFC API not supported.');
        }
      },
      processMessage(message) {
        message.data.forEach(function (record) {
          if (record.recordType == "string") {
            console.log('Data is string: ' + record.data);
          } else if (record.recordType == "json") {
            console.log(record.data);
          } else if (record.recordType == "url") {
            console.log("Data is URL: " + record.data);
          } else if (record.recordType == "opaque" && record.mediaType == 'image/png') {
            console.log(record.data);
          }
          ;
        });
      },
      testGps() {
        if ('geolocation' in navigator) {
          this.gpsAvailable = true
          const self = this
          navigator.geolocation.getCurrentPosition(function (location) {
            console.debug(location)
            self.curLocation = location.coords
          });
        } else {
          this.gpsAvailable = false
        }
      },
      apriPorta() {
        const self = this
        console.log('apriPorta');
        self.popupOpened = true
        self.comandoRicevuto = false
        self.comandoOk = false
        self.comandoErr = false
        axios.post(baseURL + '/command', {
          action: self.url
        })
        .then(function (response) {
          console.log('apriPorta ok');
          self.comandoRicevuto = true
          self.comandoOk = true
          self.restResponse = response.data
          console.log(response);
        })
        .catch(function (error) {
          console.log('apriPorta err');
          self.comandoRicevuto = true
          self.comandoErr = true
          console.log(error);
        });
      }
    },
    mounted() {
      // this.testNfc();
      // this.testGps()
    }
  }
</script>
