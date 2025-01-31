package com.example.chap4.mapper;

import com.example.chap4.domain.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:/src/main/resources/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

  @Autowired(required = false)
  private TodoMapper todoMapper;

  @Test
  public void testGetTime(){
    System.out.println(todoMapper.getTime());
  }

  @Test
  public void testInsert(){
    TodoVO todoVO = TodoVO.builder()
            .title("테스트1")
            .dueDate(LocalDate.now())
            .writer("test1")
            .build();

    todoMapper.insert(todoVO);
  }
}
