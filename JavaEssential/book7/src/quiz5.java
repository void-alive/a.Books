import java.util.*;

public class quiz5 {
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

    Comparator<Map.Entry<String, Integer>> comparator
            = new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1,
                         Map.Entry<String, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
      }
    };

    Map.Entry<String, Integer> maxEntry
            = Collections.max((Collection<? extends Map.Entry<String, Integer>>) nations.entrySet()
            , comparator);

    System.out.println("제일 인구가 많은 나라는 (" + maxEntry.getKey() + ", " + maxEntry.getValue() + ")");
  }
}
