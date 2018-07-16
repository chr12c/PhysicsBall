package parts;

import parts.Vector;

import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;

public class Mover extends Region {

  private Circle ball;
  private double ballRadius = 10;

  private Vector location;
  private Vector velocity;
  private Vector acceleration;

  private double maxSpeed = 20;

  public Mover(Vector location, Vector velocity) {
    this.location = location;
    this.velocity = velocity;
  }

  public Mover(Vector location, Vector velocity, Vector acceleration) {
    ball = new Circle(ballRadius, Color.LAWNGREEN);
    ball.setCenterX(ballRadius);
    ball.setCenterY(ballRadius);

    this.location = location;
    this.velocity = velocity;
    this.acceleration = acceleration;

    this.getChildren().add(ball);
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
    velocity.limit(maxSpeed);
    location.add(velocity);
    acceleration.mult(0);//remove acceleration
  }

  //hard code the pane HEIGHT & WIDTH for now
  public void checkEdges() {
    if (location.getX() < 0 + ballRadius) {
      velocity.setX(-velocity.getX());
      location.setX(0 + ballRadius);
    } else if (location.getX() > 300 + ballRadius) {
      velocity.setX(-velocity.getX());
      location.setX(300 - ballRadius);
    }

    if (location.getY() > 300 - ballRadius) {
      location.setY(300 - ballRadius);
      velocity.setY(-velocity.getY());
    } else if (location.getY() < 0 + ballRadius) {
      velocity.setY(-velocity.getY());
      location.setY(0 + ballRadius);
    }
  }

  public void display() {
    relocate(location.getX() - ballRadius, location.getY() - ballRadius);
    /*these are all the same in context of a Pane*/
    //setLayoutX(location.getX() - ballRadius);
    //setLayoutY(location.getY() - ballRadius);
    //setTranslateX(location.getX() - ballRadius);
    //setTranslateY(location.getY() - ballRadius);
  }

}
