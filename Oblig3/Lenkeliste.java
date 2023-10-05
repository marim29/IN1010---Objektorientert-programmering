class Lenkeliste<T> implements Liste<T> {
  protected Node start;
  protected Node slutt;

  private class Node {
    Node neste;
    T data;

    Node(T data) {
      this.data = data;
    }
  }

  @Override
  public int stoerrelse() {
    int teller = 0;

    for(Node temp = start; temp != null; temp = temp.neste) {
      teller++;
    }
    return teller;
  }


// Sette inn et nytt element i listen og skyve neste element ett hakk lenger bak.

  @Override
  public void leggTil(int pos, T x) {
    if (pos < 0 || pos > stoerrelse()) {
      throw new UgyldigListeIndeks(pos);
    }
    Node temp = start;
    if (pos == 0) {
      Node ny = new Node(x);
      ny.neste = start;
      start = ny;
      return;
    }
    int plass = 0;
    while (plass < pos-1) {
      temp = temp.neste;
      plass++;
    }
    Node ny = new Node(x);
    ny.neste = temp.neste;
    temp.neste = ny;
  }

// Sette inn et element på slutten av listen.

  @Override
  public void leggTil(T x) {
    if (stoerrelse() == 0) {
      Node ny = new Node(x);
      start = ny;
      return;
    }
    Node pos = start;
    while(pos.neste != null) {
      pos = pos.neste;
    }
    pos.neste = new Node(x);
  }

// Sette inn et element på en gitt posisjon og overskrive det som er der fra før av.

  @Override
  public void sett(int pos, T x) {
    if (pos < 0 || pos > stoerrelse()-1) {
      throw new UgyldigListeIndeks(pos);
    }
    Node temp = start;
    for(int i = 0; i < pos; i++) {
      temp = temp.neste;
    }
    temp.data = x;
  }

// Hente ut et element på oppgitt indeks.

  @Override
  public T hent(int pos) {
    if (pos < 0 || pos > stoerrelse()-1) {
      throw new UgyldigListeIndeks(pos);
    }
    Node temp = start;
    int plass = 0;
    while(plass < pos) {
      temp = temp.neste;
      plass++;
    }
    return temp.data;
  }


// Fjerne element på en gitt indeks i listen.

  @Override
  public T fjern(int pos) {
    if (stoerrelse() == 0) {
      throw new UgyldigListeIndeks(pos-1);
    }
    if (pos < 0 || pos > stoerrelse()-1) {
      throw new UgyldigListeIndeks(pos);
    }
    Node temp = start;
    if (pos == 0) {
      start = start.neste;
      return temp.data;
    }
    for (int i = 0; i < pos-1; i++) {
      temp = temp.neste;
    }
    Node ny = temp.neste;
    temp.neste = ny.neste;
    return ny.data;
  }

// Fjerne og returnere element på starten av listen.

  @Override
  public T fjern() {
    if (stoerrelse() == 0) {
      throw new UgyldigListeIndeks(0);
    }
    T returdata = start.data;
    if (start == slutt) {
      start.data = null;
      slutt.data = null;
    } else {
      start = start.neste;
    }
    return returdata;
  }
}
