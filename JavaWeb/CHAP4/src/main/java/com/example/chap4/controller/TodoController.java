package com.example.chap4.controller;

import com.example.chap4.dto.TodoDTO;
import com.example.chap4.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {
  private final TodoService todoService;

  @RequestMapping("/list")
  public void list(Model model){
    log.info("todo list");
    model.addAttribute("dtoList", todoService.getAll());
  }

  @GetMapping("/register")
  public void registerGET(){
    System.out.println("Get todo register");
  }

  @PostMapping("/register")
  public String registerPost(@Valid TodoDTO todoDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
    System.out.println("Post todo register");

    if(bindingResult.hasErrors()){
      System.out.println("error");
      redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
      return "redirect:/todo/register";
    }

    System.out.println(todoDTO);
    todoService.register(todoDTO);
    return "redirect:/todo/list";
  }
}
