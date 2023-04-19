package io.github.agramar.redis.repository;

import io.github.agramar.redis.domain.Accommodation;
import io.github.agramar.redis.domain.AccommodationType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Circle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface AccommodationRedisRepository extends CrudRepository<Accommodation, String>, QueryByExampleExecutor<Accommodation> {

    List<Accommodation> findByName(String name);
    Page<Accommodation> findByName(String name, Pageable pageable);
    List<Accommodation> findByAccommodationType(AccommodationType accommodationType);
    Page<Accommodation> findByAccommodationType(AccommodationType accommodationType, Pageable pageable);
    List<Accommodation> findByLocationWithin(Circle circle);
}
