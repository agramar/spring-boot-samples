package io.github.agramar.redis.dto;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {
    private Long id;
    private String title;
    private String description;
}
