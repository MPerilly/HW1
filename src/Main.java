import java.util.ArrayList;
public class Main {
    public static void main(String args[]) {
        GameFacilitator g = new GameFacilitator(3);
        g.games1000();
        ArrayList<float[]> stats = g.calculateFinalStats();
    }
}
