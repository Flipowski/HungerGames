package HungerGames;
import java.util.*;

public class Arena {
    List<Contestant> contestantlist;
    Random r = new Random();
    Contestant contestant1;
    Contestant contestant2;
    double contestant1MaxHealth;
    double contestant2MaxHealth;

    // Constructor for Arena which creates 24 objects
    public Arena() {
        this.contestantlist = createList();
    }
    private List<Contestant> createList() {
        ArrayList<Contestant> contestants = new ArrayList<Contestant>(24);
        for (int i = 0; i < 9; i++) {
            Contestant maleDistrictContestant = new DistrictContestant("male");
            Contestant femaleDistrictContestant = new DistrictContestant("female");
            contestants.add(maleDistrictContestant);
            contestants.add(femaleDistrictContestant);
        }
        for (int i = 0; i < 3; i++) {
            Contestant maleCareerContestant = new CareerContestant("male");
            Contestant femaleCareerContestant = new CareerContestant("female");
            contestants.add(maleCareerContestant);
            contestants.add(femaleCareerContestant);
        }
        return contestants;
    }

    // print list of Contestants
    public void printContestants(){
        System.out.println("Contestants:");
        for (Contestant c : contestantlist) {
            System.out.println(c);
        }
    }
    // Two Contestants meet each other to fight
    public void createPair(){
        this.contestant1 = contestantlist.get(r.nextInt(contestantlist.size()));
        do {this.contestant2 = contestantlist.get(r.nextInt(contestantlist.size()));}
        while (this.contestant2 == this.contestant1); // make sure two unique contestants are picked from list
        contestant1MaxHealth = contestant1.health;
        contestant2MaxHealth = contestant2.health;

        System.out.println("Contestant 1:");
        System.out.println(contestant1);
        System.out.println();
        System.out.println("Contestant 2:");
        System.out.println(contestant2);
        System.out.println();
    }
    // Fighting mechanics
    public void fight(){
        do {
            contestant1.hit(contestant2);
//            System.out.println("Contestant1 hit contestant 2 for: " + Math.round(contestant1.hit) + " damage! Contestant2 is now at " + Math.round(contestant2.health) + " health.");
            contestant2.hit(contestant1);
//            System.out.println("Contestant2 hit contestant 1 for: " + Math.round(contestant2.hit) + " damage! Contestant1 is now at " + Math.round(contestant1.health) + " health.");
    } while ( contestant1.isAlive() && contestant2.isAlive()); // Fight till death
        if (contestant1.health <= 0){
            System.out.println("Contestant 2 is the winner, with " + Math.round(contestant2.health) + " health left. Contestant 1 is killed");
            System.out.println();
            contestantlist.remove(contestant1);
            contestant2.health = contestant2MaxHealth;
        }
        else {
            System.out.println("Contestant 1 is the winner, with " + Math.round(contestant1.health) + " health left. Contestant 2 is killed");
            System.out.println();
            contestantlist.remove(contestant2);
            contestant1.health = contestant1MaxHealth;
        }
    }
}
