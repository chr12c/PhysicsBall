package parts;

import java.util.Random;

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

  public void add(Vector vec) {
    this.x += vec.x;
    this.y += vec.y;
  } 

  public void sub(Vector vec) {
    this.x -= vec.x;
    this.y -= vec.y;
  }

  public void mult(double d) {
    x *= d;
    y *= d;
  }

  public void div(double d) {
    x /= d;
    y /= d;
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
