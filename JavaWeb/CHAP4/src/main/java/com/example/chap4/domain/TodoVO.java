package com.example.chap4.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoVO {
  private long tno;
  private String title;
  private LocalDate dueDate;
  private String writer;
  private boolean finished;
}
