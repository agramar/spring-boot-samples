package io.github.agramar.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String key, String message) {
        kafkaTemplate.send(topic, key, message)
                .whenComplete((result, e) -> {
                    if (e != null) {
                        log.error(e.getMessage(), e);
                        return;
                    }

                    log.info("sending message to kafka is success : {}", result);
                });
    }
}
