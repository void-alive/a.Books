package com.example.chap4.mapper;

import com.example.chap4.domain.TodoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
  String getTime();
  void insert(TodoVO todoVO);
  List<TodoVO> selectAll();
}
