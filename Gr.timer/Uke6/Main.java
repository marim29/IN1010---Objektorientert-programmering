class Main {
  public static void main(String[] args) {
    Node start = new Node("hei");
    Node nrTo = new Node("paa");

    start.settNeste(nrTo);
    nrTo.settNeste(new Node("deg!"));

    System.out.println(start.hentNeste().hentNeste());
  }
}


class Main2 {
  public static void main(String[] args) {
    Node<Kanon> start = new Node<Kanon>(new Kanon());
    Node<Kanon> nrTo = new Node<Kanon>(new Kanon());

    start.settNeste(nrTo);
    nrTo.settNeste(new Node<Kanon>(new Kanon()));
    Node n = start;
    while(n != null) {
      System.out.println(n);
      n = n.hentNeste();
    }
  }
}
