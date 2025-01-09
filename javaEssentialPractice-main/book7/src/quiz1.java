import java.util.Scanner;
import java.util.Vector;

public class quiz1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Vector<Double> v = new Vector<Double>();

//    벡터에 5번 넣기
    for (int i = 0; i < 5; i++) {
      v.add(scanner.nextDouble());
    }

    int maxValue = 0;
//    1,2,3,4. 4번 반복
//    get의 0번이 get의 i번(1,2,3,4)보다 작다면 maxlValue에 i 값 넣기
//    0-1, 0-2, 0-3, 0-4 식으로 비교. 가장 큰 값을 maxValue에 넣게 됨
    for (int i = 1; i < v.size(); i++) {
      if (v.get(maxValue) < v.get(i)) {
        maxValue = i;
      }
    }

    System.out.println("가장 큰 수는 " + v.get(maxValue));
  }
}
