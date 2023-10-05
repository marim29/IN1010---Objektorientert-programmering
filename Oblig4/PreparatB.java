class PreparatB extends Legemiddel {
  int styrke;

  public PreparatB(String navn, double pris, double virkestoff, int styrke) {
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

  public int hentVanedannendeStyrke() {
    return styrke;
  }

  @Override
  public String toString() {
    return super.toString() + "\n Vanedannende styrke: " + styrke;
  }
}
