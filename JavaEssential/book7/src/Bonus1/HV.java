package Bonus1;

import java.util.*;

public class HV {
  public static Vector<String> hastToVector(HashMap<String, String> h) {
    Vector<String> v = new Vector<>();
    Set<String> s = h.keySet();
    Iterator<String> it = s.iterator();
    while (it.hasNext()) {
      String key = it.next();
      v.add(h.get(key));
    }
    return v;
  }

  public static void main(String[] args) {
    HashMap<String, String> h = new HashMap<>();
    h.put("범죄", "112");
    h.put("화재", "119");
    h.put("전화번호", "114");
    Vector<String> v = hastToVector(h);
    for (int n = 0; n < v.size(); n++) {
      System.out.println(v.get(n) + " ");
    }
  }
}
