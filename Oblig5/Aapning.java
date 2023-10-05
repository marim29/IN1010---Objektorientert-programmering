public class Aapning extends HvitRute {

  public Aapning(int kolonne, int rad) {
    super(kolonne, rad);

  }
  @Override
  public boolean besoekt() {
    return besoekt;
  }

  @Override
  public void gaa(String s) {
    besoekt = true;
    String denne = "(" + (this.kolonne+1) + "," + (this.rad+1) + ")";
    s += denne;
    System.out.println("Fant en utvei: " + denne);
    labyrint.utveier.leggTil(denne);
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
