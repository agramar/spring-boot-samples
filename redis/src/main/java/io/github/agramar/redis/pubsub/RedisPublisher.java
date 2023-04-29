package io.github.agramar.redis.pubsub;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisPublisher {

    private final RedisTemplate<String, Object> redisTemplate;

    public void publish(ChannelTopic channelTopic, String message) {
        redisTemplate.convertAndSend(channelTopic.getTopic(), message);
        log.info("published message : [{}] {}", channelTopic.getTopic(), message);
    }
}
