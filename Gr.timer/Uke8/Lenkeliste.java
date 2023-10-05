public class Lenkeliste<T> {


  public void skrivUtRekursivt() {
    skrivUtRekursivt(forste);
  }

  private void skrivUtRekursivt(Node gjeldende) {
    if (gjeldende == 0) {   //basistilfellet.
      return;
    }
    System.out.println(gjeldende.verdi);
    skrivUtRekursivt(gjeldende.neste);
  }

//Baklengs:
  public void skrivUtRekursivtBaklengs() {
    skrivUtRekursivtBaklengs(forste);
  }

  private void skrivUtRekursivtBaklengs(Node gjeldende) {
    if (gjeldende == 0) {   //basistilfellet.
      return;
    }
    skrivUtRekursivtBaklengs(gjeldende.neste);
    System.out.println(gjeldende.verdi);    // <- bytter om på metoden og utskrift. Kaller rekursivt før den skriver ut.
  }

  public void settInnForan(T ting) {
      Node ny = new Node(ting);
  }
}
