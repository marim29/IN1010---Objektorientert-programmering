import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.Event;

public class Knapper extends Application {
  public void start(Stage stage) {
    GridPane grid = new GridPane();
    Scene scene = new Scene(grid);
    stage.setScene(scene);

    Button knapp1 = new Button("en");
    knapp1.setOnAction(new FunksjonalitetForKnapp1<ActionEvent>());

    Button knapp2 = new Button("to");
    knapp2.settInAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        System.out.println("Knappaction med anonym klasse");
      )
    });
    Button knapp3 = new Button("tre");
    knapp3.setOnAction(f -> {
      System.out.println("Knappaction med lambda-uttrykk.");

    });

    grid.add(knapp1, 0,0);
    grid.add(knapp2, 1,0);
    grid.add(knapp3, 2,0);

    stage.show();
  }

  class FunksjonalitetForKnapp1<T extends Event> implements EventHandler<T> {
    @Override
    public void handle(T event) {
      System.out.println("Knappaction med vanlig klasse");
    }
  }

}
