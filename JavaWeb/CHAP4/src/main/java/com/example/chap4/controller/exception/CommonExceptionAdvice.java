package com.example.chap4.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Log4j2
@RequestMapping("/ex7")
public class CommonExceptionAdvice {

/*  @GetMapping("/ex7")
  public void ex7(String p1, int p2){
    System.out.println("p1 : " + p1);
    System.out.println("p2 : " + p2);
  }*/
  @ResponseBody
  @ExceptionHandler(NumberFormatException.class)
  public String exceptNumber(NumberFormatException e) {
    System.out.println("-----------------");
    System.out.println(e.getMessage());
    return "number format exception";
  }
}
