package view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;

public class MainView {

  public static int WIDTH = 300;
  public static int HEIGHT = 300;

  private Pane root;
  private Scene scene;

  private Circle ball;

  public MainView() {
    this.root = new Pane();
    this.root.setStyle("-fx-background-color: black;");

    this.scene = new Scene(root, WIDTH, HEIGHT);

    this.ball = new Circle(10, Color.LAWNGREEN);
    this.ball.relocate(WIDTH / 2, HEIGHT / 2);

    this.root.getChildren().add(ball);
  }

  public Scene getScene() {
    return this.scene;
  }

  public Circle getBall() {
    return this.ball;
  }

}
