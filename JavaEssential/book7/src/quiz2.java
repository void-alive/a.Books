import java.util.ArrayList;
import java.util.Scanner;

public class quiz2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> array = new ArrayList<>();
    System.out.print("빈 칸으로 분리하여 5 개의 학점을 입력(A/B/C/D/F) >>");

//    학점 5개 입력하고 넣기
    for (int i = 0; i < 5; i++) {
      array.add(scanner.next());
    }

//    array의 i번째가 a랑 같으면 그 인덱스를 index라는 변수에 넣는다
//    array의 index번째 값을 삭제하고 그 자리에 "4.0"이라는 값을 넣는다
    for (int i = 0; i < 5; i++) {
      if (array.get(i).equals("A")) {
        int index = array.indexOf("A");
        array.remove(index);
        array.add(index, "4.0");
      } else if (array.get(i).equals("B")) {
        int index = array.indexOf("B");
        array.remove(index);
        array.add(index, "3.0");
      } else if (array.get(i).equals("C")) {
        int index = array.indexOf("C");
        array.remove(index);
        array.add(index, "2.0");
      } else if (array.get(i).equals("D")) {
        int index = array.indexOf("D");
        array.remove(index);
        array.add(index, "1.0");
      } else {
        int index = array.indexOf("F");
        array.remove(index);
        array.add(index, "0.0");
      }
    }

//    출력
    for (int i = 0; i < 5; i++) {
      System.out.print(array.get(i) + " ");
    }
  }
}
