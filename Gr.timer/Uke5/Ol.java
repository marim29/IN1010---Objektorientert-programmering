class Ol extends Drikke {

  public Ol(int plass, int drikke) {
    super(plass, drikke);
  }

  @Override
  public void drikkGlass() {
    if (drikke > 5) {
      drikke -= 5;
    } else {
      drikke = 0;
    }
  }

  @Override
  public String toString() {
    return "Flasken har plass til: " + plass + "dl drikke. Mengde drikke i flasken: " + drikke + " dl.";
  }
}
