import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;

public class Labyrint {
  public int rader;
  public int kolonner;
  public Rute[][] rutenett;
  public Lenkeliste<String> utveier = new Lenkeliste<String>();

  private Labyrint(int kolonner, int rader, Rute[][] rutenett) {
    this.kolonner = kolonner;
    this.rader = rader;
    this.rutenett = rutenett;
    settLabyrint();

  }
  public static Labyrint lesFraFil(File fil) throws FileNotFoundException {
    Scanner scanner = new Scanner(fil);

    String innlest = scanner.nextLine();
    String[] dimensjoner = innlest.split(" ");
    int kolonner = Integer.parseInt(dimensjoner[0]);
    int rader = Integer.parseInt(dimensjoner[1]);

    Rute[][] lab = new Rute[rader][kolonner];

    int x = 0;
    while(scanner.hasNextLine()) {
      innlest = scanner.nextLine();

      for(int y = 0; y < kolonner; y++) {
        if((y == 0 || x == 0 || y == kolonner-1 || x == rader-1) && innlest.charAt(y) == '.') {
        // if((x == 0 || x == rader-1) && tegn[x] == ".") {
          Aapning aapning = new Aapning(y, x);
          lab[x][y] = aapning;
        // } else if(tegn[x] == ".") {
        }  if((y != 0 && x != 0 && y != kolonner-1 && x != rader-1) && innlest.charAt(y) == '.') {
          HvitRute hvit = new HvitRute(y, x);
          lab[x][y] = hvit;
        }  if(innlest.charAt(y) == '#') {
        // } else if(tegn[x] == "#") {
          SortRute sort = new SortRute(y, x);
          lab[x][y] = sort;
        }
      }
      x++;
    }

    Labyrint innlestLabyrint = new Labyrint(kolonner, rader, lab);
    // Gir informasjon om naboene til hver av rutene. ?
    for(int i = 0; i < rader; i++) {
      for(int y = 0; y < kolonner; y++) {
        Rute[] naboer = innlestLabyrint.finnNaboer(lab[i][y]);
      }
    }
    return innlestLabyrint;
  }

  private void settLabyrint() {
    for(int x = 0; x < rader; x++) {
      for(int y = 0; y < kolonner; y++) {
        rutenett[x][y].settLabyrint(this);
      }
    }
  }


  public  Rute[] finnNaboer(Rute rute) {

    // legg til i naboliste og returner listen.
    Rute[] naboer = new Rute[4];

    if(rute.rad > 0) {
      rute.nord = rutenett[rute.rad-1][rute.kolonne];
      naboer[0] = rute.nord;
    }
    if(rute.rad+1 < rader) {
      rute.soer = rutenett[rute.rad+1][rute.kolonne];
      naboer[1] = rute.soer;
    }
    if(rute.kolonne > 0) {
      rute.vest = rutenett[rute.rad][rute.kolonne-1];
      naboer[2] = rute.vest;
    }
    if(rute.kolonne+1 < kolonner) {
      rute.oest = rutenett[rute.rad][rute.kolonne+1];
      naboer[3] = rute.oest;
    }
    return naboer;
  }

  public Lenkeliste<String> finnUtveiFra(int kol, int rad) {
    rutenett[rad-1][kol-1].finnUtvei();
    // System.out.println("Antall utveier: " + utveier.stoerrelse());
    System.out.println("\nAntall utveier funnet: " + utveier.stoerrelse());
    return utveier;
  }

  @Override
  public String toString() {
    String s = "";
    for(int x = 0; x < rader; x++) {
      for(int y = 0; y < kolonner; y ++) {
        s += rutenett[x][y].chartilTegn();
      }
      s += "\n";
    }
    return s;
  }
}
