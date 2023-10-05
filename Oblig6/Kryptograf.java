import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
import java.io.*;

class Kryptograf implements Runnable {
  Monitor monitor;

  public Kryptograf(Monitor monitor) {
    this.monitor = monitor;
  }

  @Override
  public void run() {
    Melding melding = monitor.hentUtKrypter();
    while(melding != null) {
      String dekryptertMld = Kryptografi.dekrypter(melding.hentInnhold());
      melding.settMelding(dekryptertMld);
      monitor.leggTilDekrypter(melding);
      melding = monitor.hentUtKrypter();
    }
    monitor.oekAntallFerdigeKryptografer();
  }
}
