package logic;

import parts.Mover;
import parts.Vector;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MainLogic {

  private Mover mover;
  private Circle ball;

  public MainLogic(Circle circle) {
    this.ball = circle;
    this.mover = new Mover(new Vector(ball.getLayoutX(), ball.getLayoutY()),
                           new Vector(0, 0),
                           new Vector(-0.001, 0.005));
  }

  public void playTimeline() {
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
      new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
          mover.update();
          ball.setLayoutX(mover.getLocation().getX());
          ball.setLayoutY(mover.getLocation().getY());

          System.out.println(mover.getLocation().getX() + " , " + mover.getLocation().getY());

          mover.checkEdges();
        }
      }
    ));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
  }
}
