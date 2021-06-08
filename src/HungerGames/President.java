package HungerGames;
//Singleton Pattern
public class President {
    String name = "Snow";

    private static President snow = new President();

    private President(){}

    public static President getSnow(){
    return snow;
    }

    public void snowKills(Contestant contestant, Arena arena){
        System.out.println("President " + name + " kills the last contestant!");
        arena.contestantlist.remove(contestant);
    }
}
