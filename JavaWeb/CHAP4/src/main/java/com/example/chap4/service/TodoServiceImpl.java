package com.example.chap4.service;

import com.example.chap4.domain.TodoVO;
import com.example.chap4.dto.PageRequestDTO;
import com.example.chap4.dto.PageResponseDTO;
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
  public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
    List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
    List<TodoDTO> dtoList = voList.stream()
            .map(vo -> modelMapper.map(vo, TodoDTO.class))
            .collect(Collectors.toList());

    int total = todoMapper.getCount(pageRequestDTO);

    PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
            .dtoList(dtoList)
            .total(total)
            .pageRequestDTO(pageRequestDTO)
            .build();

    return pageResponseDTO;
  }

  @Override
  public TodoDTO getOne(Long tno) {
    TodoVO todoVO = todoMapper.selectOne(tno);
    TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
    return todoDTO;
  }

  @Override
  public void remove(Long tno) {
    todoMapper.delete(tno);
  }

  @Override
  public void modify(TodoDTO todoDTO) {
    TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
    todoMapper.update(todoVO);
  }
}
