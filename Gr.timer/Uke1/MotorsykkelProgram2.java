class MotorsykkelProgram2 {
  public static void main(String[] args) {
    Motorsykkel2 motorsykkel = new Motorsykkel2("3412");

    int i = 0;
    while (i < 5) {
      motorsykkel.kjoer(10);
      i++;

    }
    System.out.println(motorsykkel.hentKilometerstand());

    Motorsykkel2 m2 = new Motorsykkel2("1234");
    Motorsykkel2 m3 = new Motorsykkel2("3456");

    System.out.println(m2.hentProduksjonsnummer());
    System.out.println(m3.hentProduksjonsnummer());
  }
}
