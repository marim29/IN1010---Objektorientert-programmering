public class Legemiddel {
  public int id;
  String navn;
  double pris;
  double virkestoff;
  static int teller;

  public Legemiddel(String navn, double pris, double virkestoff) {
    this.id = teller++;
    this.navn = navn;
    this.pris = pris;
    this.virkestoff = virkestoff;
  }

  public int hentId() {
    return id;
  }

  public String hentNavn() {
    return navn;
  }

  public double hentPris() {
    return pris;
  }

  public double hentVirkestoff() {
    return virkestoff;
  }

  public void settNyPris(double nyPris) {
    pris = nyPris;
  }

  @Override
  public String toString() {
    return "ID: " + id + "\n Navn: " + navn + "\n Pris: " + pris + "\n Virkestoff: "
 + virkestoff;  }
}
