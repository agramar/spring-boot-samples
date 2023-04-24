package io.github.agramar.redis.service;

import io.github.agramar.redis.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisCacheService {

    private final String CACHE_NAME = "itemCache";

    @Cacheable(cacheNames = CACHE_NAME, key = "#id", unless = "#result == null")
    public ItemDto getItem(Long id) {
        try {
            log.info("wait for 1000 millis");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return ItemDto.builder()
                .id(id)
                .title("이름")
                .description("상세")
                .build();
    }

    @CachePut(cacheNames = CACHE_NAME, key = "#id")
    public ItemDto updateCache(Long id) {
        log.info("cache updated {}", id);
        return ItemDto.builder()
                .id(id)
                .title("이름-갱신")
                .description("상세-갱신")
                .build();
    }


    @CacheEvict(cacheNames = CACHE_NAME, key = "#id")
    public void removeCache(Long id) {
        log.info("cache removed {}", id);
    }
}
