import java.util.Scanner;

class HeiVerden {
  public static void main(String[] args) {
    Scanner tastatur = new Scanner(System.in);
    System.out.println("Hei! Hva heter du?");
    String input = tastatur.nextLine();
    System.out.println("Hei, " + input + "!" + " Velkommen til IN1010.");
    Person Per = new Person(22, input);
    Per.skrivUt();
    Per.haBursdag();
  }
}
