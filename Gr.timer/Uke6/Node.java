class Node<T> {
  private Node neste;
  T innhold;

  public Node(T i) {
    innhold = i;
  }

  public void settNeste(Node n) {
    neste = n;
  }

  public Node hentNeste() {
    return neste;
  }

  public String toString() {
    return innhold;
  }
}
