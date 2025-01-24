package com.example.chap4.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

  @Select("select now()")
  String getTime();
}
