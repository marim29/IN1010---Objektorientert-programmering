public class Stabel<T> extends Lenkeliste<T> {

  // Legger til element på slutten av listen.
  public void leggPaa(T x) {
    super.leggTil(x);
  }

  // Fjerner element på slutten av listen.
  public T taAv() {
    return super.fjern(stoerrelse()-1);

  }
}
