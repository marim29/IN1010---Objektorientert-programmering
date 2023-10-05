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
  public int antallFerdige;
  public boolean antallTelegrafisterFerdig = false;

  Lock laas;
  Condition kryptertIkkeTom;
  Condition dekryptertIkkeTom;

  public Monitor(int antallTelegrafister) {
    laas = new ReentrantLock();
    kryptertIkkeTom = laas.newCondition();
    dekryptertIkkeTom = laas.newCondition();
    this.antallTelegrafister = antallTelegrafister;

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
    try {
      laas.lock();
      System.out.println("Hei");
      if(krypterteMeldinger.isEmpty() && !antallTelegrafisterFerdig) {
        kryptertIkkeTom.await();
      }
      if(krypterteMeldinger.isEmpty() && antallTelegrafisterFerdig) {
        return null;
      }
      Melding kryptertMld = krypterteMeldinger.remove(krypterteMeldinger.size()-1);
      // krypterteMeldinger.remove();
      return kryptertMld;
  } catch (InterruptedException e) {
  } finally {
    laas.unlock();
    
    }
  }

  public Melding hentUtDekrypter() {
    laas.lock();
    try {
      if (dekrypterteMeldinger.isEmpty() && !antallTelegrafisterFerdig) {
        dekryptertIkkeTom.await();
      }
      if (dekrypterteMeldinger.isEmpty() && antallTelegrafisterFerdig) {
        return null;
      }
      Melding dekryptertMld = dekrypterteMeldinger.remove(dekrypterteMeldinger.size()-1);
      // dekrypterteMeldinger.remove();
      return dekryptertMld;
    } catch (InterruptedException e) {
    } finally {
      laas.unlock();
      return null;
    }
  }

  public void oekAntallFerdige() {
    laas.lock();
    antallFerdige++;
    if (antallFerdige == antallTelegrafister) {
      antallTelegrafisterFerdig = true;
    }
    laas.unlock();
    }
  }
