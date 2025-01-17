package Bonus1;

public class CircleManager {
  public static void main(String[] args){
    Circle a = new Circle(1,2,10);
    Circle b = new Circle(5,6,10);
    System.out.println("원 1 : " + a);
    System.out.println("원 2 : " + b);
    if(a.equals(b)){
      System.out.println("같은 원입니다");
    }
    else{
      System.out.println("다른 원입니다.");
    }
  }
}
