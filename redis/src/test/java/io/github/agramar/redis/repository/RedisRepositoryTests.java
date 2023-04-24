package io.github.agramar.redis.repository;

import io.github.agramar.redis.RedisTests;
import io.github.agramar.redis.domain.Accommodation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

import java.util.List;

import static io.github.agramar.redis.domain.AccommodationType.*;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataRedisTest
@DisplayName("레디스 레파지토리 테스트")
public class RedisRepositoryTests extends RedisTests {

    @Autowired
    AccommodationRedisRepository repository;

    Accommodation lotteHotelWorld = Accommodation.builder().name("롯데 호텔 월드").accommodationType(HOTEL).location(new Point(127.1000, 37.5115)).build();
    Accommodation signielSeoul = Accommodation.builder().name("시그니엘 서울").accommodationType(HOTEL).location(new Point(127.1025, 37.5126)).build();
    Accommodation parkHyattSeoul = Accommodation.builder().name("파크 하얏트 호텔 서울").accommodationType(HOTEL).location(new Point(127.0642, 37.5086)).build();
    Accommodation fourSeasonsHotelSeoul = Accommodation.builder().name("포시즌스호텔 서울").accommodationType(HOTEL).location(new Point(126.9754, 37.5707)).build();
    Accommodation kensingtonResortGapyeong = Accommodation.builder().name("켄싱턴리조트 가평").accommodationType(RESORT).location(new Point(127.3958, 37.7596)).build();
    Accommodation urbanstayMyeongdong = Accommodation.builder().name("어반스테이 명동").accommodationType(CONDO).location(new Point(126.9805, 37.5671)).build();
    List<Accommodation> accommodations = List.of(lotteHotelWorld, signielSeoul, parkHyattSeoul, fourSeasonsHotelSeoul, kensingtonResortGapyeong, urbanstayMyeongdong);



    @Test
    @DisplayName("단건 등록")
    void testSave() {
        repository.save(lotteHotelWorld);
        assertThat(lotteHotelWorld.getId()).isNotBlank();
    }

    @Test
    @DisplayName("필드값 조회")
    void testFindByTitle() {
        repository.saveAll(accommodations);

        List<Accommodation> accommodationList = repository.findByName(kensingtonResortGapyeong.getName());

        assertThat(accommodationList)
                .hasSize(1)
                .contains(kensingtonResortGapyeong)
                .doesNotContain(urbanstayMyeongdong);
    }

    @Test
    @DisplayName("페이징")
    void testPaging() {
        repository.saveAll(accommodations);
        Pageable page = PageRequest.of(0, 2);

        Page<Accommodation> accommodationPage = repository.findByName(kensingtonResortGapyeong.getName(), page);

        log.info("accommodationPage : {}, {}", accommodationPage, accommodationPage.getContent());
        assertThat(accommodationPage.getNumber()).isEqualTo(page.getPageNumber());
        assertThat(accommodationPage.getSize()).isEqualTo(page.getPageSize());
        assertThat(accommodationPage).contains(kensingtonResortGapyeong).doesNotContain(urbanstayMyeongdong);
    }

    @Test
    @DisplayName("EXAMPLE 쿼리")
    void testFindByExample() {
        repository.saveAll(accommodations);
        Example<Accommodation> example = Example.of(Accommodation.builder().name(kensingtonResortGapyeong.getName()).build());

        Iterable<Accommodation> accommodations = repository.findAll(example);

        log.info("accommodations : {}", accommodations);
        assertThat(accommodations).contains(kensingtonResortGapyeong).doesNotContain(signielSeoul);
    }


    @Test
    @DisplayName("좌표로 찾기")
    void testFindByGeoLocation() {
        repository.saveAll(accommodations);

        Circle circle = new Circle(new Point(127.0642, 37.5086), new Distance(5, Metrics.KILOMETERS));

        List<Accommodation> accommodationList = repository.findByLocationWithin(circle);

        log.info("accommodationList : {}", accommodationList);
        assertThat(accommodationList).hasSize(3)
                .contains(parkHyattSeoul, lotteHotelWorld, signielSeoul)
                .doesNotContain(kensingtonResortGapyeong);
    }
}
