class RekursjonsEksempel {
  public static void main(String[] args) {
    skrivTall(5);
  }

  public static void skrivTall(int n) {
    if (n < 0 ) {   // <- basistilfellet.
      return;
    }
    System.out.println(n);
    skrivTall(n-1); // må stoppes for å unngå StackOverflowError (uendelig med tall).
    //slutt = basistilfellet.

    // Kan også skrives:
    // if ( n >= 0) {
    //  System.out.println(n);
    //  skrivTall(n-1);
  }
  }
}
