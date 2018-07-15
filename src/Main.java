import view.MainView;
import logic.MainLogic;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage stage) {

    MainView mainView = new MainView();
    MainLogic mainLogic = new MainLogic(mainView.getBall());

    stage.setTitle("mover");
    stage.setScene(mainView.getScene());
    stage.show();
    
    mainLogic.playTimeline();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
