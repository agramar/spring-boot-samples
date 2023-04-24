package io.github.agramar.redis.template;

import io.github.agramar.redis.RedisTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("레디스 템플릿 테스트")
public class RedisTemplateTests extends RedisTests {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    @DisplayName("ValueOperations 테스트")
    void testValueOperations() {
        String key = "key";
        String value = "value";

        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);

        assertThat(valueOperations.get(key)).isEqualTo(value);
    }
}
