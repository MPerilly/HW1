import java.util.ArrayList;
public class GameFacilitator{
    //TODO Class facilitates 1000 games, as well as generating statistics for games
    int[] winCount;
    Game g;
    ArrayList<Object> rawStats;
    int numOfPlayers;
    public GameFacilitator(int players) {
        this.winCount = new int[4];
        this.rawStats = new ArrayList<>();
        this.numOfPlayers = players;
    }
    public int[] getWinCount() {return this.winCount;}
    public ArrayList<Object>  getRawStats() {return this.rawStats;}

    public void games1000(){
        if(numOfPlayers == 1 || numOfPlayers == 2 || numOfPlayers == 3 || numOfPlayers == 4) {
            for(int i = 0; i < 1000; i++){
                g = new Game();
                Player winner = g.gameWithPlayers(numOfPlayers);
                if ((i + 1) % 100 == 0){
                    Board gameBoard = g.getBoard();
                    gameBoard.printBoard(winner);
                }
                this.updateRawStats(g, winner);
            }
        }
        else {
            System.out.println("Invalid number of players.");
        }

    }
    public int[] playerSpecificMoves() {
        return g.getPlayerInfo();
    }
    public int gameSpecificMoves() {
        return g.getTurnCount();
    }
    public void updateRawStats(Game g, Player winner) {
        int turns = g.getTurnCount();
        int moves = winner.getMoves();
        ArrayList<Object> preStats = new ArrayList<>();
        preStats.add(winner);
        preStats.add(moves);
        preStats.add(turns);
        this.rawStats.add(preStats);
    }

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
