package Bonus1;

public class Circle {
  private int x,y,radius;
  public Circle(int x, int y, int radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }
  public String toString(){
    return "(" + x + "," + y + ") 반지름 " + radius;
  }
  public boolean equals(Object obj){
    Circle c = (Circle)obj;
    if(radius == c.radius){
      return true;
    }
    else
      return false;
  }
}
