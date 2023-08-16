package io.github.agramar.web.jsp.controller;

import io.github.agramar.web.jsp.service.SampleService;
import io.github.agramar.web.jsp.vo.CityVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class SampleController {

    private final SampleService service;

    @RequestMapping("/sample")
    public ModelAndView sample() {
        ModelAndView mav = new ModelAndView("sample");
        List<CityVO> cities = service.selectAllCities();
        mav.addObject("cities", cities);
        return mav;
    }
}
