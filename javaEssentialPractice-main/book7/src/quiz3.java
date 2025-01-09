import java.util.HashMap;
import java.util.Scanner;

public class quiz3 {
  public static void main(String[] args) {
    System.out.println("에스프레소, 아메리카노, 카푸치노, 카페라떼 있습니다.");
    Scanner scanner = new Scanner(System.in);
//    HashMap<키, 값> 선언하고 안에 값 넣기
    HashMap<String, Integer> coffee = new java.util.HashMap<>();
    coffee.put("에스프레소", 2000);
    coffee.put("아메리카노", 2500);
    coffee.put("카푸치노", 3000);
    coffee.put("카페라떼", 3500);

    while(true){
      System.out.print("주문 >> ");
      String order = scanner.nextLine();
//      입력받은 order가 "그만"이면 중지
      if(order.equals("그만"))
        break;
//      출력
      System.out.println(order + "는 " + coffee.get(order)+ "입니다.");
    }
  }
}
