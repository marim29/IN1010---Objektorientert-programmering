import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
import java.io.*;

class Operasjonsleder implements Runnable {
  ArrayList<Melding> kanal1 = new ArrayList<Melding>();
  ArrayList<Melding> kanal2 = new ArrayList<Melding>();
  ArrayList<Melding> kanal3 = new ArrayList<Melding>();
  Monitor monitor;

  public Operasjonsleder(Monitor monitor) {
    this.monitor = monitor;
    this.kanal1 = kanal1;
    this.kanal2 = kanal2;
    this.kanal3 = kanal3;
  }

  @Override
  public void run() {
    Melding melding = monitor.hentUtDekrypter();
    while(melding != null) {
      if (melding.hentKanalId() == 1) {
        kanal1.add(melding);
      }
      else if (melding.hentKanalId() == 2) {
        kanal2.add(melding);
      }
      else if (melding.hentKanalId() == 3) {
        kanal3.add(melding);
      }
      melding = monitor.hentUtDekrypter();
    }


    Collections.sort(kanal1);
    for (Melding m : kanal1) {
      System.out.println(m);
    }
    System.out.println();
    System.out.println();
    Collections.sort(kanal2);
    for (Melding n : kanal2) {
      System.out.println(n);
    }
    System.out.println();
    System.out.println();
    Collections.sort(kanal3);
    for (Melding o : kanal3) {
      System.out.println(o);
    }
  }

  //
  // public void skrivTilFil(String utfil) {
  //
  //   File f = new File(utfil);
  //   try {
  //     PrintWriter pw = new PrintWriter(f, "utf-8");
  //
  //     System.out.println("Kanal 1:");
  //     for(Melding melding : kanal1) {
  //       pw.append(melding.hentInnhold() + "\n\n");
  //     }
  //
  //     System.out.println("Kanal 2:");
  //     for(Melding melding : kanal2) {
  //       pw.append(melding.hentInnhold() + "\n\n");
  //     }
  //
  //     System.out.println("Kanal 3:");
  //     for(Melding melding : kanal3) {
  //       pw.append(melding.hentInnhold() + "\n\n");
  //     }
  //     pw.close();
  //
  //   } catch (UnsupportedEncodingException e) {}
  //   catch (FileNotFoundException e) {
  //     System.out.println("Fant ikke filen");
  //   }
  // }
}
