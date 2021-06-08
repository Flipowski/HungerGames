package HungerGames;
import java.util.*;

public class Weapon extends BattleItem{
    Random r = new Random();

    public Weapon(){
        this.attackBonus = (r.nextDouble() + 1);
    }

    @Override
    public String toString(){
        return "The weapon has an attack bonus of: " + this.attackBonus;
    }
}
