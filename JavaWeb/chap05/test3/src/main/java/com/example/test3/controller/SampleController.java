package com.example.test3.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
public class SampleController {
  @GetMapping("/hello")
  public void hello(Model model) {
    log.info("hello");
    model.addAttribute("msg", "hello");
  }

  @GetMapping("/ex/ex1")
  public void ex1(Model model) {
    List<String> list = Arrays.asList("a", "b", "c", "d");
    model.addAttribute("list", list);
  }

  class SampleDTO {
    private String p1, p2, p3;
    public String getP1() {
      return p1;
    }
    public String getP2() {
      return p2;
    }
    public String getP3() {
      return p3;
    }
  }

  @GetMapping("/ex/ex2")
  public void ex2(Model model) {
    log.info("ex/ex2");
    List<String> strList = IntStream.range(1,10)
            .mapToObj(i->"Data"+i)
            .collect(Collectors.toList());

    model.addAttribute("list",strList);
    Map<String, String> map = new HashMap<>();
    map.put("a","aaaa");
    map.put("b","bbbb");

    model.addAttribute("map",map);

    SampleDTO sampleDTO = new SampleDTO();
    sampleDTO.p1="value -- p1";
    sampleDTO.p2="value -- p2";
    sampleDTO.p3="value -- p3";

    model.addAttribute("dto",sampleDTO);
  }

  @GetMapping("ex/ex3")
  public void ex3(Model model) {
    model.addAttribute("arr",new String[]{"a","b","c"});
  }
}
