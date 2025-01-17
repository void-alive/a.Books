import java.util.HashMap;
import java.util.Scanner;

public class quiz5_1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("나라 이름과 인구를 5개 입력하세요.(예 : korea 50000)");
    HashMap<String, Integer> nations = new HashMap<>();
    for (int i = 0; i < 5; i++) {
      System.out.print("나라 이름, 인구 >> ");
      String nationName = sc.next();
      int nationPeople = sc.nextInt();
      nations.put(nationName, nationPeople);
    }

    int num1=0;
    String name = "";

    //    반복문을 사용하여 입력된 키를 모두 출력
    for (String key : nations.keySet()) {
    //      꺼내온 키를 기준으로 인구수 출력
      int people = nations.get(key);
    //      가장 많은 인구 수를 저장한 변수와 현재 인구 수를 비교
      if (num1 < people) {
    //        기존 인구수가 현재 인구수보다 적을 경우 저장
        num1 = people;
    //        현재 인구수와 연동되는 key 도 함께 저장
        name = key;
      }
    }
    System.out.println("제일 인구가 많은 나라는 (" + name + ", " + num1 + ")");
  }
}
