package io.github.agramar.etc.property;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Validated
@ConfigurationProperties(prefix = "record")
public record RecordProperties(
        @NotBlank String name,
        @Min(1) @Max(10) int count,
        @Size(min = 1, max = 10) List<String> options
) {
    @ConstructorBinding
    public RecordProperties {
    }
}
