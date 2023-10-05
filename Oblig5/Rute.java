public abstract class Rute {
  protected int kolonne;
  protected int rad;
  protected Labyrint labyrint;
  protected Rute nord = null;
  protected Rute soer = null;
  protected Rute oest = null;
  protected Rute vest = null;
  boolean besoekt = false;

  public Rute(int kolonne, int rad) {
    this.labyrint = labyrint;
    this.rad = rad;
    this.kolonne = kolonne;
  }
  public abstract boolean besoekt();

  public abstract void gaa(String s);

  public abstract void finnUtvei();

  public void settLabyrint(Labyrint labyrint) {
    this.labyrint = labyrint;
  }

  public abstract String chartilTegn();


}
