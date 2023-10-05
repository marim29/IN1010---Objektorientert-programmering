class Spesialist extends Lege implements Godkjenningsfritak {
  int kontrollID;

  public Spesialist(String navn, int kontrollID) {
    super(navn);
    this.kontrollID = kontrollID;

  }
  @Override
  public int hentKontrollID() {
    return kontrollID;
  }
  @Override
  Resept skrivResept(Legemiddel legemiddel, Pasient pasient, int reit) {
    return new Hvit(legemiddel, this, pasient, reit);
  }

  @Override
  public String toString() {
    return "Lege: " + navn + "\n Kontroll-ID: " + kontrollID;
  }
}
