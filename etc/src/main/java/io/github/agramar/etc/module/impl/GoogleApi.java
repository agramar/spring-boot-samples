package io.github.agramar.etc.module.impl;

import io.github.agramar.etc.module.OpenApi;
import io.github.agramar.etc.module.OpenApiType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static io.github.agramar.etc.module.OpenApiType.GOOGLE;

@Slf4j
@Component
public class GoogleApi implements OpenApi {

    @Override
    public OpenApiType getType() {
        return GOOGLE;
    }

    @Override
    public void doSomething() {
        log.info("hello, google");
    }
}
