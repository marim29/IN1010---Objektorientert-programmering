class MotorsykkelProgram {
  public static void main(String[] arg) {
    Motorsykkel motorsykkel = new Motorsykkel("12345");

    for (int i = 0; i <5; i++) { motorsykkel.kjoer(10); }
    System.out.println("Kilometerstanden er paa " + motorsykkel.hentKilometerstand() + " kilometer.");

    Motorsykkel motorsykkel2 = new Motorsykkel("34567");
    Motorsykkel motorsykkel3 = new Motorsykkel("57848");

    System.out.println("Produksjonsnummer motorsykkel 2: " + motorsykkel2.hentProduksjonsnummer());
    System.out.println("Produksjonsnummer motorsykkel 3: " + motorsykkel3.hentProduksjonsnummer());
  }
}
