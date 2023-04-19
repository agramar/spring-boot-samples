package io.github.agramar.etc.property;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@Validated
@Configuration
@ConfigurationProperties(prefix = "sample")
public class SampleProperties {
    @NotBlank
    private String name;
    @Min(1)
    @Max(10)
    private int count;
    @Size(min = 1, max = 10)
    private List<String> options;
    @NotEmpty
    private Map<String, String> props;
}
