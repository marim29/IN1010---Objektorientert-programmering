import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.event.ActionEvent;


class App extends Application {
  public void start(Stage stage) {
    // Lager knapper.
    Button knapp = new Button();
    Button knapp2 = new Button();
    Button knapp3 = new Button();

    // 1. Måte: Med egen klasse.
    knapp.setOnAction(new FunksjonalitetForKnapp1<ActionEvent>);

    // 2. Måte: Anonym klasse.
    knapp2.setOnAction(new EventHandler<ActionEvent>) {
      @Override
      public void handle(ActionEvent e) {
        System.out.println("Knappefunksjonalitet implementert ved anonym klasse.");
      }
    });

    // 3. Måte: Lambda.
    knapp3.setOnAction(e -> {
      System.out.println("Knappefunksjonalitet implementer ved lambda-uttrykk.");
    });


    HBox root = new HBox(knapp, knapp2, knapp3);
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }
}

class FunksjonalitetForKnapp1<T extends Event> implements EventHandler<T> {
  @Override
  public void handle(T event) {
    System.out.println("Knappefunksjonalitet implementert ved vanligg klasse.");
  }
}
