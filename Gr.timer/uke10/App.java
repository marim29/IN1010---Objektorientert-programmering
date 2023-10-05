import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public class App extends Application {
  public void start(Stage stage) {
    GridPane grid = new GridPane();
    Scene scene = new Scene(grid);

    Text en = new Text("  1  ");
    Text to = new Text("  2  ");
    Text tre = new Text("  3  ");
    Text fire = new Text("  4  ");
    Text fem = new Text("  5  ");
    Text seks = new Text("  6  ");

    grid.add(en, 0,0);
    grid.add(en, 1,0);
    grid.add(en, 1,1);
    grid.add(en, 0,0);
    grid.add(en, 2,0);
    grid.add(en, 2,1);

    stage.setScene(scene);
    stage.show();
  }
}
