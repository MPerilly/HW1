/*Main class. Running should ouput 40 boards, as well as a table of statistics.*/
import java.util.ArrayList;
public class Main {
    public static void main(String args[]) {
        GameFacilitator g1 = new GameFacilitator(1);
        GameFacilitator g2 = new GameFacilitator(2);
        GameFacilitator g3 = new GameFacilitator(3);
        GameFacilitator g4 = new GameFacilitator(4);
        g1.games1000();
        ArrayList<float[]> onePlayerStats = g1.calculateFinalStats();
        g2.games1000();
        ArrayList<float[]> twoPlayerStats = g2.calculateFinalStats();
        g3.games1000();
        ArrayList<float[]> threePlayerStats = g3.calculateFinalStats();
        g4.games1000();
        ArrayList<float[]> fourPlayerStats = g4.calculateFinalStats();
        printFinalStats(onePlayerStats, twoPlayerStats,
                        threePlayerStats, fourPlayerStats);
    }
    /*Takes four arrayLists of statistics as input, one for each set of 1000 games, as generated by
    * calculateFinalStatistics. Formats the output into a table similar to that on the project assignment sheet.
    * Please email msp501@nyu.edu for any additional information regarding logic.*/
    public static void printFinalStats(ArrayList<float[]> onePlayer,
                                ArrayList<float[]> twoPlayer,
                                ArrayList<float[]> threePlayer,
                                ArrayList<float[]> fourPlayer) {
        ArrayList<float[]> statTable = null;
        String line = "________________________";
        String divider = "|";
        String header = "Players in Game: ";
        String cats = "WR/AvgMoves/AvgTurns";
        String players = null;
        System.out.println();
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
            System.out.println();
            System.out.format("%20s", players);
            System.out.format("%8s", divider);
            for (float[] statList: statTable) {
                System.out.format("%7.3f / %4.3g / %4.3g %1s", statList[0], statList[1], statList[2], divider);
            }
            System.out.println();
            for (int j = 0; j < 5; j++){
                System.out.format("%1s", line);
            }
        }

    }
}
