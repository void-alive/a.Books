package com.example.chap4.mapper;

import com.example.chap4.domain.TodoVO;
import com.example.chap4.dto.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Mapper
public interface TodoMapper {
  String getTime();

  void insert(TodoVO todoVO);

  List<TodoVO> selectAll();

  TodoVO selectOne(Long tno);

  void delete(Long tno);

  void update(TodoVO todoVO);

  List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

  int getCount(PageRequestDTO pageRequestDTO);
}
