package com.example.test3.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TestSearch {
  Page<com.example.test3.domain.Test> search1(Pageable pageable);

  Page<com.example.test3.domain.Test> searchAll(String[] types, String keyword, Pageable pageable);
}
