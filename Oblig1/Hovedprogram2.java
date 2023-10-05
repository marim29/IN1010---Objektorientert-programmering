import java.util.ArrayList;

class Hovedprogram {
  public static void main(String[] args) {
    Regneklynge abel = new Regneklynge("Regneklynge");

    for (int i = 0; i < 650; i++) {
      Node node1 = new Node(64, 1);
      abel.settInnNode(node1);

    for (int i = 0; i < 16; i++) {
      Node node2 = new Node(1024, 2);
      abel.settInnNode(node2);
    }

    System.out.println("Noder med minst 32 GB: " + abel.noderMedNokMinne(32));
    System.out.println("Noder med minst 64 GB: " + abel.noderMedNokMinne(64));
    System.out.println("Noder med minst 128 GB: " + abel.noderMedNokMinne(128));
    System.out.println("Totalt antall prosessorer: " + abel.antProsessorer());
    System.out.println("Antall rack som brukes: " + abel.antallRacks());
    }
  }
}
