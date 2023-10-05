class Parkeringshus {
  private int antParkeringsplasser;
}

class Parkeringsplass extends Parkeringshus {

}

class Person extends Parkeringsplass {
  int alder;

}

class Motorsykkel extends Person {
  String sjofør;

}

class Bil extends Person {
  String sjofør;

}
