import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.util.Random;
import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class HvitRute extends Rute {

  public HvitRute(int kolonne, int rad) {
    super(kolonne, rad);
    this.setFill(Color.WHITE);
  }

  // Metoden skal ta inn koordinater som brukes til å finne utvei fra
  // Labyrint.loesningStringTilTabell

  public void klikk() {
    Lenkeliste<String> list = labyrint.finnUtveiFra(rad, kolonne);
    if (list.stoerrelse() == 0) {
      return;
    }

    for (int i = 0; i < labyrint.rutenett.length; i++) {
      for (int j = 0; j < labyrint.rutenett[i].length; j++) {
        if (labyrint.rutenett[i][j] instanceof HvitRute) {
          labyrint.rutenett[i][j].setFill(Color.WHITE);
          besoekt = false;
        }
      }
    }
    
    String valgt = list.hent(0);
    boolean[][] loesning = labyrint.losningStringTilTabell(valgt, labyrint.kolonner, labyrint.rader);

    for (int i = 0; i < loesning.length; i++) {
      for (int j = 0; j < loesning[i].length; j++) {
        if (loesning[i][j] == true) {
          labyrint.rutenett[i][j].setFill(Color.YELLOW);
        }
        besoekt = false;
      }
    }
  }


  @Override
  public boolean besoekt() {
    return besoekt;
  }

  @Override
  public void gaa(String s) {
    besoekt = true;
    String denne = "(" + (this.kolonne) + "," + (this.rad) + ") --> ";
    s += denne;
    Rute[] naboruter = labyrint.finnNaboer(this);

    for(int x = 0; x < naboruter.length; x++) {
      if(naboruter[x] != null && naboruter[x].besoekt() == false){
        naboruter[x].gaa(s);
      }
    }
    besoekt = false;
  }

  @Override
  public void finnUtvei() {
    this.gaa("");
  }

  @Override
  public String chartilTegn() {
    return ".";
  }
}
