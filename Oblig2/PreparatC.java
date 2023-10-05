class PreparatC extends Legemiddel {

  public PreparatC(String navn, double pris, double virkestoff) {
    super(navn, pris, virkestoff);
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

  public void settNyPris(int nyPris) {
    pris = nyPris;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
