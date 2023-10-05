import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
import java.io.*;

public class Hovedprogram {

  public static void main(String[] args) {

    int antallTelegrafister = 3;
    Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
    Kanal[] kanaler = ops.hentKanalArray();
    Monitor monitor = new Monitor(antallTelegrafister);

    for (int i = 0; i < antallTelegrafister; i++) {
      Thread telegrafist = new Thread(new Telegrafist(kanaler[i], monitor));
      telegrafist.start();
      }
    for (int j = 0; j < 40; j++) {
      Thread kryptograf = new Thread(new Kryptograf(monitor));
      kryptograf.start();
    }
    Thread operasjonsleder = new Thread(new Operasjonsleder(monitor));
    operasjonsleder.start();

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {}
  }
}
