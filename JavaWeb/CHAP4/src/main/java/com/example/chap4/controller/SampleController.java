package com.example.chap4.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {

  @GetMapping("/hello")
  public void hello() {
    log.info("hello");
  }

  @GetMapping("/ex1")
  public void ex1(String name, int age) {
    System.out.println("ex1");
    System.out.println("name : " + name);
    System.out.println("age : " + age);
  }

  @GetMapping("/ex2")
  public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name,
                  @RequestParam(name = "age", defaultValue = "20") int age) {
    System.out.println("ex2");
    System.out.println("name : " + name);
    System.out.println("age : " + age);
  }

  @GetMapping("/ex3")
  public void ex3(LocalDate dueDate){
    System.out.println("ex3");
    System.out.println("dueDAte : " + dueDate);
  }

  @GetMapping("/ex4")
  public void ex4(Model model){
    System.out.println("------------------------");
    model.addAttribute("message","asdf");
  }

  @GetMapping("/ex5")
  public String ex5(RedirectAttributes redirectAttributes){
    redirectAttributes.addAttribute("name","abc");
    redirectAttributes.addAttribute("result","success");
    return "redirect:/ex6";
  }

  @GetMapping("/ex6")
  public ModelAndView ex6(){
    ModelAndView mv = new ModelAndView("/ex6");
    return mv;
  }
}
