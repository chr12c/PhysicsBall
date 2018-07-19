package parts;

import parts.Vector;

import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;

public class Mover extends Region {

  private double mass;
  private double ballRadius;
  private Circle ball;

  private Vector location;
  private Vector velocity;
  private Vector acceleration;

  private double maxSpeed = 5;

  public Mover(Vector location, Vector velocity) {
    this.mass = 1;
    this.ballRadius = 8 * mass;
    this.location = location;
    this.velocity = velocity;
  }

  public Mover(double mass, Vector location, Vector velocity, Vector acceleration) {
    this.mass = mass;
    this.ballRadius = 8 * mass;

    ball = new Circle(ballRadius, Color.GREEN);
    ball.setStroke(Color.LAWNGREEN);
    ball.setStrokeWidth(3);
    ball.setCenterX(ballRadius);
    ball.setCenterY(ballRadius);

    this.location = location;
    this.velocity = velocity;
    this.acceleration = acceleration;

    this.getChildren().add(ball);
  }

  public double getMass() {
    return this.mass;
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

  public void applyForce(Vector force) {
    acceleration.add(Vector.div(force, mass));
  }

  public void update() {
    velocity.add(acceleration);
    velocity.limit(maxSpeed);
    location.add(velocity);
    acceleration.mult(0);//remove acceleration to prevent incorrect accumulation
  }

  //hard code the pane HEIGHT & WIDTH for now
  public void checkEdges() {
    if (location.getX() < 0 + ballRadius) {
      location.setX(0 + ballRadius);
      velocity.setX(-velocity.getX());
    } else if (location.getX() > 300 - ballRadius) {
      location.setX(300 - ballRadius);
      velocity.setX(-velocity.getX());
    }

    if (location.getY() > 300 - ballRadius) {
      location.setY(300 - ballRadius);
      velocity.setY(-velocity.getY());
    } else if (location.getY() < 0 + ballRadius) {
      location.setY(0 + ballRadius);
      velocity.setY(-velocity.getY());
    }
  }

  //coefficient of friction on window edges
  public void checkEdges(double coeff) {
    if (location.getX() < 0 + ballRadius) {
      location.setX(0 + ballRadius);
      velocity.setX(-velocity.getX() * coeff);
    } else if (location.getX() > 300 - ballRadius) {
      location.setX(300 - ballRadius);
      velocity.setX(-velocity.getX() * coeff);
    }

    if (location.getY() > 300 - ballRadius) {
      location.setY(300 - ballRadius);
      velocity.setY(-velocity.getY() * coeff);
    } else if (location.getY() < 0 + ballRadius) {
      location.setY(0 + ballRadius);
      velocity.setY(-velocity.getY() * coeff);
    }
  }

  public void display() {
    relocate(location.getX() - ballRadius, location.getY() - ballRadius);
  }

}
