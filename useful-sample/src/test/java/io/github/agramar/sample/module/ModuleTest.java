package io.github.agramar.sample.module;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ModuleTest {

    @Autowired
    Map<OpenApiType, OpenApi> openApiEnumMap;

    @Test
    void testEnumMapInject() {
        for (OpenApiType openApiType : OpenApiType.values()) {
            OpenApi openApi = openApiEnumMap.get(openApiType);
            openApi.doSomething();
            assertEquals(openApiType, openApi.getType());
        }
    }
}
