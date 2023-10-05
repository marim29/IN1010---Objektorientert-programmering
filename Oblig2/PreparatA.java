class PreparatA extends Legemiddel {
  int styrke;

  public PreparatA(String navn, double pris, double virkestoff, int styrke) {
    super(navn, pris, virkestoff);
    this.styrke = styrke;

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

  public int hentNarkotiskStyrke() {
    return styrke;
  }

  @Override
  public String toString() {
    return super.toString() + "\n Narkotisk styrke: " + styrke;
  }
}
