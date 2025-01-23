package com.example.test3.repository;

import com.example.test3.domain.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestRepository extends JpaRepository<Test,Long>, TestSearch {
  @Query(value = "select now()", nativeQuery = true)
  String getTime();
  Page<Test> searchAll(String[] types, String keyword, Pageable pageable);
}
