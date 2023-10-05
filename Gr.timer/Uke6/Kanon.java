class Kanon {
  Kanonkule kanonkule;
  static int i;
  private int id;

  public Kanon() {
    id = i;
    i++;
    kanonkule = new Kanonkule();

  }

  public void skyt() {
    System.out.println("Pang!" + kanonkule.bliSkutt());

  }

  public String toString() {
    return "Kanonkule" 
  }
}
