package com.example.chap4.service;

import com.example.chap4.dto.TodoDTO;

import java.util.List;

public interface TodoService {
  void register(TodoDTO todoDTO);
  List<TodoDTO> getAll();
}
