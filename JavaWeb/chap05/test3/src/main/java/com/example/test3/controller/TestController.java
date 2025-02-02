package com.example.test3.controller;

import com.example.test3.dto.PageRequestDTO;
import com.example.test3.dto.PageResponseDTO;
import com.example.test3.dto.TestDTO;
import com.example.test3.service.TestService;
import groovy.util.logging.Log4j2;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
@Log4j2
@RequiredArgsConstructor
public class TestController {
  private final TestService testService;

  @GetMapping("/list")
  public void list(PageRequestDTO pageRequestDTO, Model model){
    PageResponseDTO<TestDTO> responseDTO = testService.list(pageRequestDTO);
    System.out.println(responseDTO);
    model.addAttribute("responseDTO", responseDTO);
  }
}
