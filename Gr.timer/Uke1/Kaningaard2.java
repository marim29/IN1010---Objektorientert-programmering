class Kaningaard2 {

  private Kanin [] kaniner = new Kanin[100];

  public boolean full() {
    for (Kanin kanin : kaniner) {
      if (kanin == null) {
        return false;
      }
  } return true;
}
  public boolean tom() {
    for(Kanin kanin : kaniner) {
      if (kanin != null) {
        return false;
      }
    }
    return true;
  }

  public Kanin finnEn(String navn) {
    for (Kanin kanin : kaniner) {
      if (kanin != null) {
        if (navn.equals(kanin.hentNavn())) {
          return kanin;
        }
      }
    }
    return null;
  }

  public void settInn(Kanin kanin) {
    if (finnEn(kanin.hentNavn()) != null) {
      System.out.println("Kaninen finnes allerede i gaarden.");
    } else if {
      
    }
    }

  }
}
