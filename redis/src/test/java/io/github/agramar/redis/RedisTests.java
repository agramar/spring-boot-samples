package io.github.agramar.redis;

import io.github.agramar.redis.util.EnabledOnRedisAvailable;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Slf4j
@DataRedisTest
@EnabledOnRedisAvailable
public class RedisTests {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @BeforeEach
    void setUp() {
        redisConnectionFactory
                .getConnection()
                .serverCommands()
                .flushDb();
    }

    @AfterEach
    void afterAll() {
        redisConnectionFactory
                .getConnection()
                .serverCommands()
                .flushDb();
    }
}
