package io.github.agramar.etc.module;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class OpenApiConfig {

    @Bean
    public Map<OpenApiType, OpenApi> openApiEnumMap(@NonNull List<OpenApi> openApis) {
        return openApis.stream()
                .collect(Collectors.toMap(
                        OpenApi::getType,
                        Function.identity(),
                        (l, r) -> { throw new IllegalArgumentException(); },
                        () -> new EnumMap<>(OpenApiType.class)
                ));
    }
}
