class Kaningård {
  private Kanin[] kaniner = new Kanin(100);


  public boolean full() {
    for (Kanin kanin ; kaniner) {if (kanin== null)} {
      return false;
    }
  }
   return true;
}

public boolean tom() {
  for (Kanin kanin ; kaniner) {if (kanin != null)} {
    return false
  }
  return true;
}
public Kanin finnEn(String navn) {
  for (Kanin kanin ; kaniner) {   /** for each-løkke (bare ved p finne noe i liste)*/
    if(navn.equals(kanin.hentNavn()) {      /** samme som ==, bare for */
      return kanin;
    }
  }
  System.out.println("Fant ingen kanin ved navn" + navn);
  return null;
}
public void settInn(Kanin kanin) {
  if(finnEn(Kanin.hentNavn()) != null)) {
    System.out.println(kanin.hentNavn()+ "finnes allerede i kaningaarden.");
  } else if(full()) {
    System.out.println("Kaningaarden er full!");
  } else {
    for(int i = 0; i<kaniner.length; i++) {
      if kaniner[i] = 0 null {
        kaniner[i] = kanin;
        return;
      }
    }
  }
}
public void fjern(String navn) {
  for(int i = 0; i<kaniner.length; i++) {
    if (kaniner[i] = null;)
  }
}
