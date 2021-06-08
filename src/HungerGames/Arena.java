package HungerGames;
import java.util.*;

public class Arena {
    List<Contestant> contestantList;
    List<BattleItem> battleItemList;
    Random r = new Random();
    Contestant contestant1;
    Contestant contestant2;
    double contestant1MaxHealth;
    double contestant2MaxHealth;

    // Constructor for Arena which creates 24 objects
    public Arena() {
        this.battleItemList = createBattleItemList();
        this.contestantList = createListContestants();
    }

    private List<Contestant> createListContestants() {
        ArrayList<Contestant> contestants = new ArrayList<Contestant>(24);
        for (int i = 0; i < 9; i++) {
            Contestant maleDistrictContestant = new DistrictContestant("male");
            Contestant femaleDistrictContestant = new DistrictContestant("female");
            contestants.add(maleDistrictContestant);
            contestants.add(femaleDistrictContestant);
        }
        for (int i = 0; i < 3; i++) {
            Contestant maleCareerContestant = new CareerContestant("male");
            maleCareerContestant.pickUpBattleItem(this);
            Contestant femaleCareerContestant = new CareerContestant("female");
            femaleCareerContestant.pickUpBattleItem(this);
            contestants.add(maleCareerContestant);
            contestants.add(femaleCareerContestant);
        }
        return contestants;
    }

    private List<BattleItem> createBattleItemList() {
        ArrayList<BattleItem> battleItems = new ArrayList<BattleItem>(14);
        for (int i = 0; i < 7; i++) {
            BattleItem weapon = new Weapon();
            battleItems.add(weapon);
        }
        for (int i = 0; i < 7; i++) {
            BattleItem armor = new Armor();
            battleItems.add(armor);
        }
        return battleItems;
    }

    // Show list of Contestants
    public void printContestants() {
        System.out.println("Contestants:");
        for (Contestant c : contestantList) {
            System.out.println(c);
        }
    }

    // Show list of battle items available in the arena
    public void printBattleItems() {
        System.out.println("Battle items:");
        for (BattleItem b : battleItemList) {
            System.out.println(b);
        }
    }

    // Two Contestants meet each other to fight
    public void createPair() {
        this.contestant1 = contestantList.get(r.nextInt(contestantList.size()));
        do {
            this.contestant2 = contestantList.get(r.nextInt(contestantList.size()));
        }
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
    public void fight() {
        do {
            contestant1.hit(contestant2);
//            System.out.println("Contestant1 hit contestant 2 for: " + Math.round(contestant1.hit) + " damage! Contestant2 is now at " + Math.round(contestant2.health) + " health.");
            contestant2.hit(contestant1);
//            System.out.println("Contestant2 hit contestant 1 for: " + Math.round(contestant2.hit) + " damage! Contestant1 is now at " + Math.round(contestant1.health) + " health.");
        } while (contestant1.isAlive() && contestant2.isAlive()); // Fight till death
        if (contestant1.health <= 0) { //Contestant 2 wins and gets the chance to find a weapon
            System.out.println("Contestant 2 is the winner, with " + Math.round(contestant2.health) + " health left. Contestant 1 is killed");
            System.out.println();
            contestantList.remove(contestant1);
            contestant2.health = contestant2MaxHealth;
            if (battleItemProbability()) {
                contestant2.pickUpBattleItem(this);
            } else {
                System.out.println("Contestant 2 did not find any battle item.");
            }
        } else { // Contestant 1 wins and gets the chance to find a weapon
            System.out.println("Contestant 1 is the winner, with " + Math.round(contestant1.health) + " health left. Contestant 2 is killed");
            System.out.println();
            contestantList.remove(contestant2);
            contestant1.health = contestant1MaxHealth;
            if (battleItemProbability()) {
                contestant1.pickUpBattleItem(this);
            } else {
                System.out.println("Contestant 1 did not find any battle item.");
            }
        }
    }

    public boolean battleItemProbability() {
        double probability = 0.8; // (1 - probability) * 100)% chance that winning contestants will find a battle item
        double i = r.nextDouble();
        return i >= probability;
    }
}


