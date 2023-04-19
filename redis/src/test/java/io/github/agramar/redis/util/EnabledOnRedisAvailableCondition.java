package io.github.agramar.redis.util;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Optional;

import static org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled;

class EnabledOnRedisAvailableCondition implements ExecutionCondition {

    private static final ConditionEvaluationResult ENABLED_BY_DEFAULT = enabled("@EnabledOnRedisAvailable is not present");

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {

        Optional<EnabledOnRedisAvailable> optional = AnnotationUtils.findAnnotation(context.getElement(), EnabledOnRedisAvailable.class);
        if (optional.isEmpty()) {
            return ENABLED_BY_DEFAULT;
        }

        EnabledOnRedisAvailable annotation = optional.get();

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(annotation.host(), annotation.port()), 100);
            return enabled(String.format("Connection successful to Redis at %s:%d", annotation.host(), annotation.port()));
        } catch (IOException e) {
            return disabled(String.format("Cannot connect to Redis at %s:%d (%s)", annotation.host(), annotation.port(), e));
        }
    }
}
