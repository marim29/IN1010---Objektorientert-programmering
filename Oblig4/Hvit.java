public class Hvit extends Resept {

  public Hvit(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
    super(legemiddel, utskrivendeLege, pasient, reit);
  }

  @Override
  public String toString() {
    return "Legemiddel" + legemiddel + "\n Utskrivende lege: " + utskrivendeLege +
    "\n Pasient: " + pasient + "\n Antall ganger igjen paa resepten: " + reit;
  }

  @Override
  public String farge() {
    return "Hvit";
  }

  @Override
  public double prisAaBetale() {
    return legemiddel.hentPris();
  }
}
