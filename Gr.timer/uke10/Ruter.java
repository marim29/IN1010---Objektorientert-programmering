import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.ScrollPane;
import java.util.Random;
import java.util.ArrayList;

public class Ruter extends Application {
  ArrayList<Rectangle> firkanter = new ArrayList<Rectangle>();
  Random rand = new Random();
  int radteller = 1;
  public void start(Stage stage) {
    GridPane grid = new GridPane();
    Scene scene = new Scene(grid);
    stage.setScene(scene);

    Button leggTilRadKnapp = new Button("Ny rad");
    Button fargeKnapp = new Button("Sett ny farge");
    grid.setVgap(20);
    grid.setHgap(20);
    grid.add(leggTilRadKnapp, 0,0);
    grid.add(fargeKnapp, 1,0);

    leggTilRadKnapp.setOnAction(e ->{
      Rectangle a = new Rectangle(50,50);
      Rectangle b = new Rectangle(50,50);
      Rectangle c = new Rectangle(50,50);
      a.setFill(Color.BLUE);
      firkanter.add(a);
      firkanter.add(b);
      firkanter.add(c);
      grid.addRow(radteller++, a, b, c);
      stage.sizeToScene();
    });

    fargeKnapp.setOnAction(e->{
      if(firkanter.size() == 0) return;
      int i = rand.nextInt(firkanter.size());
      // while(firkanter.get(i).getFill(Color.BLUE)) {
      //
      // }

      firkanter.get(i).setFill(Color.BLUE);

    });
    stage.setMaxHeight(800);
    stage.setMinWidth(300);
    stage.setMinHeight(799);
    stage.show();
  }
}
