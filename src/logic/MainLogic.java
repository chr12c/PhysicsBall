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

public class MainLogic {

  private MainView mainView;

  private List<Mover> movers;

  private Vector mouse = new Vector(0, 0);

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

    mainView.getRoot().setOnMouseMoved(me -> {
      System.out.println(me.getX() + ", " + me.getY());
      mouse.setX(me.getX());
      mouse.setY(me.getY());
    });

    //playMouseAttraction();
    playGravity();
  }

  private void playMouseAttraction() {
    new AnimationTimer() {
      @Override
      public void handle(long now) {

        for (Mover mover : movers) {
          //compute vector representing force of attraction between ball and mouse
          Vector ballToMouse = Vector.sub(mouse, mover.getLocation());
          /*set attraction proportional to distance between ball and mouse. 
            And inversely proportional to ball mass*/
          double mouseForceDistanceFactor = ((0.005 * ballToMouse.mag()) / mover.getMass());
          ballToMouse.normalize();
          ballToMouse.mult(mouseForceDistanceFactor);
          mover.applyForce(ballToMouse);

          mover.update();
          mover.checkEdges();
          mover.display();
        }
      }
    }.start();
  }

  private void playGravity() {
    new AnimationTimer() {
      @Override
      public void handle(long now) {

        for (Mover mover : movers) {
          //Force of gravity on ball proportional to mass
          Vector gravity = new Vector(0, 0.04 * mover.getMass());

          mover.applyForce(gravity);

          mover.update();
          mover.checkEdges(0.8);
          //mover.checkEdges();
          mover.display();
        }
      }
    }.start();
  }



}
