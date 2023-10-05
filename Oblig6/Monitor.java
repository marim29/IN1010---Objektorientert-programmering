import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
import java.io.*;

// Styrer tilgangen til dataene med egne metoder.
class Monitor {

  public ArrayList<Melding> krypterteMeldinger = new ArrayList<Melding>();
  public ArrayList<Melding> dekrypterteMeldinger = new ArrayList<Melding>();
  public int antallTelegrafister;
  public int antallKryptografer;
  public int antallFerdige;
  public int antallFerdigeKryptografer;
  public boolean antallTelegrafisterFerdig = false;
  public boolean antallKryptograferFerdig = false;

  Lock laas;
  Condition kryptertIkkeTom;
  Condition dekryptertIkkeTom;

  public Monitor(int antallTelegrafister) {
    laas = new ReentrantLock();
    kryptertIkkeTom = laas.newCondition();
    dekryptertIkkeTom = laas.newCondition();
    this.antallTelegrafister = antallTelegrafister;
    this.antallKryptografer = 40;

  }
  public void leggTilKrypter(Melding melding) {
    laas.lock();
    try{
      krypterteMeldinger.add(melding);
      kryptertIkkeTom.signal();

    } finally {
      laas.unlock();
    }
  }

  public void leggTilDekrypter(Melding dekryptertMld) {
    laas.lock();
    try{
      dekrypterteMeldinger.add(dekryptertMld);
      dekryptertIkkeTom.signal();

    } finally {
      laas.unlock();
    }
  }

  public Melding hentUtKrypter() {
    Melding melding = null;
    laas.lock();
    try {
      while(krypterteMeldinger.isEmpty() && !antallTelegrafisterFerdig) {
        kryptertIkkeTom.await();
      }
      if(krypterteMeldinger.isEmpty() && antallTelegrafisterFerdig) {
        return null;
      }
      Melding kryptertMld = krypterteMeldinger.remove(krypterteMeldinger.size()-1);
      melding = kryptertMld;
  } catch (InterruptedException e) {
  } finally {
    laas.unlock();
    return melding;
    }
  }

  public Melding hentUtDekrypter() {
    laas.lock();
    Melding melding = null;
    try {
      // Venter på meldinger så lenge dekrypterteMeldinger er tom og telegrafistene ikke er ferdige.
      if (dekrypterteMeldinger.isEmpty() && !antallKryptograferFerdig) {
        dekryptertIkkeTom.await();
      }
      // Telegrafistene er ferdige og alle meldingene er hentet ut.
      if (dekrypterteMeldinger.isEmpty() && antallKryptograferFerdig) {
        return null;
      }
      // Det finnes meldinger i dekrypterteMeldinger. Fjerner og returnerer det bakerste elementet.
      Melding dekryptertMld = dekrypterteMeldinger.remove(dekrypterteMeldinger.size()-1);
      melding = dekryptertMld;
    } catch (InterruptedException e) {
    } finally {
      laas.unlock();
      return melding;
    }
  }

  public void oekAntallFerdige() {
    laas.lock();
    antallFerdige++;
    antallFerdigeKryptografer++;
    if (antallFerdige == antallTelegrafister) {
      antallTelegrafisterFerdig = true;
      kryptertIkkeTom.signalAll();
    }
    laas.unlock();
  }

  public void oekAntallFerdigeKryptografer() {
    laas.lock();
    antallFerdigeKryptografer++;
    if (antallFerdigeKryptografer == antallKryptografer) {
      antallKryptograferFerdig = true;
      dekryptertIkkeTom.signalAll();
    }
    laas.unlock();
  }
}
