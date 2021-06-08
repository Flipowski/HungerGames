package HungerGames;
import java.util.*;

public class DistrictContestant extends Contestant {
    private final String section = "district";

    public DistrictContestant( String gender ) {
        super(gender);
        this.health = r.nextInt((400-200) + 1) + 200;
        this.attack = r.nextInt((20-1) + 1) + 40;
        this.defense = r.nextInt((20-1) + 1) + 60;
    }
    @Override
    public String toString(){
        return "Contestant is a " + this.section + " "+ this.gender + ". Attack level: " + this.attack + ", Defense level: " + this.defense + ", Max Health: " + this.health;
    }
}
