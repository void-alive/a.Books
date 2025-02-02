package com.example.test3.service;

import com.example.test3.domain.Test;
import com.example.test3.dto.PageRequestDTO;
import com.example.test3.dto.PageResponseDTO;
import com.example.test3.dto.TestDTO;
import com.example.test3.repository.TestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class TestServiceImpl implements TestService {
  private final ModelMapper modelMapper;
  private final TestRepository testRepository;

  @Override
  public Long register(TestDTO testDTO) {
    Test test = modelMapper.map(testDTO, Test.class);
    Long bno = testRepository.save(test).getBno();
    return bno;
  }

  @Override
  public TestDTO readOne(Long bno) {
    Optional<Test> result = testRepository.findById(bno);
    Test test = result.orElseThrow();
    TestDTO testDTO = modelMapper.map(test, TestDTO.class);
    return testDTO;
  }

  @Override
  public void modify(TestDTO testDTO) {
    Optional<Test> result = testRepository.findById(testDTO.getBno());
    Test test = result.orElseThrow();
    test.change(testDTO.getTitle(), testDTO.getContent());
    testRepository.save(test);
  }

  @Override
  public void remove(Long bno) {
    testRepository.deleteById(bno);
  }

  @Override
  public PageResponseDTO<TestDTO> list(PageRequestDTO pageRequestDTO) {
    String[] types = pageRequestDTO.getTypes();
    String keyword = pageRequestDTO.getKeyword();
    Pageable pageable = pageRequestDTO.getPageable("bno");

    Page<Test> result = testRepository.search1(pageable);

    List<TestDTO> dtoList = result.getContent().stream()
            .map(test -> modelMapper.map(test,TestDTO.class)).collect(Collectors.toList());

    return PageResponseDTO.<TestDTO>withAll()
            .pageRequestDTO(pageRequestDTO)
            .dtoList(dtoList)
            .total((int)result.getTotalElements())
            .build();
  }
}
