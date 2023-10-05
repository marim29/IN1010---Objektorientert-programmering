class TestPreparat {
  public static void main(String[] args) {
    PreparatA a = new PreparatA("Ibux", 210.0, 100.0, 3);
    PreparatB b = new PreparatB("Paralgin Forte", 56.0, 75.0, 1);
    PreparatC c = new PreparatC("Predizol", 100.0, 6.7);

    System.out.println("ID: " + a.hentId());
    System.out.println("Navn: " + a.hentNavn());
    System.out.println("Pris: " + a.hentPris());
    System.out.println("Virkestoff:" + a.hentVirkestoff());
    a.settNyPris(200);
    System.out.println("Ny pris: " + a.hentPris());
    System.out.println("Narkotisk styrke: " + a.hentNarkotiskStyrke());
    System.out.println();

    System.out.println("Preparat A:\n" + a);
    System.out.println();
    System.out.println("Preparat B:\n" + b);
    System.out.println();
    System.out.println("Preparat C:\n" + c);
    System.out.println();

  }
}
