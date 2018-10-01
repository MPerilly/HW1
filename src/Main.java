import java.util.ArrayList;
public class Main {
    public static void main(String args[]) {
        GameFacilitator g = new GameFacilitator(2);
        g.games1000();
        //TODO fix calculate final stats method for multiple players
        ArrayList<float[]> stats = g.calculateFinalStats();
    }
}
