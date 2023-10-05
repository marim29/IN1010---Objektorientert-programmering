class Blaa extends Resept {

  public Blaa(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    @Override
    public String toString() {
      return "Legemiddel" + legemiddel + "\n Utskrivende lege: " + utskrivendeLege +
      "\n Pasient-id: " + pasientId + "\n Antall ganger igjen paa resepten: " + reit;
    }

    @Override
    public String farge() {
      return "Blaa";
    }

    public double prisAaBetale() {
      return legemiddel.hentPris()*0.25;
    }
}
