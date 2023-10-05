 abstract public class Resept {
  private int id;
  Legemiddel legemiddel;
  Lege utskrivendeLege;
  int pasientId;
  int reit;
  static int teller;

  public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    this.id = teller++;
    this.legemiddel = legemiddel;
    this.utskrivendeLege = utskrivendeLege;
    this.pasientId = pasientId;
    this.reit = reit;
  }

  public int hentId() {
    return id;
  }

  public Legemiddel hentLegemiddel() {
    return legemiddel;
  }

  public Lege utskrivendeLege() {
    return utskrivendeLege;
  }

  public int hentPasientId() {
    return pasientId;
  }

  public int hentReit() {
    return reit;
  }

  public boolean bruk() {
    return reit != 0;
  }

  abstract public String farge();

  abstract double prisAaBetale();

  @Override
  public String toString() {
    return "Legemiddel: " + legemiddel + "\n Utskrivende lege: " +
    utskrivendeLege + "\n Pasient-id: " + pasientId + "Antall ganger igjen paa resepten: " + reit;
  }
}
