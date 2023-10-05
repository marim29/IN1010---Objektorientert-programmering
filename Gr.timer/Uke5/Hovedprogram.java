class Hovedprogram {
  public static void main(String[] args) {
    Drikke drikke = new Drikke(10, 7);
    System.out.println(drikke);

    drikke.drikkGlass();
    System.out.println(drikke);

    Drikke ol = new Ol(10, 7);

    System.out.println(ol);

    ol.drikkGlass();

    System.out.println(ol);
  }
}
