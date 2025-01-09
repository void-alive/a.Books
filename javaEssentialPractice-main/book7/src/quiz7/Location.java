package quiz7;

public class Location {
  private int x;
  private int y;

  public Location(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Location b) {
    double d = (x - b.x) * (x - b.x) + (y - b.y) * (y - b.y);
    return Math.sqrt(d);
  }
}
