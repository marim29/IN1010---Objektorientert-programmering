public class Melding implements Comparable<Melding> {
  String tekst;
  int sekvensNr;
  static int teller;
  Kanal kanal;

  public Melding(String tekst, Kanal kanal) {
    this.tekst = tekst;
    this.sekvensNr = teller++;
    this.kanal = kanal;
  }

  public int hentSekvensNr() {
    return sekvensNr;
  }

  public int hentKanalId() {
    return kanal.hentId();
  }

  @Override
  public int compareTo(Melding melding) {
    return this.hentSekvensNr() - melding.hentSekvensNr();
  }

  public String hentInnhold() {
    return tekst;
  }

  public void settMelding(String tekst) {
    this.tekst = tekst;
  }
  @Override
  public String toString() {
    return sekvensNr + " : " + tekst;
  }

}
