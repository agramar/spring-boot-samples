package io.github.agramar.redis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.GeoIndexed;
import org.springframework.data.redis.core.index.Indexed;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(exclude = "chains")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RedisHash(value = "hotels", timeToLive = 3600)
public class Accommodation {

    @Id
    private String id;

    @Indexed
    private String name;

    private AccommodationType accommodationType;

    @GeoIndexed
    private Point location;

    @Reference
    @Builder.Default
    private List<Accommodation> chains = new ArrayList<>();

    public void addChain(Accommodation accommodation) {
        chains.add(accommodation);
    }
}
