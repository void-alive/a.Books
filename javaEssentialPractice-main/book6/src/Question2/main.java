package Question2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String a = sc.nextLine();
      if (a.equals("exit")) {
        System.out.println("종료합니다...");
        break;
      }
      StringTokenizer st = new StringTokenizer(a, " ");
      System.out.println("어절 갯수는 " +st.countTokens());
    }
  }
}
