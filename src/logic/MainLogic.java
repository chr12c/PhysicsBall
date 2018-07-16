package logic;

import parts.Mover;
import parts.Vector;
import view.MainView;

import javafx.animation.AnimationTimer;
import javafx.util.Duration;

public class MainLogic {

  private MainView mainView;
  private Mover mover;

  public MainLogic(MainView mainView) {
    this.mainView = mainView;

    Vector location = new Vector(mainView.getRoot().getWidth() / 2,
                                 mainView.getRoot().getHeight() / 2);
    
    this.mover = new Mover(location,
                           new Vector(0, 0),
                           new Vector(-0.2, 0.7));

    this.mainView.getRoot().getChildren().add(this.mover);
    this.mover.display();                       

    play();
  }

  private void play() {
    new AnimationTimer() {
      @Override
      public void handle(long now) {
        mover.update();
        System.out.println(mover.getLocation().getX() + " " + mover.getLocation().getY());
        mover.checkEdges();
        mover.display();
      }
    }.start();
  }

}
