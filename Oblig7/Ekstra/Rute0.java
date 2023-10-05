import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.util.Random;
import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

class Rute extends Rectangle {

  private boolean erHvit = false;
  private boolean erSvart = false;
  private ArrayList<Rute> naboer;

  public Rute() {
    super(30, 30, Color.GREY);
    setStroke(Color.WHITE);
    setOnMouseClicked(e -> gaa());
  }

  private void gaa() {
    if(erSvart) return;
    if(erHvit) {
      setFill(Color.RED);
    }
  }
  public void settNaboer(ArrayList<Rute> naboer) {
    this.naboer = naboer;
  }

  public boolean erHvit() {
    return erHvit;
  }
}
