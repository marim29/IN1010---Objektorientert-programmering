 abstract public class Resept {
  private int id;
  protected Legemiddel legemiddel;
  protected Lege utskrivendeLege;
  protected Pasient pasient;
  protected int reit;
  private static int teller;

  public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
    this.id = teller++;
    this.legemiddel = legemiddel;
    this.utskrivendeLege = utskrivendeLege;
    this.pasient = pasient;
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

  public Pasient hentPasient() {
    return pasient;
  }

  public int hentReit() {
    return reit;
  }

  public boolean bruk() {
    return reit != 0;
  }

  public void hentLegemiddeltype() {
    
  }

  abstract public String farge();

  abstract double prisAaBetale();


  public String toString() {
    return "Legemiddel: " + legemiddel + "\n Utskrivende lege: " +
    utskrivendeLege + "\n Pasient: " + pasient + "Antall ganger igjen paa resepten: " + reit;
  }
}
