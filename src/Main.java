public class Main {
    public static void main(String args[]) {
        Game g = new Game();
        Player win = g.game1();
        g.getBoard().printBoard(win);
    }
}
