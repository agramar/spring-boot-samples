package io.github.agramar.redis.template;

import io.github.agramar.redis.RedisTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@DisplayName("레디스 템플릿 테스트")
public class RedisTemplateTests extends RedisTests {

    @Autowired
    RedisTemplate<String, ?> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void test() {
    }
}
