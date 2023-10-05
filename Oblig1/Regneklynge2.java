import java.util.ArrayList;
import java.util.Scanner;
import java.FileNotFoundException;
import java.io.File;

class Regneklynge {
  private ArrayList<Rack> racks = new ArrayList<Rack>();
  int noderPerRack;

  public Regneklynge(File regneklynge) {
    Scanner fil = null;
    try{
      fil = new Scanner(new File(regneklynge));
    }catch(FileNotFoundException e){
      System.out.println("Fant ikke filen.");
    }
    noderPerRack = 0;
    String linje = " ";
    while (fil.hasNextLinje()) {
      noderPerRack = fil.nextInt();
      linje = fil.nextLine();
      int[] tall = linje.split(" ");
      int antallNoder = Integer.parseInt(tall[0]);
      int minnePerNode = Integer.parseInt(tall[1]);
      int antallProsessorerPerNode = Integer.parseInt(tall[2]);
      linje2 = fil.nextLine();
      int[] tall = linje2.split(" ");
      int antallNoder2 = Integer.parseInt(tall[0]);
      int minnePerNode2 = Integer.parseInt(tall[1]);
      int antallProsessorerPerNode2 = Integer.parseInt(tall[2]);
      fil.nextInt();
    }
  }
  public void settInnNode(Node node) {
    for (Rack rack : racks) {
      if (rack.hentAntNoder() != noderPerRack) {
        rack.settInn(node);
      }
    Rack nyttRack = new Rack();
    nyttRack.settInn(node);
    racks.add(nyttRack);
    }
  }
  public int antProsessorer() {
    int antProsessorer = 0;
    for (Rack rack : racks) {
      int pros = rack.hentAntProsessorer();
      antProsessorer += pros;
    }
    return antProsessorer;
  }
  public int noderMedNokMinne(int paakrevdMinne) {
    int noderMedNok = 0;
    for (Rack rack : racks) {
      noderMedNok += rack.noderMedNokMinne(paakrevdMinne);
    }
    return noderMedNok;
  }
  public int antallRacks() {
    int antRacks = 0;
    for (Rack rack : racks) {
      antRacks++;
    }
    return antRacks;
  }
}
