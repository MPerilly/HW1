/*GameFacilitator fields:
* g: Instance of game class, used to run games
* rawStats: empty generic arrayList for storage of game statistics to be processed later
* numOfPlayers: an integer specifying the number of players to play 1000 games with*/
import java.util.ArrayList;
public class GameFacilitator{
    Game g;
    ArrayList<Object> rawStats;
    int numOfPlayers;
    /*Constructor:
    *   Initializes:
    *       rawStats: as a generic ArrayList
    *       numOfPlayers: to input parameter players*/
    public GameFacilitator(int players) {
        this.rawStats = new ArrayList<>();
        this.numOfPlayers = players;
    }
    //Accessor methods, mostly self explanatory
    public ArrayList<Object>  getRawStats() {return this.rawStats;}
    public int[] playerSpecificMoves() {
        return g.getPlayerInfo();
    }
    public int gameSpecificMoves() {
        return g.getTurnCount();
    }
    /*games1000 creates a new instance of class game, g, for each of the 1000 games. This ensures randomness and
    * a clean slate when starting a new game. If it is the 100th, 200th, 300th, ... , 1000th game, then the
    * board is printed after a player wins it. Then, raw stats is updated with the winning player and the game.*/
    public void games1000(){
        if(numOfPlayers == 1 || numOfPlayers == 2 || numOfPlayers == 3 || numOfPlayers == 4) {
            for(int i = 0; i < 1000; i++){
                g = new Game();
                Player winner = g.gameWithPlayers(numOfPlayers);
                if ((i + 1) % 100 == 0){
                    Board gameBoard = g.getBoard();
                    gameBoard.printBoard(winner);
                }
                else if (winner == null) {
                    System.out.println("Error");
                }
                this.updateRawStats(g, winner);
            }
        }
        else {
            System.out.println("Invalid number of players.");
        }

    }
    /*Takes the finished game g and winner of the game winner as parameters, gets the number of turns total from the
    * game and number of moves total of the winning player. The winning player, and the two numeric values are added
    * to an arrayList, preStats, which is then added to the gameFacilitators rawStats array, updating it.*/
    public void updateRawStats(Game g, Player winner) {
        int turns = g.getTurnCount();
        int moves = winner.getMoves();
        ArrayList<Object> preStats = new ArrayList<>();
        preStats.add(winner);
        preStats.add(moves);
        preStats.add(turns);
        this.rawStats.add(preStats);
    }
    /*Takes all the data generated in the class' copy of rawStats and manipulates to return the final array of stats.
    * The final stats arrayList is an arrayList of four float arrays with three elements each. These numbers
    * correspond to a players win rate, the average number of moves taken to win, and average number of turns taken
    * to win. Figuring out which player to attribute statistics to is done via switch statement based on player names
    * (because the winning player object itself is encapsulated in rawStats, it is accessible here). Returns the
    * final list for print output in main.*/
    public ArrayList<float[]> calculateFinalStats(){
        ArrayList<float[]> finalStats = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            float[] finalPlayerStats = new float[3];
            float winCount = 0;
            float totalMoves = 0;
            float totalTurns = 0;
            String nameCheck = null;
            switch(i) {
                case 0: nameCheck = "A";
                        break;
                case 1: nameCheck = "B";
                        break;
                case 2: nameCheck = "C";
                        break;
                case 3: nameCheck = "D";
                        break;
            }
            for(int j = 0; j < this.rawStats.size(); j++){
                ArrayList<Object> specStats = (ArrayList<Object>)(this.rawStats.get(j));
                Player pCheck = (Player)(specStats.get(0));
                String playerName = pCheck.getName();
                if (nameCheck.equals(playerName)) {
                    winCount++;
                    totalMoves += (int)(specStats.get(1));
                    totalTurns += (int)(specStats.get(2));
                }
            }
            float winRate = winCount/1000;
            float avgMoves = totalMoves/1000;
            float avgTurns = totalTurns/1000;
            finalPlayerStats[0] = winRate;
            finalPlayerStats[1] = avgMoves;
            finalPlayerStats[2] = avgTurns;
            finalStats.add(finalPlayerStats);
        }
        return finalStats;
    }
}
