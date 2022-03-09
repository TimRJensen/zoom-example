package zoom_example.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {
    App.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    var root = new FXMLLoader(this.getClass().getResource("../views/index/Index.fxml"));

    primaryStage.setScene(new Scene(root.load()));
    primaryStage.setTitle("Zoom example");
    primaryStage.show();
  }
}
