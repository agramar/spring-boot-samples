package io.github.agramar.redis.pubsub;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisSubscriber implements MessageListener {

    private final RedisTemplate<String, Object> redisTemplate;
    private final Map<String, String> lastMessage = new HashMap<>();


    @Override
    public void onMessage(Message message, byte[] pattern) {
        RedisSerializer<String> stringRedisSerializer = redisTemplate.getStringSerializer();
        String channelString = stringRedisSerializer.deserialize(message.getChannel());
        String messageString = stringRedisSerializer.deserialize(message.getBody());
        lastMessage.put("channel", channelString);
        lastMessage.put("message", messageString);
        log.info("subscribed message : [{}] {}", channelString, messageString);
    }

    public String getLastMessage() {
        return lastMessage.get("message");
    }

    public String getLastChannel() {
        return lastMessage.get("channel");
    }
}
