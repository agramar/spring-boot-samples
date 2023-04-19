package io.github.agramar.redis.util;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;


@Target({TYPE, METHOD})
@Retention(RUNTIME)
@Inherited
@Documented
@ExtendWith(EnabledOnRedisAvailableCondition.class)
public @interface EnabledOnRedisAvailable {

    String host() default "localhost";

    int port() default 6379;
}
