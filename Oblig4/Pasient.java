public class Pasient {
  public String navn, foedselsnr;
  private int ID;
  private static int teller = 0;
  public static Stabel<Resept> utskrevedeResepter = new Stabel<Resept>();

  public Pasient(String navn, String foedselsnr) {
    this.navn = navn;
    this.foedselsnr = foedselsnr;
    this.ID = teller++;

  }
  public int hentID() {
    return ID;
  }

  public String hentNavn() {
    return navn;
  }

  public String hentFoedselsnr() {
    return foedselsnr;
  }

  public void skrivReseptliste() {
    for (Resept resept : utskrevedeResepter) {
      System.out.println(resept.hentId() + ": (" + resept.hentReit() + ")");
    }
  }

  public Stabel<Resept> hentReseptliste() {
    return utskrevedeResepter;
  }

  public void leggTilResept(Resept resept) {
      utskrevedeResepter.leggPaa(resept);
  }

  @Override
  public String toString() {
    return this.hentID() + ": " + this.hentNavn() + " " + this.hentFoedselsnr();
  }
}
