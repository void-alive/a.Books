package com.example.test3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Test3Application {

  public static void main(String[] args) {
    SpringApplication.run(Test3Application.class, args);
  }

}
