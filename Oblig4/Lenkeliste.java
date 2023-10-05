import java.util.Iterator;

public class Lenkeliste<T> implements Liste<T> {
  protected Node start;

  class Node {
    Node neste;
    T data;

    Node(T data) {
      this.data = data;
    }
  }
  public boolean erTom() {
    return start == null;
  }


  public int stoerrelse() {
    Node temp = start;
    int teller = 0;
    if(erTom()) {
      return teller;
    }
    while(temp != null) {
      temp = temp.neste;
      teller++;
      }
    return teller;
  }

  public void skrivUt() {
    Node temp = start;
    while(temp != null) {
      System.out.println(temp.data);
      temp = temp.neste;
    }
  }

  public void leggTil(int pos, T x) {
    if(erTom() && pos != 0) {
      throw new UgyldigListeIndeks(pos);
    } else if(pos < 0 || pos > stoerrelse()) {
      throw new UgyldigListeIndeks(pos);
    } else if (pos == 0){
      Node ny = new Node(x);
      ny.neste = start;
      start = ny;
    } else {
      Node temp = start;
      for(int i = 0; i < pos-1; i++) {
        temp = temp.neste;
      }
      Node ny = new Node(x);
      ny.neste = temp.neste;
      temp.neste = ny;
    }
  }
  //Legger til et element på slutten av listen.

  public void leggTil(T x) {
    Node ny = new Node(x);
    Node temp = start;
    if(erTom()) {
      start = ny;
    } else {
      while(temp.neste != null) {
        temp = temp.neste;
      }
      temp.neste = ny;
    }
  }
  // Setter inn element på en gitt posisjon og overskriver det som var der fra før.

  public void sett(int pos, T x) {
    if(erTom()) {
      throw new UgyldigListeIndeks(pos);
    } else if(pos < 0 || pos > stoerrelse()-1) {
      throw new UgyldigListeIndeks(pos);
    }
    Node temp = start;
    for(int i = 0; i < pos; i++) {
      temp = temp.neste;
    }
    temp.data = x;

  }
  // Henter ut et element på oppgitt indeks.

  public T hent(int pos) {
    if(erTom()) {
      throw new UgyldigListeIndeks(pos);
    } else if(pos < 0 || pos > stoerrelse()-1){
      throw new UgyldigListeIndeks(pos);
    } else {
      Node temp = start;
      for(int i = 0; i < pos; i++) {
        temp = temp.neste;
      }
      return temp.data;
    }
  }
  // Fjerner på en indeks i listen.

  public T fjern(int pos) {
    if(erTom()) {
      throw new UgyldigListeIndeks(-1);
    } else if(pos < 0 || pos > stoerrelse()-1) {
      throw new UgyldigListeIndeks(-1);
    } else if(pos == 0) {
      Node temp = start;
      start = temp.neste;
      return temp.data;
    } else {
      Node temp = start;
      for(int i = 0; i < pos-1; i++) {
        temp = temp.neste;
      }
      T data = temp.neste.data;
      temp.neste = temp.neste.neste;
      return data;
    }

  }
  // Fjerner og returnerer elementet på starten av listen.

  public T fjern() {
    if(erTom()) {
      throw new UgyldigListeIndeks(-1);
    } else {
      Node temp = start;
      start = temp.neste;
      return temp.data;
    }
  }


  public Iterator<T> iterator(){
    return new LenkelisteIterator();
  }

  class LenkelisteIterator implements Iterator<T>{
    Node temp;

    LenkelisteIterator(){
      temp = start;
    }

    public boolean hasNext(){
      return temp != null;
    }
    public T next(){
      T t = temp.data;
      temp = temp.neste;
      return t;
    }
  }
}
