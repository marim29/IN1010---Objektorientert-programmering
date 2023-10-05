import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

class Scener extends Application {
  public void start(Stage stage) {
    Button knapp = new Button("Trykk her!");
    HBox root = new HBox();
    Scene scene = new Scene(root);

    Button knapp2 = new Button("Ikke trykk her!");
    TextField tekstfelt = new TextField();
    Rectangle firkant = new Rectangle(50, 50);

    VBox root2 = new VBox(knapp2, tekstfelt, firkant);
    Scene scene2 = new Scene(root2);

    knapp.setOnAction(e -> {
      stage.setScene(scene2);
    });

    firkant.setOnMouseClicked(f -> {
      String s = tekstfelt.getCharacters().toString();
      knapp2.setText(s);
    });

    stage.setScene(scene);
    stage.show();
  }
}
