package com.example.chap4.service;

import com.example.chap4.dto.PageRequestDTO;
import com.example.chap4.dto.PageResponseDTO;
import com.example.chap4.dto.TodoDTO;

import java.util.List;

public interface TodoService {
  void register(TodoDTO todoDTO);

  PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

  TodoDTO getOne(Long tno);

  void remove(Long tno);

  void modify(TodoDTO todoDTO);

}
