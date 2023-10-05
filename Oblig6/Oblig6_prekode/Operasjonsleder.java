import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
import java.io.*;

class Operasjonsleder extends Thread {
  ArrayList<Melding> kanal1;
  ArrayList<Melding> kanal2;
  ArrayList<Melding> kanal3;
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
    if (melding.hentKanalId() == 1) {
      kanal1.add(melding);
    }
    else if (melding.hentKanalId() == 2) {
      kanal2.add(melding);
    }
    else if (melding.hentKanalId() == 3) {
      kanal3.add(melding);
    }
  }

  public void skrivTilFil(String utfil) {

    File f = new File(utfil);
    try {
      PrintWriter pw = new PrintWriter(f, "utf-8");

      for(Melding melding : kanal1) {
        System.out.println("Kanal 1:");
        pw.append(melding.hentInnhold() + "\n\n");
      }

      for(Melding melding : kanal2) {
        System.out.println("Kanal 2:");
        pw.append(melding.hentInnhold() + "\n\n");
      }

      for(Melding melding : kanal3) {
        System.out.println("Kanal 3:");
        pw.append(melding.hentInnhold() + "\n\n");
      }
      pw.close();

    } catch (UnsupportedEncodingException e) {}
    catch (FileNotFoundException e) {
      System.out.println("Fant ikke filen");
    }
  }
}
