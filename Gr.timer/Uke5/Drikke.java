public class Drikke implements Drikkbar {
  int plass;
  int drikke;

  public Drikke(int plass, int drikke) {
    this.plass = plass;
    this.drikke = drikke;
  }
  @Override
  public void drikkGlass() {
    if (drikke > 2) {
      drikke -= 2;
    } else {
      drikke = 0;
    }
  }

  @Override
  public void fyllOpp() {
    drikke = plass;
  }

  @Override
  public String toString() {
    return "Flasken har plass til: " + plass + " dl drikke. Mengde drikke i flasken naa: " + drikke + " dl.";
  }
}
