package io.github.agramar.kafka.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaConsumer {

    @KafkaListener(id = "topic1-listener", topics = "topic1", clientIdPrefix = "topic1-client", autoStartup = "${listen.auto.start:true}", concurrency = "${listen.concurrency:3}")
    public void receivingTopic1Message(String message) {
        log.info("message : {}", message);
    }

    @KafkaListener(id = "topic2-listener", topics = "topic2", clientIdPrefix = "topic2-client", autoStartup = "${listen.auto.start:true}", concurrency = "${listen.concurrency:3}")
    public void receivingTopic2Message(String message) {
        log.info("message : {}", message);
    }
}
