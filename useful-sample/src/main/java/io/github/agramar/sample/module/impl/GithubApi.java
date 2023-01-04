package io.github.agramar.sample.module.impl;


import io.github.agramar.sample.module.OpenApi;
import io.github.agramar.sample.module.OpenApiType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static io.github.agramar.sample.module.OpenApiType.GITHUB;

@Slf4j
@Component
public class GithubApi implements OpenApi {
    @Override
    public OpenApiType getType() {
        return GITHUB;
    }

    @Override
    public void doSomething() {
        log.info("hello, github");
    }
}
