public class PResept extends Hvit {

  public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    super(legemiddel, utskrivendeLege, pasientId, reit);
    this.reit = 3;
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
    if ((legemiddel.hentPris() - 108.0) > 0.0) {
      legemiddel.settNyPris(legemiddel.hentPris() - 108.0);
      return legemiddel.hentPris();
    } else {
      legemiddel.settNyPris(0.0);
      return legemiddel.hentPris();
    }
  }
}
