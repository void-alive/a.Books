package OpenChallange1;

import java.util.Scanner;

public class Histogram {
  public String readString() {
    StringBuffer sb = new StringBuffer();
    Scanner sc = new Scanner(System.in);
    while (true) {
      String line = sc.nextLine();
      if (line.equals(";"))
        break;
      sb.append(line);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
//    Histrogram 클래스 객체 h 생성
//    String 타입의 input 변수에 Histogram 클래스에 있는 readString()함수 결과값 대입
//    배열 26칸 (영문자 넣기)
    Histogram h = new Histogram();
    String input = h.readString();
    int[] freq = new int[26];

//    toCharArray() : String 문자열을 char형 배열로 바꿔서 변환
//    char c가 input의 끝에 도달할 때 까지

    for (char c : input.toCharArray()) {
//      변수 c 에서 a의 값 (아스키코드 기준 97)을 뺀 값 저장. 그리고 다음 배열로 넘어감
      freq[c - 'a']++;
    }

    System.out.println("히스토그램을 그립니다.");

    for (int i = 0; i < freq.length; i++) {
//      만약에 freq 배열의 i번째가 0보다 크다면
      if (freq[i] > 0) {
        System.out.print((char) (i + 'A') + "(" + freq[i] + ") ");
//        j가 freq[i]번째까지
        for (int j = 0; j < freq[i]; j++) {
          System.out.print("-");
        }
        System.out.println();
      }
    }
  }
}
