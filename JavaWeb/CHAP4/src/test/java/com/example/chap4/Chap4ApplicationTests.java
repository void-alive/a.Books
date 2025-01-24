package com.example.chap4;

import com.example.chap4.sample.SampleService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/resources/webapp/WEB-INF/root-context.xml")
@SpringBootTest
class Chap4ApplicationTests {

  @Test
  void contextLoads() {
  }
}
