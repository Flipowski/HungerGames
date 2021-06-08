package HungerGames;

public class Main {
    public static void main(String[] args) {
        ArenaController arenaController = new ArenaController( new Arena());
        arenaController.runSimulation();
    }
}
