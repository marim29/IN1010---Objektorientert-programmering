import java.util.Iterator;

public class Lege implements Comparable<Lege>{
  public String navn;
  public static Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<>();

  public Lege(String navn) {
    this.navn = navn;
  }

  public String hentNavn() {
    return navn;
  }

  Resept skrivResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    Resept r = new Hvit(legemiddel, this, pasient, reit);
    if (legemiddel instanceof PreparatA) {
      throw new UlovligUtskrift(this, legemiddel);
    }
    utskrevedeResepter.leggTil(r);
    pasient.leggTilResept(r);
    return r;
  }

  public int compareTo(Lege lege) {
    return this.hentNavn().compareTo(lege.hentNavn());
  }

  public void skrivReseptliste() {
    for (Resept r : utskrevedeResepter) {
      System.out.println(r);
    }
  }

  public Lenkeliste<Resept> hentReseptliste() {
    return utskrevedeResepter;
  }


  @Override
  public String toString() {
    return "Lege: " + navn;
  }
}
