import java.util.Scanner;
import java.util.StringTokenizer;

public class StringToken {
  public static void main(String[] args) {
    int sum = 0;
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    StringTokenizer st = new StringTokenizer(s, "+");

    while (st.hasMoreTokens()) {
//      token이라는 변수에 다음번 토큰을 가져옴. 이후 그 토큰의 공백을 제거함
      String token = st.nextToken().trim();
//      공백을 제거한 token을 int형 num이라는 변수에 저장
      int num = Integer.parseInt(token);
//      sum = sum+num. sum이라는 변수에 합을 저장
      sum += num;
    }
    System.out.println("합은 " + sum);
  }
}