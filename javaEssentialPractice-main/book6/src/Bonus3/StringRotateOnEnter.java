package Bonus3;

import java.util.Scanner;

public class StringRotateOnEnter {
  public static void main(String[] args) {
    System.out.println("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 다 됩니다.");
    Scanner sc = new Scanner(System.in);
    String text = sc.nextLine();

    System.out.println("<Enter>를 입력하면 문자열이 한 글자씩 회전합니다.");

    while (true) {
      String key = sc.nextLine();

//      입력한 키가 q면 종료
      if (key.equals("q")) {
        System.out.println("종료합니다...");
        break;
      }

      if (key.equals("")) {
        String first = String.valueOf(text.charAt(0));
//        System.out.println("first : " + first);
        String last = text.substring(1);
//        System.out.println("last : " + last);
        text = last.concat(first);
        System.out.print(text + " >>");
      } else {
        System.out.println(text + " >> ");
      }
    }
    sc.close();
  }
}
