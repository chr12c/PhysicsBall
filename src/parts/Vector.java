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
    return this.x;
  }

  public double getY() {
    return this.y;
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
    this.x *= d;
    this.y *= d;
  }

  public void div(double d) {
    this.x /= d;
    this.y /= d;
  }

  public double mag() {
    return Math.sqrt(this.x * this.x + this.y * this.y);
  }

  public void normalize() {
    this.div(this.mag());
  }

  //randoms a length 1 vector
  public void random2D() {
    Random r = new Random();

    this.x = r.nextDouble();
    this.y = r.nextDouble();
    this.normalize();
  }

}
