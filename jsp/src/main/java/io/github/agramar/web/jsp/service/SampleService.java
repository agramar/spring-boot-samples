package io.github.agramar.web.jsp.service;

import io.github.agramar.web.jsp.mapper.SampleMapper;
import io.github.agramar.web.jsp.vo.CityVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SampleService {
    private final SampleMapper sampleMapper;

    public List<CityVO> selectAllCities() {
        return sampleMapper.selectAllCities();
    }
}
