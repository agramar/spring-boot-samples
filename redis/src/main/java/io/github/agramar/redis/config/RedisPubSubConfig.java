package io.github.agramar.redis.config;

import io.github.agramar.redis.pubsub.RedisChannelTopic;
import io.github.agramar.redis.pubsub.RedisSubscriber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisPubSubConfig {

    /**
     * 레디스 pub/sub Listener 설정
     */
    @Bean
    public RedisMessageListenerContainer redisMessageListener(RedisConnectionFactory connectionFactory, RedisSubscriber redisSubscriber) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(redisSubscriber, RedisChannelTopic.NOTIFICATION.getChannelTopic());
        return container;
    }
}
