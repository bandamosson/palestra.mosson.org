package it.aleven.palestra.palestramosson.controller;

import it.aleven.palestra.palestramosson.model.IotAction;
import it.aleven.palestra.palestramosson.model.IotMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class IotMessageController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IotClient iotClient;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/command", method = RequestMethod.POST)
    @ResponseBody
    public IotMessage sendCommand(@RequestBody IotAction action) {
        IotMessage messaggio = new IotMessage(action.getAction(), new Date());

        String esito = "OK";
        try {
            String url = action.getAction();
            if (!StringUtils.isEmpty(url)) {
                esito = iotClient.get(url);
            }
//            Thread.sleep((long) (Math.random() * 2000));
        } catch (Exception ex) {
            log.error("sendCommand", ex);
        }

        messaggio.setEnd(new Date());
        messaggio.setEsito(esito);

        return messaggio;
    }

}
