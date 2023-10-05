class Motorsykkel2 {
  private int kilometerstand;
  private String registreringsnummer;
  private int produksjonsnummer;
  private static int teller = 0;

  public Motorsykkel2(String registreringsnummer) {
    this.kilometerstand = 0;
    this.registreringsnummer = registreringsnummer;

    this.produksjonsnummer = teller;
    teller++;
  }
  public int hentKilometerstand() {
    return kilometerstand;
  }
  public int hentProduksjonsnummer() {
    return produksjonsnummer;
  }
  public void kjoer(int antallKilometer) {
    kilometerstand += antallKilometer;
  }
}
