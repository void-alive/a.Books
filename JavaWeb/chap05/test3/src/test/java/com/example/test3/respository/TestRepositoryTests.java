package com.example.test3.respository;

import com.example.test3.repository.TestRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
class TestRepositoryTests {

  @Autowired
  private TestRepository testRepository;

/* insert
 @org.junit.jupiter.api.Test
  public void testInsert(){
    IntStream.rangeClosed(1,100).forEach(i->{
      Test test = Test.builder()
              .title("title..."+i)
              .content("content..."+i)
              .writer("user..."+(i%10))
              .build();

      Test result= testRepository.save(test);
      log.info("BNO : " + result.getBno());
    });
  }*/

/* select
 @org.junit.jupiter.api.Test
  public void testSelect(){
    Long bno = 100L;
    Optional<Test> result=testRepository.findById(bno);
    Test test = result.orElseThrow();
    log.info(test);
  }*/

  /* delete
 @Test
  public void testDelete(){
    Long bno=1L;
    testRepository.deleteById(bno);
  }*/

  @Test
  public void testPaging(){
    Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
    Page<com.example.test3.domain.Test> result = testRepository.findAll(pageable);
  }
}