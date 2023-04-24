package io.github.agramar.redis.cache;

import io.github.agramar.redis.RedisTests;
import io.github.agramar.redis.dto.ItemDto;
import io.github.agramar.redis.service.RedisCacheService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("레디스 캐시 테스트")
public class RedisCacheTests extends RedisTests {

    @Autowired
    RedisCacheService service;

    @DisplayName("레디스 캐시 동작 테스트")
    @Test
    void testRedisCache() {
        Long id = 1L;
        ItemDto item = service.getItem(id);
        ItemDto cachedItem = service.getItem(id);

        assertThat(item).isEqualTo(cachedItem);

        ItemDto updatedItem = service.updateCache(id);
        cachedItem = service.getItem(id);
        assertThat(updatedItem).isNotEqualTo(item);
        assertThat(updatedItem).isEqualTo(cachedItem);

        service.removeCache(id);
        cachedItem = service.getItem(id);
        assertThat(cachedItem).isEqualTo(item);
        assertThat(cachedItem).isNotEqualTo(updatedItem);
    }
}
