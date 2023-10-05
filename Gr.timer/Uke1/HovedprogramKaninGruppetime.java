class Hovedprogram{
    public static void main(String[] args){
        Kaningaard kg = new Kaningaard();
        System.out.println("Er kaningaarden tom naa i starten? \t"+kg.tom());
        kg.settInn(new Kanin("Live"));
        kg.settInn(new Kanin("Hassan"));
        kg.settInn(new Kanin("Phong"));

        System.out.println("er gaarden full?\t"+kg.full());
        kg.fjern("olav");

    }
}
