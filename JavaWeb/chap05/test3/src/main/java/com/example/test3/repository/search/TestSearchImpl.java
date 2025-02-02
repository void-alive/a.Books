package com.example.test3.repository.search;

import com.example.test3.domain.QTest;
import com.example.test3.domain.Test;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

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
//    paging
    this.getQuerydsl().applyPagination(pageable, query);
    List<Test> list = query.fetch();
    long count = query.fetchCount();
    return null;
  }

  @Override
  public Page<Test> searchAll(String[] types, String keyword, Pageable pageable) {

    QTest test = QTest.test;
    JPQLQuery<Test> query = from(test);

    if( (types != null && types.length > 0) && keyword != null ){ //검색 조건과 키워드가 있다면

      BooleanBuilder booleanBuilder = new BooleanBuilder(); // (

      for(String type: types){

        switch (type){
          case "t":
            booleanBuilder.or(test.title.contains(keyword));
            break;
          case "c":
            booleanBuilder.or(test.content.contains(keyword));
            break;
          case "w":
            booleanBuilder.or(test.writer.contains(keyword));
            break;
        }
      }//end for
      query.where(booleanBuilder);
    }//end if

    //bno > 0
    query.where(test.bno.gt(0L));

    //paging
    this.getQuerydsl().applyPagination(pageable, query);

    List<Test> list = query.fetch();

    long count = query.fetchCount();

    return new PageImpl<>(list, pageable, count);

  }
}
