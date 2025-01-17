import java.util.*;

public class quiz6 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("** 포인트 관리 프로그램입니다 **");
    HashMap<String, Integer> hash = new HashMap<>();

    while (true) {
      System.out.print("이름과 포인트 입력 >> ");
      String name = sc.next();

//      name이 exit이면 끝내기
      if (name.equals("exit")) {
        System.out.println("프로그램을 종료합니다...");
        break;
      }

      Integer point = sc.nextInt();


      if(hash.containsKey(name)) {
        hash.put(name, hash.get(name) + point);
      }else{
        hash.put(name, point);
      }

      Set<String> keys = hash.keySet();
      Iterator<String> it = keys.iterator();
      while (it.hasNext()) {
        String key = it.next();
        Integer value = hash.get(key);
        System.out.print("(" + key + "," + value + ")");
      }
      System.out.println();
    }
  }
}
