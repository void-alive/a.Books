package com.example.test3.service;

import com.example.test3.Test3Application;
import com.example.test3.dto.PageRequestDTO;
import com.example.test3.dto.PageResponseDTO;
import com.example.test3.dto.TestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@Log4j2
@ContextConfiguration(classes = Test3Application.class)
public class TestServiceTests {
  @Autowired
  private TestService testService;

  //  삽입
/*  @Test
  public void testRegister() {
    log.info(testService.getClass().getName());
    for (int i = 0; i < 100; i++) {
      TestDTO testDTO = TestDTO.builder()
              .title("sample title")
              .content("sample content")
              .writer("user" + i)
              .build();

      Long bno = testService.register(testDTO);
      log.info("bno : " + bno);
    }
  }*/

// 수정
/*  @Test
  public void testModify(){
    TestDTO testDTO = TestDTO.builder()
            .bno(101L)
            .title("update 101")
            .content("update content 101")
            .build();
    testService.modify(testDTO);
  }*/

  //검색
  @Test
  public void testList(){
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
            .page(1)
            .size(10)
            .build();

    PageResponseDTO<TestDTO> responseDTO = testService.list(pageRequestDTO);
    log.info(responseDTO);
  }
}
