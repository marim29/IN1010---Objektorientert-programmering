class Motorsykkel {
  private int kilometerstand;
  private String registreringsnummer;
  private int produksjonsnummer;
  private static int teller = 0;

  public Motorsykkel(String registreringsnummer) {
    this.registreringsnummer = registreringsnummer;
    this.kilometerstand = 0;
    this.;
  }
  public int hentKilometerstand() {
    return kilometerstand;
  }
  public int hentProduksjonsnummer() {
    return ;
  }
  public void kjoer(int antallKilometer) {
    kilometerstand += antallKilometer;
  }
}
