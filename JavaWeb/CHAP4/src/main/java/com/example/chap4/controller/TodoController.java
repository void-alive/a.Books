package com.example.chap4.controller;

import com.example.chap4.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {

  @RequestMapping("/list")
  public void list(){
    log.info("todo list");
  }

  @GetMapping("/register")
  public void registerGET(){
    System.out.println("Get todo register");
  }

  @PostMapping("/register")
  public void registerPost(TodoDTO todoDTO){
    System.out.println("Post todo register");
    System.out.println(todoDTO);
  }
}
