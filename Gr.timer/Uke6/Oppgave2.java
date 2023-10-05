class Oppgave2 {
  public static void main(String[] args) {
    OrnetPar<Kanon, Kanonkule> kPar = nre OrnetPar<Kanon, Kanonkule>(new Kanon(), new Kanonkule());

    OrdnetPar<Sjodyr, Sjodyr> mineDyr = new OrdnetPar<Sjodyr, Sjodyr> (new Gullfisk("Geir"), new Hai("Hoi"));

    System.out.println(mineDyr.hentNokkel());
    System.out.println(mineDyr.hentVerdier());

    minDyr.settNabo(kPar);

    OrdnetPar temp = mineDyr;

    while (temp != null) {
      System.out.println("Key \t" + temp.hentNokkel() + "\tValue:\t" + temp.hentVerdi();}
      temp = temp.nabo;

    }
  }
}
