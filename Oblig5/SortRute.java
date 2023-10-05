public class SortRute extends Rute {

  public SortRute(int kolonne, int rad) {
    super(kolonne, rad);
  }

  @Override
  public boolean besoekt() {
    return besoekt;
  }

  @Override
  public void gaa(String s) {
    return;
  }

  @Override
  public void finnUtvei() {
    return;
  }

  @Override
  public String chartilTegn() {
    return "#";
  }
}
