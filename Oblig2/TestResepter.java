class TestResepter {
  public static void main(String[] args) {

    Legemiddel legem = new PreparatA("Ibux", 210.0, 100.0, 3);
    Legemiddel legem2 = new PreparatB("Paralgin Forte", 56.0, 75.0, 1);
    Legemiddel legem3 = new PreparatC("Predizol", 100.0, 6.7);

    Lege lege = new Lege("Dr. Wilson");

    Resept hvit = new Hvit(legem, lege, 45, 3);
    Resept blaa = new Blaa(legem2, lege, 62, 1);
    Resept milit = new Militaerresept(legem3, lege, 37, 2);
    Resept pResept = new PResept(legem, lege, 14, 1);

    System.out.println(hvit);
    System.out.println(blaa);
    System.out.println(milit);
    System.out.println(pResept);

    System.out.println();
    System.out.println("Test av metoder: ");
    System.out.println("Hent id: " + hvit.hentId());
    System.out.println("Farge: " + hvit.farge());
    System.out.println("Pris aa betale: " + hvit.prisAaBetale() + " kr.");
    System.out.println("Hent legemiddel: " + blaa.hentLegemiddel());
    System.out.println("Hent utskrivende lege: " + milit.utskrivendeLege());
    System.out.println("Hent pasient-id: " + pResept.hentPasientId());
    System.out.println("Hent reit: " + hvit.hentReit());
    System.out.print("Bruk: ");
    if (blaa.bruk()) {System.out.println("Resepten kan brukes.");
  }
  }
}
