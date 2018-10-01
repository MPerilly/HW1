import java.util.ArrayList;
public class Main {
    public static void main(String args[]) {
        GameFacilitator g = new GameFacilitator(2);
        g.games1000();
        ArrayList<float[]> stats = g.calculateFinalStats();
    }
    public void printFinalStats(ArrayList<float[]> onePlayer,
                                ArrayList<float[]> twoPlayer,
                                ArrayList<float[]> threePlayer,
                                ArrayList<float[]> fourPlayer) {
        ArrayList<float[]> statTable = null;
        String line = "_________________________";
        String divider = "|";
        String header = "Players in Game: ";
        String cats = "WR/AvgMoves/AvgTurns";
        System.out.format("%2s", header);
        System.out.format("%2s", divider);
        for (int i = 0; i < 4; i++) {

        }
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0: statTable = onePlayer;
                    break;
                case 1: statTable = twoPlayer;
                    break;
                case 2: statTable = threePlayer;
                    break;
                case 3: statTable = fourPlayer;
                    break;
            }
            for (int j = 0; j <= i; j++){
                float[] statData = statTable.get(j);
            }
        }
    }
}
