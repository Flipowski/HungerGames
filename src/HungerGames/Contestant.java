package HungerGames;
import java.util.*;

public class Contestant {
    Random r = new Random();
    double health;
    double attack;
    double defense;
    double hit;
    String gender;

    public Contestant(String gender){
        this.gender = gender;
    }
    public void hit(Contestant contestant) {
        this.hit = (this.attack / contestant.defense) * (r.nextInt(30 - 1 + 1)+1);
        contestant.health -= this.hit;
    }

    public boolean isAlive(){
        return this.health > 0;
    }

    public double getHealth(){
        return health;
    }
/*    public Contestant( String contestantNumber, int health, int attack, int defense, String gender){
        this.contestantNumber = contestantNumber;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.gender = gender;
    }*/

}
