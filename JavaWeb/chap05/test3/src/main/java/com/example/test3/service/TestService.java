package com.example.test3.service;

import com.example.test3.dto.PageRequestDTO;
import com.example.test3.dto.PageResponseDTO;
import com.example.test3.dto.TestDTO;

public interface TestService {
  Long register(TestDTO testDTO);
  TestDTO readOne(Long bno);
  void modify(TestDTO testDTO);
  void remove(Long bno);
  PageResponseDTO<TestDTO> list(PageRequestDTO pageRequestDTO);
}
