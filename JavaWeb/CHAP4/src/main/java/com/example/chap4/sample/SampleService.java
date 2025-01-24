package com.example.chap4.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.javassist.tools.rmi.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@ToString
@RequiredArgsConstructor
public class SampleService {

  @Autowired
  private SampleDAO sampleDAO;
}
