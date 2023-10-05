import java.util.Iterator;

class VaarArray<T> implements Iterable<T> {
  T[] arr;

  public VaarArray(int strl) {
    arr = (T[]) new Object[strl];
  }
  public boolean settInn(T elem) {
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == null) {
        arr[i] = elem;
        return true;
      }
    }
    return false;
  }

  public boolean fjernFraIndex(int n) {
    if(n < 0 || n >= arr.length) {
      return false;
    }
    if(arr[n] == null) {
      return false;
    }
    arr[n] = null;
    return true;
  }

  @Override
  public Iterator<T> iterator() {
    return new ArrayIterator();
  }

  private class ArrayIterator implements Iterator<T> {
    int indeks = 0;

    @Override
    public boolean hasNext() {
      return indeks < arr.length;
    }

    public T next() {
      T returverdi = arr[indeks];
      indeks++;
      return returverdi;
    }
  }
}
