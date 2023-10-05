public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {

  @Override
  public void leggTil(T x) {

    Node temp = start;
    if(temp == null) {
      super.leggTil(x);
      return;
    }

    Node ny = new Node(x);
    Node forrige = null;
    while(x.compareTo(temp.data) > 0) {
      forrige = temp;
      temp = temp.neste;
      if(temp == null) {
        forrige.neste = ny;
        return;
      }
    }

    if(forrige == null) {
      start = ny;
      ny.neste = temp;
      return;
    }

    forrige.neste = ny;
    ny.neste = temp;
  }

  @Override
  public T fjern() {
    return super.fjern(stoerrelse()-1);
  }

  @Override
  public void sett(int pos, T x) {
    throw new UnsupportedOperationException();
  }
  @Override
  public void leggTil(int pos, T x) {
    throw new UnsupportedOperationException();
  }
}
