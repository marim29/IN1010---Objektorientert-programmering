import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.util.Random;
import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Aapning extends HvitRute {

  public Aapning(int kolonne, int rad) {
    super(kolonne, rad);
    this.setFill(Color.WHITE);

  }
  @Override
  public boolean besoekt() {
    return besoekt;
  }

  @Override
  public void gaa(String s) {
    setFill(Color.YELLOW);
    String denne = "(" + (this.kolonne) + "," + (this.rad) + ")";
    s += denne;
    System.out.println("Fant en utvei: " + s);
    labyrint.utveier.leggTil(s);
  }

  @Override
  public void finnUtvei() {
    return;
  }

  @Override
  public String chartilTegn() {
    return ".";
  }
}
