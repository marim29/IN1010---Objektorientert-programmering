class Person2 {
  private int alder;
  private String navn;

  public Person2(int alder, String navn) {
    this.alder = alder;
    this.navn = navn;
  }
  public void skrivUt() {
    System.out.println("Navn: " + navn + "\nAlder: " + alder);
  }
  public void haBursdag() {
    alder++;
  }
}
