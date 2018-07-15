package parts;

import parts.Vector;

public class Mover {
  //hard code constants for demo. Mimicks dimensions of MainView components
  private static final int WIDTH = 300;
  private static final int HEIGHT = 300;
  private static final int RADIUS = 10;

  private Vector location;
  private Vector velocity;
  private Vector acceleration;

  public Mover(Vector location, Vector velocity) {
    this.location = location;
    this.velocity = velocity;
  }

  public Mover(Vector location, Vector velocity, Vector acceleration) {
    this.location = location;
    this.velocity = velocity;
    this.acceleration = acceleration;
  }

  public Vector getLocation() {
    return this.location;
  }

  public Vector getVelocity() {
    return this.velocity;
  }

  public Vector getAcceleration() {
    return this.acceleration;
  }

  public void setVelocity(Vector velocity) {
    this.velocity = velocity;
  }

  public void update() {
    velocity.add(acceleration);
    location.add(velocity);
  }

  public void checkEdges() {
    if (location.getX() <= 0 + RADIUS ||
        location.getX() >= WIDTH - RADIUS) {
      velocity.setX(-velocity.getX());
    }

    if (location.getY() >= HEIGHT - RADIUS ||
        location.getY() <= 0 + RADIUS) {
      velocity.setY(-velocity.getY());
    }
  }
}
