package view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;

public class MainView {

  public static int WIDTH = 300;
  public static int HEIGHT = 300;

  private Pane root;
  private Scene scene;

  public MainView() {
    this.root = new Pane();
    this.root.setStyle("-fx-background-color: black;");

    this.scene = new Scene(root, WIDTH, HEIGHT);
  }

  public Pane getRoot() {
    return this.root;
  }

  public Scene getScene() {
    return this.scene;
  }

}
