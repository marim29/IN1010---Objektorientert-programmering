class Kaningaard {}

    private Kanin [] kaniner = new Kanin[100];

    public boolean full() {
        for(Kanin kanin : kaniner){
            if(kanin == null){
                return false;
            }
        }
        return true;
    }

    public boolean tom () {
        for(Kanin kanin : kaniner){
            if(kanin != null){
                return false;
            }
        }
        return true;
    }

    public Kanin finnEn(String navn) {
        for(Kanin kanin : kaniner){
            if(kanin != null){
                if(navn.equals( kanin.hentNavn() )){
                    return kanin;
                }
            }
        }
        //System.out.println("Fant ingen kaniner ved navn "+navn);
        return null;
    }

    public void settInn (Kanin kanin) {
        if(finnEn(kanin.hentNavn()) != null){
            System.out.println(kanin.hentNavn()+" finnes allerede i Kaningaarden");
        }else if(full()){
            System.out.println("Kaningaarden er full!");
        }else{
            for(int i = 0; i<kaniner.length; i++){
                if(kaniner[i] == null){
                    kaniner[i] = kanin;
                    return;
                }
            }
        }

    }

    public void fjern(String navn) {
        for(int i = 0; i<kaniner.length; i++){
            if(kaniner[i] != null){
                if(kaniner[i].hentNavn().equals(navn)){
                    kaniner[i] = null;
                    return;
                }
            }
        }
        System.out.println("Provde aa fjerne "+navn+", men fant ikke kaninen");
    }

}
