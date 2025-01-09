package quiz7;

import java.util.*;

public class quiz7 {
  public static void main(String[] args) {
    System.out.println("쥐가 이동한 위치(x,y)를 5개 입력해라");
    Scanner sc = new Scanner(System.in);
    ArrayList<Location> travel = new ArrayList<>();

//    시작
    travel.add(new Location(0, 0));

    for (int i = 0; i < 5; i++) {
      System.out.print(">> ");
      int x = sc.nextInt();
      int y = sc.nextInt();
      travel.add(new Location(x, y));
    }
    travel.add(new Location(0, 0));

    double sum = 0.0;
    for (int i = 0; i < travel.size() - 1; i++) {
      double d = travel.get(i).distance(travel.get(i + 1));
      sum += d;
    }
    System.out.println("총 이동 거리는 : " + sum);
    sc.close();
  }
}
