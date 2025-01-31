package com.example.chap4.service;

import com.example.chap4.domain.TodoVO;
import com.example.chap4.dto.TodoDTO;
import com.example.chap4.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
  private final TodoMapper todoMapper;
  private final ModelMapper modelMapper;

  @Override
  public void register(TodoDTO todoDTO){
    System.out.println(modelMapper);
    TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
    System.out.println(todoVO);
    todoMapper.insert(todoVO);
  }

  @Override
  public List<TodoDTO> getAll(){
    List<TodoDTO> dtoList=todoMapper.selectAll().stream()
            .map(vo -> modelMapper.map(vo,TodoDTO.class))
            .collect(Collectors.toList());

    return dtoList;
  }
}
