package com.example.test3.repository.search;

import com.example.test3.domain.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TestSearch {
  Page<Test> search1(Pageable pageable);

  Page<Test> searchAll(String[] types, String keyword, Pageable pageable);
}
