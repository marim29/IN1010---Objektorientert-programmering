import java.util.*;
import java.io.*;

public class Legesystem{
    // Opprett lister som lagrer objektene i legesystemet
    public static Lenkeliste<Legemiddel> legemiddelliste = new Lenkeliste<>();
    public static Lenkeliste<Resept> reseptliste = new Lenkeliste<>();
    public static SortertLenkeliste<Lege> legeliste = new SortertLenkeliste<>();
    public static Lenkeliste<Pasient> pasientliste = new Lenkeliste<>();


    public static void main(String[] args){
      Scanner in = new Scanner(System.in);

      System.out.println("Skriv inn filnavn: ");
      String filnavn = in.nextLine();

      // try {
      File fil = new File(filnavn);
      lesFraFil(fil);
      // } catch (FileNotFoundException e) {
      //   System.out.println("Fant ingen fil med navn " + filnavn);

      while(true) {
        System.out.println("Hva vil du gjoere?");
        System.out.println();
        System.out.println("1: Skrive ut en oversikt over legesystemet\n2: Legge til en ny lege, pasient, resept eller legemiddel i systemet"+
        "\n3: Bruke en resept\n4: Skrive ut statistikk");
        String inp = in.nextLine();

        switch(inp) {
          case("1"):
            System.out.println("Utskrift av legesystem: ");
            skrivLegesystem();
            break;
          case("2"):
            System.out.println("Hva vil du legge til?\n1: lege\n2: pasient\n" +
            "3: resept\n4: legemiddel");
            String inp2 = in.nextLine();
            switch(inp2) {
              case("1"):
                System.out.println("Legg til en ny lege");
                leggTilLege();
                break;
              case("2"):
                System.out.println("Legg til en ny pasient");
                leggTilPasient();
                break;
              case("3"):
                System.out.println("Legg til en ny resept");
                leggTilResept();
                break;
              case("4"):
                System.out.println("Legg til et nytt legemiddel");
                leggTilLegemiddel();
                break;
              }
              break;
          case("3"):
            brukResept();
            break;
          case("4"):
            System.out.println("Hva vil du skrive ut statistikk om?");
            System.out.println("1: Antall utskrevne resepter paa vanedannende legemidler.\n" +
            "2: Antall utskrevne resepter paa narkotiske legemidler.\n3: Statistikk om mulig misbruk" +
            "av narkotika.");
            String inp3 = in.nextLine();
            switch(inp3) {
              case("1"):
                System.out.println("Statistikk om vanedannende legemidler: ");
                System.out.println("Antall utskrevne resepter paa vanedannende legemidler: ");
                skrivAntallVanedannende();
                break;
              case("2"):
                System.out.println("Statistikk om narkotiske legemidler: ");
                System.out.println("Antall utskrevne resepter paa narkotiske legemidler: ");
                skrivAntallNarkotiske();
                break;
              case("3"):
                System.out.println("Hva vil du skrive ut? ");
                System.out.println("1: Alle leger som har skrevet ut minst en resept paa narkotiske" +
                "legemidler og antallet slike resepter.\n2: Alle pasienter som har minst en gyldig" +
                "resept paa narkotiske legemidler og antallet per pasient.");
                String inp4 = in.nextLine();
                switch(inp4) {
                  case("1"):
                    System.out.println("Leger som har skrevet ut minst en resept paa narkotiske legemidler: ");
                    skrivLegerMedNarkotisk();
                    break;
                  case("2"):
                    System.out.println("Pasienter med minst en gyldig resept paa narkotiske legemidler: ");
                    skrivPasienterMedNarkotisk();
                    break;
                  }
                }
              }

        System.out.println("Oensker du aa fortsette programmet? ja/nei");
        String svar = in.nextLine();
        if(svar.equals("ja")) {
          System.out.println("Fortsetter programmet.");
        } else if (svar.equals("nei")) {
          System.out.println("Avslutter programmet.");
          break;
        }
      }
    }

    private static void lesFraFil(File fil){
        Scanner scanner = null;
        try{
            scanner = new Scanner(fil);
        }catch(FileNotFoundException e){
            System.out.println("Fant ikke filen, starter opp som et tomt Legesystem");
            return;
        }

        String innlest = scanner.nextLine();

        while(scanner.hasNextLine()){

            String[] info = innlest.split(" ");
            System.out.println(innlest);
            // Legger til alle pasientene i filen
            if(info[1].compareTo("Pasienter") == 0){
                while(scanner.hasNextLine()) {
                    innlest = scanner.nextLine();

                    //Om vi er ferdig med å legge til pasienter, bryt while-løkken,
                    //slik at vi fortsetter til koden for å legge til legemidler
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
                    //
                    //MERK:  Her må du legge til pasienten i en lenkeliste
                    //
                    String[] biter = innlest.split(", ");
                    String navn = biter[0];
                    String foedselsnr = biter[1];

                    Pasient p = new Pasient(navn, foedselsnr);
                    pasientliste.leggTil(p);
                  }
              }
            //Legger inn Legemidlene
            else if(info[1].compareTo("Legemidler") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    //Om vi er ferdig med å legge til legemidler, bryt whileløkken,
                    //slik at vi fortsetter til koden for å legge til leger
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
                    String[] legemiddel = innlest.split(", ");
                    if(legemiddel[1].compareTo("a") == 0){
                        //
                        //MERK:  Her må du legge til et PreparatA i en lenkeliste
                        // (uten preparat-typen)
                        String navn = legemiddel[0];
                        String inp1 = legemiddel[2];
                        double pris = Double.parseDouble(inp1);
                        String inp2 = legemiddel[3];
                        double virkestoff = Double.parseDouble(inp2);
                        String inp3 = legemiddel[4];
                        int styrke = Integer.parseInt(inp3);

                        PreparatA a = new PreparatA(navn, pris, virkestoff, styrke);
                        legemiddelliste.leggTil(a);

                    }
                    else if(legemiddel[1].compareTo("b") == 0){
                        //
                        //MERK:  Her må du legge til et PreparatB i en lenkeliste
                        //
                        String navn = legemiddel[0];
                        String inp1 = legemiddel[2];
                        double pris = Double.parseDouble(inp1);
                        String inp2 = legemiddel[3];
                        double virkestoff = Double.parseDouble(inp2);
                        String inp3 = legemiddel[4];
                        int styrke = Integer.parseInt(inp3);

                        PreparatB b = new PreparatB(navn, pris, virkestoff, styrke);
                        legemiddelliste.leggTil(b);


                    }else if (legemiddel[1].compareTo("c") == 0){
                        //
                        //MERK:  Her må du legge til et PreparatC i en lenkeliste
                        //
                        String navn = legemiddel[0];
                        String inp1 = legemiddel[2];
                        double pris = Double.parseDouble(inp1);
                        String inp2 = legemiddel[3];
                        double virkestoff = Double.parseDouble(inp2);

                        PreparatC c = new PreparatC(navn, pris, virkestoff);
                        legemiddelliste.leggTil(c);
                    }
                }
            }
            //Legger inn leger
            else if(info[1].compareTo("Leger") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    //Om vi er ferdig med å legge til leger, bryt whileløkken,
                    //slik at vi fortsetter til koden for å legge til resepter
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
                    info = innlest.split(", ");
                    int kontrollid = Integer.parseInt(info[1]);
                    if(kontrollid == 0){
                        //
                        //MERK:  Her må du legge til et lege objekt i en sortert lenkeliste
                        //
                        String navn = info[0];

                        Lege lege = new Lege(navn);
                        legeliste.leggTil(lege);


                    }else{
                        //
                        //MERK:  Her må du legge til et spesialist objekt i en sortert lenkeliste
                        //
                        String navn = info[0];


                        Spesialist spes = new Spesialist(navn, kontrollid);
                        legeliste.leggTil(spes);

                    }
                }

            }
            //Legger inn Resepter
            else if(info[1].compareTo("Resepter") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    info = innlest.split(", ");
                    //
                    // Her må du finne legen, legemiddelet, og pasienten som ligger
                    // i lenkelistene utifra informasjonen.
                    //
                    // Dette burde skilles ut i hjelpemetoder leter gjennom listene
                    // og returnerer riktig objekt, ut ifra informasjonen som ble lest inn
                    //
                    //
                    // Dersom legeobjektene dine oppretter PResepter, kan du ignorere reit
                    //
                    // Sett deretter reseptobjektet inn i en lenkeliste
                    //

                    int legemiddelNummer = Integer.parseInt(info[0]);
                    Legemiddel legemiddel = finnLegemiddel(legemiddelNummer);

                    String legeNavn = info[1];
                    Lege lege = finnLege(legeNavn);

                    int pasientId = Integer.parseInt(info[2]);
                    Pasient pasient = finnPasientPaaId(pasientId);

                    int reit = Integer.parseInt(info[3]);

                    Resept r = new Hvit(legemiddel, lege, pasient, reit);
                    reseptliste.leggTil(r);
                    pasient.leggTilResept(r);
                    lege.leggTilResept(r);
                  }
              }

            }
            // slutt lesFraFil-metode.
        }

        public static Lege finnLege(String navn) {
          for(Lege l : legeliste) {
            if(navn.equals(l.hentNavn())) {
              return l;
            }
          }
          return null;
        }

        public static Pasient finnPasient(String navn) {
          for(Pasient p : pasientliste) {
            if(navn.equals(p.hentNavn())) {
              return p;
            }
          }
          return null;
        }

        public static Pasient finnPasientPaaId(int id) {
          for(Pasient p : pasientliste) {
            if(id == p.hentID()) {
              return p;
            }
          }
          return null;
        }

        public static Legemiddel finnLegemiddel(int id) {
          for(Legemiddel l : legemiddelliste) {
            if(id == l.hentId()) {
              return l;
            }
          }
          return null;
        }

        public static Resept finnResept(Resept resept) {
          for(Resept r : reseptliste) {
            if(resept.equals(r)) {
              return resept;
            }
          }
          return null;
        }

        public static Resept finnReseptPaaId(int id) {
          for(Resept r : reseptliste) {
            if(id == r.hentId()) {
              return r;
            }
          }
          return null;
        }


        // Skriver ut legelisten.
        public static void skrivLegeliste() {
          System.out.println("Leger: ");
          for(Lege lege : legeliste) {
            System.out.println(lege);
        }
      }

        public static void skrivLegemiddelliste() {
          System.out.println("Legemidler: ");
          for(Legemiddel l : legemiddelliste) {
              System.out.println(l);
          }
        }
        public static void skrivReseptliste() {
          System.out.println("Resepter: ");
          for(Resept r : reseptliste) {
            System.out.println(r);
          }
        }

        public static void skrivPasientliste() {
          System.out.println("Pasienter: ");
          for(Pasient p : pasientliste) {
            System.out.println(p);
          }
        }


        // skrivLegesystem-metode:
        public static void skrivLegesystem() {
          skrivLegeliste();
          skrivPasientliste();
          skrivLegemiddelliste();
          skrivReseptliste();
        }


        // Legge til en ny lege i systemet.
        public static void leggTilLege() {
          Scanner in = new Scanner(System.in);

          System.out.println("Er legen en spesialist? ja/nei");
          String svar = in.nextLine();
          if (svar.equals("nei")) {
            System.out.println("Navn: ");
            String navn = in.nextLine();
            Lege lege = new Lege(navn);
            legeliste.leggTil(lege);
          } else if (svar.equals("ja")) {
            System.out.println("Navn: ");
            String navn = in.nextLine();
            System.out.println("Kontroll-ID: ");
            String input = in.nextLine();
            int kontrollid = Integer.parseInt(input);
            Spesialist spes = new Spesialist(navn, kontrollid);
            legeliste.leggTil(spes);
          }
        }

        // Legge til en ny pasient i systemet.
        public static void leggTilPasient() {
          Scanner in = new Scanner(System.in);

          System.out.println("Navn: ");
          String navn = in.nextLine();
          System.out.print("Foedselsnummer: ");
          String foedselsnr = in.nextLine();
          Pasient pas = new Pasient(navn, foedselsnr);

          if(finnPasient(pas.hentNavn()) != null) {
            System.out.println("Pasienten finnes fra foer.");
          } else {
            pasientliste.leggTil(pas);
          }
        }


        // Legge til en en resept i systemet.
        public static void leggTilResept() {
          Scanner in = new Scanner(System.in);

          System.out.println("Id til legemiddelet som skal legges til på resepten: ");
          skrivLegemiddelliste();
          String input1 = in.nextLine();
          int inp1 = Integer.parseInt(input1);

          Legemiddel legemiddel = finnLegemiddel(inp1);

          System.out.println("Navn paa utskrivende lege: ");
          skrivLegeliste();
          String inp2 = in.nextLine();

          Lege lege = finnLege(inp2);

          System.out.print("Pasient-ID: ");
          skrivPasientliste();
          String input3 = in.nextLine();
          int inp3 = Integer.parseInt(input3);

          Pasient pasient = finnPasientPaaId(inp3);

          System.out.println("Antall reit på resepten: ");
          String input4 = in.nextLine();
          int inp4 = Integer.parseInt(input4);

          int reit = inp4;
          try {
            Resept resept = lege.skrivResept(legemiddel, pasient, reit);
            reseptliste.leggTil(resept);
          } catch (UlovligUtskrift e) {
            System.out.println("Kunne ikke lage resept.");
          }
        }

        // Legge til et nytt legemiddel i systemet;
        public static void leggTilLegemiddel() {
          Scanner in = new Scanner(System.in);

          System.out.println("Vil du legge til et 1: Preparat A, 2: Preparat B eller 3: Preparat C- legemiddel?");
          String svar = in.nextLine();
          if(svar.equals("1")) {
            System.out.print("Navn på legemiddel: ");
            String navn = in.nextLine();
            System.out.print("Pris: ");
            String inp1 = in.nextLine();
            double pris = Double.parseDouble(inp1);
            System.out.print("Virkestoff(mg): ");
            String inp2 = in.nextLine();
            double virkestoff = Double.parseDouble(inp2);
            System.out.print("Styrke: ");
            String inp3 = in.nextLine();
            int styrke = Integer.parseInt(inp3);
            PreparatA a = new PreparatA(navn, pris, virkestoff, styrke);
            legemiddelliste.leggTil(a);
          } else if(svar == "2") {
            System.out.print("Navn på legemiddel: ");
            String navn = in.nextLine();
            System.out.print("Pris: ");
            String inp1 = in.nextLine();
            double pris = Double.parseDouble(inp1);
            System.out.print("Virkestoff(mg): ");
            String inp2 = in.nextLine();
            Double virkestoff = Double.parseDouble(inp2);
            System.out.print("Styrke: ");
            String inp3 = in.nextLine();
            int styrke = Integer.parseInt(inp3);
            PreparatB b = new PreparatB(navn, pris, virkestoff, styrke);
            legemiddelliste.leggTil(b);
          } else if(svar == "3") {
            System.out.print("Navn på legemiddel: ");
            String navn = in.nextLine();
            System.out.print("Pris: ");
            String inp1 = in.nextLine();
            double pris = Double.parseDouble(inp1);
            System.out.print("Virkestoff(mg): ");
            String inp2 = in.nextLine();
            double virkestoff = Double.parseDouble(inp2);
            PreparatC c = new PreparatC(navn, pris, virkestoff);
            legemiddelliste.leggTil(c);
          }
        }

        // Bruke en resept.
        public static void brukResept() {
          Scanner in = new Scanner(System.in);
          System.out.println("Hvem skal hente ut resepten? ");
          skrivPasientliste();  // skriver ut oversikt over pasientene.
          String input = in.nextLine();  // tar inn nummer fra terminalen.
          int pasientID = Integer.parseInt(input);
          Pasient pas = finnPasientPaaId(pasientID);  //henter ut en pasient på oppgitt indeks.
          System.out.println("Hvilken resept vil du bruke?");
          System.out.println(pas.hentReseptliste().stoerrelse());
          pas.skrivReseptliste();
          String res = in.nextLine();
          int id = Integer.parseInt(res);

          Stabel<Resept> stabel = pas.hentReseptliste();
          Resept resept = finnReseptPaaId(id);
          if(resept.bruk()) {
            resept.reit--;
          } else {
            System.out.println("Kunne ikke bruke resept paa " + pas.hentNavn() + " (ingen gjenvaerende reit).");
          }
        }


        public static int skrivAntallVanedannende() {
          int teller = 0;
          for(Lege l : legeliste) {
            for(Resept r : l.hentReseptliste()) {
              if(r.hentLegemiddel() instanceof PreparatB) {
                  teller++;
              }
            }
          }
          return teller;
        }

        public static int skrivAntallNarkotiske() {
          int teller = 0;
          for(Lege l : legeliste) {
            for(Resept r : l.hentReseptliste()) {
              if(r.hentLegemiddel() instanceof PreparatA) {
                teller++;
              }
            }
          }
          return teller;
        }

        public static void skrivLegerMedNarkotisk() {
          System.out.println("Leger med antall narkotiske resepter: ");
          for(Lege l : legeliste) {
            int teller = 0;
            String navn = l.hentNavn();
            for(Resept r : l.hentReseptliste()) {
              if(r.hentLegemiddel() instanceof PreparatA) {
                teller++;
              }
            }
            System.out.println(navn + ": " + teller);
          }
        }

        public static void skrivPasienterMedNarkotisk() {
          System.out.println("Pasienter med antall narkotiske resepter: ");
          for(Pasient p : pasientliste) {
            int teller = 0;
            String navn = p.hentNavn();
            for(Resept r : p.hentReseptliste()) {
              if(r.hentLegemiddel() instanceof PreparatA) {
                teller++;
              }
            }
            System.out.println(navn + ": " + teller);
          }
        }
  }
