import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
import java.io.*;

class Telegrafist extends Thread {
  Kanal kanal;
  Monitor monitor;

  public Telegrafist(Kanal kanal, Monitor monitor) {
    this.kanal = kanal;
    this.monitor = monitor;

  }
  @Override
  public void run() {
      String tekst = kanal.lytt();
      while(tekst != null) {
        Melding melding = new Melding(tekst, kanal);
        monitor.leggTilKrypter(melding);
        tekst = kanal.lytt();
      }
      monitor.oekAntallFerdige();
  }
}
