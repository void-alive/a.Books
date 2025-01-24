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

import java.util.List;
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

/*  @Test
  public void testPaging(){
    Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
    Page<com.example.test3.domain.Test> result = testRepository.findAll(pageable);
    log.info("total count : " + result.getTotalElements());
    log.info("total page : " + result.getTotalPages());
    log.info("page number : " + result.getNumber());
    log.info("page size : " + result.getSize());

    List<com.example.test3.domain.Test> todoList = result.getContent();
  }*/

/*  @Test
  public void testSearch1() {
    Pageable pageable = PageRequest.of(1, 10, Sort.by("bno").descending());
    testRepository.search1(pageable);
  }*/

  @Test
  public void testSearchAll() {
    String[] types = {"t", "c", "w"};
    String keyword = "1";
    Pageable pageable = PageRequest.of(0, 10);
    Page<com.example.test3.domain.Test> result = testRepository.searchAll(types, keyword, pageable);

    log.info(result.toString());
    log.info(result.getSize());
    log.info(result.getNumber());
    log.info(result.hasPrevious() + " : " + result.hasNext());
    result.getContent().forEach(test -> log.info(test.toString()));
  }
}