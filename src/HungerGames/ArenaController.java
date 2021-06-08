package HungerGames;
import java.util.*;

public class ArenaController {
    Arena arena;
    Random r = new Random();

    public ArenaController( Arena arena){
        this.arena = arena;
    }
    //Simulation will keep going until only 1 contestant is left, then snow kills the last contestant.
    public void runSimulation(){
        int i = 0;
        do {
            i++;
            System.out.println();
            System.out.println("This is day " + i + " of the tournament. Happy Hunger Games! And may the odds be ever in your favor!");
            System.out.println();
            if (meet()){
                arena.createPair();
                arena.fight();
            }
            else {
                System.out.println("There were no fights today");
            }
        } while (arena.contestantlist.size() > 1);
        System.out.println("There is only " + arena.contestantlist.size() + " contestant left...");
        President snow = President.getSnow();
        snow.snowKills(arena.contestantlist.get(r.nextInt(arena.contestantlist.size())), arena);
        System.out.println("There are " + arena.contestantlist.size() + " contestants left...");
    }

    public boolean meet(){
        double probability = 0.25; // (1 - probability) * 100)% chance that two contestants will meet
        double i = r.nextDouble();
        return i >= probability;
    }
}

