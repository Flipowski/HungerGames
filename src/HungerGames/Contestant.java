package HungerGames;
import java.util.*;

public class Contestant {
    Random r = new Random();
    double health;
    double attack;
    double defense;
    double hit;
    String gender;
    BattleItem battleItem;

    public Contestant(String gender){
        this.gender = gender;
    }
    public void hit(Contestant contestant) {
        this.hit = (this.attack / contestant.defense) * (r.nextInt(30 - 1 + 1)+1);
        contestant.health -= this.hit;
    }

    public void pickUpBattleItem(Arena arena) {
        battleItem = arena.battleItemList.get(r.nextInt(arena.battleItemList.size()));
        {
            if (battleItem instanceof Weapon) {
                System.out.println("Contestant picks up weapon. Old attack: " + this.attack + ", New attack: " + (this.attack * battleItem.attackBonus));
                this.attack *= battleItem.attackBonus;
                arena.battleItemList.remove(battleItem);
            } else if (battleItem instanceof Armor) {
                System.out.println("Contestant picks up armor. Old defense: " + this.defense + ", New defense: " + (this.defense * battleItem.defenseBonus));
                this.defense *= battleItem.defenseBonus;
                arena.battleItemList.remove(battleItem);
            } else {
                System.out.println("There are no more battle items available");
            }
        }
    }


    public boolean isAlive(){
        return this.health > 0;
    }
}
