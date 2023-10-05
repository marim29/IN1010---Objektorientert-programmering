public class Hovedprogram {

  public static void main(String[] args) {
    Legemiddel legemiddel = new Legemiddel("Paracet", 45.0, 50.00);
    PreparatA prepA = new PreparatA("Ibux", 210.0, 100.0, 3);
    PreparatB prepB = new PreparatB("Paralgin Forte", 56.0, 75.0, 1);
    PreparatC prepC = new PreparatC("Predizol", 100.0, 6.7);

    Lege lege = new Lege("Dr. Cox");
    Spesialist spes = new Spesialist("Dr. Wilson", 38902);

    Hvit hvit = new Hvit(legemiddel, lege, 45, 4);
    Blaa blaa = new Blaa(prepA, spes, 21, 5);
    Militaerresept militaer = new Militaerresept(prepB, lege, 03, 2);
    PResept pres = new PResept(prepC, spes, 15, 1);

    System.out.println(legemiddel);
    System.out.println();
    System.out.println(prepA);
    System.out.println();
    System.out.println(prepB);
    System.out.println();
    System.out.println(prepC);
    System.out.println();
    System.out.println(lege);
    System.out.println();
    System.out.println(spes);
    System.out.println();
    System.out.println(hvit);
    System.out.println();
    System.out.println(blaa);
    System.out.println();
    System.out.println(militaer);
    System.out.println();
    System.out.println(pres);

    try {
      lege.skrivResept(legemiddel, 22, 1);
    } catch (UlovligUtskrift u) {
      System.out.println(u);
    }
  }
}
