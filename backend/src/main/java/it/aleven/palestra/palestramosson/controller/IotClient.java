package it.aleven.palestra.palestramosson.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class IotClient {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public String get(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String iotResponse = restTemplate.getForObject(url, String.class);
        log.info(iotResponse.toString());
        return iotResponse;
    }
}
