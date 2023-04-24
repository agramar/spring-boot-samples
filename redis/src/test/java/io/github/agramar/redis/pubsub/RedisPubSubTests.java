package io.github.agramar.redis.pubsub;

import io.github.agramar.redis.RedisTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.listener.ChannelTopic;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("레디스 PUB/SUB 테스트")
public class RedisPubSubTests extends RedisTests {

    @Autowired
    RedisPublisher redisPublisher;

    @Autowired
    RedisSubscriber redisSubscriber;

    @Test
    @DisplayName("레디스 PUB/SUB 메시지 발행 및 구독 테스트")
    void test() throws InterruptedException {
        ChannelTopic channelTopic = RedisChannelTopic.NOTIFICATION.getChannelTopic();
        String message = "message";

        redisPublisher.publish(channelTopic, message);
        Thread.sleep(1000);

        assertThat(redisSubscriber.getLastChannel()).isEqualTo(channelTopic.getTopic());
        assertThat(redisSubscriber.getLastMessage()).isEqualTo(message);
    }
}
