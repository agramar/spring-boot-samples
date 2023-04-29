package io.github.agramar.redis.pubsub;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.listener.ChannelTopic;

@Getter
@RequiredArgsConstructor
public enum RedisChannelTopic {

    NOTIFICATION(ChannelTopic.of("NOTIFICATION"));

    private final ChannelTopic channelTopic;
}
