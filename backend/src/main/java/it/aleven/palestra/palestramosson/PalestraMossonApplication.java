package it.aleven.palestra.palestramosson;

import it.aleven.palestra.palestramosson.model.IotMessage;
import it.aleven.palestra.palestramosson.repository.IotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class PalestraMossonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalestraMossonApplication.class, args);
    }

//    @Bean
//    CommandLineRunner init(IotRepository iotRepository) {
//        return args ->
//                Arrays.asList("action1", "action2", "pwebb", "ogierke", "rwinch", "mfisher", "mpollack", "jlong")
//                        .forEach(action -> {
//                            iotRepository.save(new IotMessage(action, new Date()));
//                        });
//    }
}
