package io.github.agramar.web.jsp.mapper;

import io.github.agramar.web.jsp.vo.CityVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleMapper {
    List<CityVO> selectAllCities();
}
