package com.example.test3.repository.search;

import com.example.test3.domain.QTest;
import com.example.test3.domain.Test;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class TestSearchImpl extends QuerydslRepositorySupport implements TestSearch {
  public TestSearchImpl() {
    super(TestSearch.class);
  }

  @Override
  public Page<Test> search1(Pageable pageable) {

    QTest test = QTest.test;

//    select from test
    JPQLQuery<Test> query = from(test);

//    where title like
    query.where(test.title.contains("1"));

    return null;
  }

  @Override
  public Page<Test> searchAll(String[] types, String keyword, Pageable pageable) {
    return null;
  }
}
