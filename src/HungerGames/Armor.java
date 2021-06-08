package HungerGames;
import java.util.*;

public class Armor extends BattleItem {
    Random r = new Random();

    public Armor() {
        this.defenseBonus = (r.nextDouble() + 1);
    }

    @Override
    public String toString(){
        return "The armor has a defense bonus of: " + this.defenseBonus;
    }
}
