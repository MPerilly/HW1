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
        String line = "________________________";
        String divider = "|";
        String header = "Players in Game: ";
        String cats = "WR/AvgMoves/AvgTurns";
        String players = null;
        System.out.format("%-27s", header);
        System.out.format(divider);
        for (int i = 0; i < 4; i++) {
            System.out.format("%21s", cats);
            System.out.format("%1$2s", divider);
        }
        System.out.println();
        for (int i = 0; i < 5; i++){
            System.out.format("%1s", line);
        }
        for (int i = 0; i < 4; i++){
            switch (i) {
                case 0: statTable = onePlayer;
                        players = "A";
                        break;
                case 1: statTable = twoPlayer;
                        players = "A, B";
                        break;
                case 2: statTable = threePlayer;
                        players = "A, B, C";
                        break;
                case 3: statTable = fourPlayer;
                        players = "A, B, C, D";
                        break;
            }
            System.out.format("%20s", players);
            System.out.format("%-44", divider);
            for (float[] statList: statTable) {
                System.out.format("%7f / %7f / %7f %1s", statList[0], statList[1], statList[2] divider);
            }
            System.out.println();
        }

    }
}
