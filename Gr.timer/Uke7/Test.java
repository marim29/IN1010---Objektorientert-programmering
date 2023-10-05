class Test implements iterable {
  public static void main(String[] args) {
    Liste<String> minListe = new Liste<String>();
    minListe.leggTil("foerste ord");
    minListe.leggTil("andre ord");
    minListe.leggTil("tredje ord");

    minListe.skrivUtListe();
    minListe.fjernAlt();
    minListe.skrivUtListe();

    minListe.pop();
    minListe.skrivUtListe();

    for(String s : minListe) {
      System.out.println(s);
    }
  }
}
