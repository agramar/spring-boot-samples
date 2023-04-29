package io.github.agramar.kafka.producer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("카프카 프로듀서 테스트")
@SpringBootTest
class KafkaProducerTest {

    @Autowired
    KafkaProducer kafkaProducer;

    @Test
    @DisplayName("메세지 발신 테스트")
    void testSendMessage() {
        kafkaProducer.sendMessage("topic1", "key", "test message");
    }
}