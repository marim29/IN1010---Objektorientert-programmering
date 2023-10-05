import java.Util.Iterator;

class Liste<T> implements Iterable<T> {
  private Node hode;
  private Node hale;

  private class Node {
    Node neste;
    T ting;

    Node(T ting) {
      this.ting = ting;
    }
  }

  public boolean erTom() {
    return hode == null;
  }

  public void leggTil(T t) {
    Node nyNode = new Node(t);
    if(erTom()) {
      hode = nyNode;
      hale = hode;
    } else {
      hale.neste = nyNode;
      hale = nyNode;
    }
  }

  public void fjernAlt() {
    hode = null;
    hale = null;
  }

  public void skrivUtListe() {
    Node temp = hode;
    System.out.println("[");
    while(temp != null) {
      System.out.println("\n" + temp.ting);
      temp = temp.neste;
    }
    System.out.println("]");
  }
  public T fjern() {
    return null;
  }
  public T pop() {
    Node temp = hode;
    hode = hode.neste;
    return temp.ting;
  }

  public Iterator<T> iterator() {
    return new MinUnikeIterator();

  }

  class MinUnikeIterator<T> implements Iterator<T> {
    Node denne;

    MinUnikeIterator() {
      denne = hode;

    }

    public boolean next() {
      return false;
    }

    public T next() {
      Node temp = denne;
      denne = denne.neste;
      return temp.ting;
    }
  }
}
