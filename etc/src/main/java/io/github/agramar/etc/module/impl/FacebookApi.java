package io.github.agramar.etc.module.impl;


import io.github.agramar.etc.module.OpenApi;
import io.github.agramar.etc.module.OpenApiType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static io.github.agramar.etc.module.OpenApiType.FACEBOOK;

@Slf4j
@Component
public class FacebookApi implements OpenApi {
    @Override
    public OpenApiType getType() {
        return FACEBOOK;
    }

    @Override
    public void doSomething() {
        log.info("hello, facebook");
    }
}
