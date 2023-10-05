import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

class HeiPerson extends Application {

  public TextField tekstfelt = null;

  @Override
  public void start(Stage stage) {

    Button knapp = new Button();
    TextField tekstfelt = new Textfield();
    HPos pos = new HPos(50);
    VPos pos = new VPos(50);
    VBox root = new VBox(knapp, tekstfelt, pos);

    knapp.setOnAction(new Knappebehandler<ActionEvent>());
    // Fyll inn.

    stage.setScene(new Scene(root));
    stage.show();
  }

  class Knappebehandler implements EventHandler <ActionEvent> {
      // Fyll inn.
      @Override
      public void handle(T event) {
        System.out.println("");
      }
  }
}
