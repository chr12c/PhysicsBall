package parts;

public class Vector {

  private double x;
  private double y;

  public Vector(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public void set(Vector v) {
    this.x = v.x;
    this.y = v.y;
  }

  public void add(Vector vec) {
    this.x += vec.x;
    this.y += vec.y;
  } 

  public static Vector add(Vector vec1, Vector vec2) {
    return new Vector(vec1.x + vec2.x, vec1.y + vec2.y);
  }

  public void sub(Vector vec) {
    this.x -= vec.x;
    this.y -= vec.y;
  }

  public static Vector sub(Vector vec1, Vector vec2) {
    return new Vector(vec1.x - vec2.x, vec1.y - vec2.y);
  }

  public void mult(double d) {
    x *= d;
    y *= d;
  }

  public void div(double d) {
    x /= d;
    y /= d;
  }

  public static Vector div(Vector vec, double n) {
    return new Vector(vec.x / n, vec.y / n);
  }

  public double mag() {
    return Math.sqrt(x * x + y * y);
  }

  public void normalize() {
    this.div(this.mag());
  }

  //limit magnitude
  public void limit(double max) {
    if (mag() > max) {
      normalize();
      mult(max);
    }
  }
}
