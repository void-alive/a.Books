package com.example.test3.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
  private int page;
  private int size;
  private int total;

  //  시작
  private int start;
  //  끝
  private int end;

  //  마지막 페이지
  private boolean prev;
  //  다음 페이지
  private boolean next;

  private List<E> dtoList;

  @Builder(builderMethodName = "withAll")
  public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
    if (total <= 0) {
      return;
    }

    this.page = pageRequestDTO.getPage();
    this.size = pageRequestDTO.getSize();

    this.total = total;
    this.dtoList = dtoList;

//    화면에서 마지막 번호
    this.end = (int) (Math.ceil(this.page / 10.0)) * 10;

//    화면에서 시작 번호
    this.start = this.end - 9;

//    데이터의 개수를 계산할 마지막 페이지 번호
    int last = (int) (Math.ceil((total / (double) size)));

    this.end = end > last ? last : end;
    this.prev = this.start > 1;
    this.next = total > this.end * this.size;
  }
}
