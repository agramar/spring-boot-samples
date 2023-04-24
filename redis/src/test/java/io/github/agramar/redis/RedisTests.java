package io.github.agramar.redis;

import io.github.agramar.redis.util.EnabledOnRedisAvailable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;

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
