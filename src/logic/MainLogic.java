package logic;

import parts.Mover;
import parts.Vector;
import view.MainView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MainLogic {

  private MainView mainView;
  private List<Mover> movers;
  private Vector mouse = new Vector(0, 0);
  private boolean isFollowMouse;

  public MainLogic(MainView mainView) {
    this.mainView = mainView;

    this.movers = new ArrayList<>();

    Random r = new Random();

    for (int i = 0; i < 4; i++) {
      Vector location = new Vector(mainView.getRoot().getWidth() * Math.random(),
                                   mainView.getRoot().getHeight() * Math.random());

      Mover mover = new Mover(1 + r.nextInt(5),
                              location,
                              new Vector(0, 0),
                              new Vector(0, 0));

      movers.add(mover);
      this.mainView.getRoot().getChildren().add(mover);
      mover.display();
    }

    mainView.getRoot().setOnMouseDragged(me -> {
      isFollowMouse = true;
      System.out.println(me.getX() + ", " + me.getY());
      mouse.setX(me.getX());
      mouse.setY(me.getY());

      mainView.getRoot().setOnMouseReleased(me2 -> {
        isFollowMouse = false;
      });
    });

    play();
  }

  private void play() {
    new AnimationTimer() {
      @Override
      public void handle(long now) {

        for (Mover mover : movers) {
          //Force of gravity on ball proportional to mass
          Vector gravity = new Vector(0, 0.03 * mover.getMass());

          if (isFollowMouse) {
            mover.getBall().setFill(Color.web("#77aca2"));

            //compute vector representing force of attraction between ball and mouse
            Vector ballToMouse = Vector.sub(mouse, mover.getLocation());

            /*set attraction proportional to distance between ball and mouse. 
              And inversely proportional to ball mass*/
            double mouseForceDistanceFactor = ((0.005 * ballToMouse.mag()) / mover.getMass());
            ballToMouse.normalize();
            ballToMouse.mult(mouseForceDistanceFactor);
            mover.applyForce(ballToMouse);
          } else {
            mover.getBall().setFill(Color.web("#1F7A8C"));
          }

          mover.applyForce(gravity);

          mover.update();
          mover.checkEdges(0.8);
          mover.display();
        }
      }
    }.start();
  }

}
