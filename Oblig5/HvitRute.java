public class HvitRute extends Rute {

  public HvitRute(int kolonne, int rad) {
    super(kolonne, rad);
  }

  @Override
  public boolean besoekt() {
    return besoekt;
  }

  @Override
  public void gaa(String s) {
    besoekt = true;
    String denne = "(" + (this.kolonne+1) + "," + (this.rad+1) + ") --> ";
    s += denne;
    System.out.print(denne);

    Rute[] naboruter = labyrint.finnNaboer(this);

    for(int x = 0; x < naboruter.length; x++) {
      if(naboruter[x] != null && naboruter[x].besoekt() == false){
        naboruter[x].gaa(s);
      }
    }
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
