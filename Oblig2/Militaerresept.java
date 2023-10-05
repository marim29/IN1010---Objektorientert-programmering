public class Militaerresept extends Hvit {

  public Militaerresept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    super(legemiddel, utskrivendeLege, pasientId, reit);
  }

  @Override
  public String toString() {
    return "Legemiddel" + legemiddel + "\n Utskrivende lege: " + utskrivendeLege +
    "\n Pasient-id: " + pasientId + "\n Antall ganger igjen paa resepten: " + reit;
  }

  @Override
  public String farge() {
    return "Hvit";
  }

  @Override
  public double prisAaBetale() {
    legemiddel.settNyPris(0.0);
    return legemiddel.hentPris();
  }
}
