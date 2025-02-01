package com.example.chap4.controller;

import com.example.chap4.dto.PageRequestDTO;
import com.example.chap4.dto.PageResponseDTO;
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
  public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model){
    System.out.println(pageRequestDTO);
    if(!bindingResult.hasErrors()){
      pageRequestDTO = PageRequestDTO.builder().build();
    }

    PageResponseDTO res = todoService.getList(pageRequestDTO);

    model.addAttribute("responseDTO", res);

//    model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
  }

  @GetMapping("/register")
  public void registerGET() {
    System.out.println("Get todo register");
  }

  @PostMapping("/register")
  public String registerPost(@Valid TodoDTO todoDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
    System.out.println("Post todo register");

    if (bindingResult.hasErrors()) {
      System.out.println("error");
      redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
      return "redirect:/todo/register";
    }

    System.out.println(todoDTO);
    todoService.register(todoDTO);
    return "redirect:/todo/list";
  }

  @GetMapping({"/read", "/modify"})
  public void read(Long tno, PageRequestDTO pageRequestDTO, Model model) {
    TodoDTO todoDTO = todoService.getOne(tno);
    System.out.println(todoDTO);
    model.addAttribute("dto", todoDTO);
  }

  @PostMapping("/remove")
  public String remove(Long tno, RedirectAttributes redirectAttributes) {
    System.out.println("--------remove--------");
    System.out.println("tno : " + tno);
    todoService.remove(tno);
    return "redirect:/todo/list";
  }

  @PostMapping("/modify")
  public String modify(@Valid TodoDTO todoDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors()) {
      System.out.println("error");
      redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
      redirectAttributes.addAttribute("tno", todoDTO.getTno());
    }

    System.out.println(todoDTO);
    todoService.modify(todoDTO);
    return "redirect:/todo/list";
  }
}
