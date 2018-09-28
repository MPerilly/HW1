import java.util.ArrayList;
public class GameFacilitator{
    //TODO Class facilitates 1000 games, as well as generating statistics for games
    int[][] winCount;
    Game g;
    public GameFacilitator(){
        winCount = new int[4][4];
    }
    public void games1000(int numOfPlayers){
        if(numOfPlayers == 1) {
            for(int i = 0; i < 1000; i++){
                g = new Game();
                Player winner = g.gameWithPlayers(numOfPlayers);
            }
        }
        else if (numOfPlayers == 2){
            for(int i = 0; i < 1000; i++){
                g = new Game();
                Player winner = g.gameWithPlayers(numOfPlayers);
            }
        }
        else if (numOfPlayers == 3){
            for(int i = 0; i < 1000; i++){
                g = new Game();
                Player winner = g.gameWithPlayers(numOfPlayers);
            }
        }
        else if (numOfPlayers == 4){
            for(int i = 0; i < 1000; i++){
                g = new Game();
                Player winner = g.gameWithPlayers(numOfPlayers);
            }
        }
        else {
            System.out.println("Invalid number of players.");
        }

    }

}
