package Question3;

public class d {
  public static void main(String[] args) {
    int array[] = new int[3];
    for (int i = 0; i < array.length; i++) {
      array[i] = 0;
    }

    while (true) {
      for (int i = 0; i < array.length; i++) {
        array[i] = (int) ((Math.random() * 3) + 1);
      }
      for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + "\t");
      }
      System.out.println();
      
      if (array[0] == array[1] && array[1] == array[2]
              && array[2] == array[0]) {
        System.out.println("성공");
        break;
      }
    }
  }
}
