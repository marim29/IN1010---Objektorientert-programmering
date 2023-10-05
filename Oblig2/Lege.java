public class Lege {
  String navn;

  public Lege(String navn) {
    this.navn = navn;
  }

  public String hentNavn() {
    return navn;
  }

  Resept skrivResept(Legemiddel legemiddel, int pasientId, int reit) throws UlovligUtskrift {
    Resept r = new Hvit(legemiddel, this, pasientId, reit);
    if (legemiddel instanceof PreparatA) {
      throw new UlovligUtskrift(this, legemiddel);
    }
    return r;
    }

  @Override
  public String toString() {
    return "Lege: " + navn;
  }
}
