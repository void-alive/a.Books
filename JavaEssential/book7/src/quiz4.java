import java.util.*;

public class quiz4 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("2000 ~ 2009 년까지 1년 단위로 키(cm) 입력");
    
//  키 10개 입력
    Vector<Integer> tall = new Vector<>();
    for (int i = 0; i < 10; i++) {
      tall.add(scanner.nextInt());
    }

//    다음 년도 키에서 지금 년도 키 뺀 값 ruler에 넣기
    Vector<Double> ruler = new Vector<>();
    for (int i = 1; i < tall.size(); i++) {
      ruler.add((double) tall.get(i) - (double) tall.get(i - 1));
    }

//    ruler에 있는 값 (내년도 키 - 이번년도 키) 중에서 가장 큰 값 찾기
    int maxTall = 0;
    for (int i = 1; i < ruler.size(); i++) {
      if (ruler.get(maxTall) < ruler.get(i)) {
        maxTall = i;
      }
    }

//    출력
    System.out.println("가장 키가 많이 자란 년도는 200" + maxTall + "년 " + ruler.get(maxTall) + " cm");
  }
}
