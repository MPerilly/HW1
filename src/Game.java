import java.util.ArrayList;
public class Game {
    private Board playSpace;
    private Die gameDie;
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;
    private int turnCount;
    private ArrayList<Player> players;
    public Game() {
        playSpace = new Board();
        gameDie = new Die();
        p1 = new Player("A");
        p2 = new Player("B");
        p3 = new Player("C");
        p4 = new Player("D");
        players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        turnCount = 0;
    }
    //Accessor Methods
    public void getDieInfo() {
        System.out.println("Number of Sides:");
        System.out.print(gameDie.getSides());
        System.out.println("Seed:");
        System.out.print(gameDie.getSeed());
    }
    public Board getBoard(){
        return this.playSpace;
    }
    public int getTurnCount() {return this.turnCount;}
    //Functions
    public Player game1() {
        Player A = players.get(0);
        this.turnCount = 0;
        while(!A.checkWin()){
            int criticalValue = gameDie.roll();
            A.addSpacesFromStart(criticalValue);
            A.updateScore(playSpace);
            turnCount++;
        }
        System.out.println("Player " + A.getName() + " won in " + turnCount + " turns with a score of " + A.getScore() + ".");
        return A;
    }
    public Player game2() {
        Player A = players.get(0);
        Player B = players.get(1);
        DoublyLinkedList gameBoard = playSpace.getDLL();
        this.turnCount = 0;
        while(!A.checkWin() && !B.checkWin()) {
            int criticalValue = gameDie.roll();
            if(((turnCount + 2) % 2) == 0 ){
                gameBoard.getNodeAt(A.getSpacesFromStart()).setOcc(false);
                gameBoard.getNodeAt(A.getSpacesFromStart()).removeOccupant();
                A.addSpacesFromStart(criticalValue);
                if(!gameBoard.getNodeAt(A.getSpacesFromStart()).getOcc()) {
                    DoublyLinkedList.Node playerAZone = gameBoard.getNodeAt(A.getSpacesFromStart());
                    playerAZone.setOcc(true);
                    playerAZone.setOccupied(A);
                    A.updateScore(playSpace);
                    turnCount++;
                    if(A.checkWin()) {
                        System.out.println("Player A won");
                        return A;
                    }
                }
                else{
                    A.sendBack();
                    A.updateScore(playSpace);
                    turnCount++;
                }
            }
            else{
                gameBoard.getNodeAt(B.getSpacesFromStart()).setOcc(false);
                gameBoard.getNodeAt(B.getSpacesFromStart()).removeOccupant();
                B.addSpacesFromStart(criticalValue);
                if(!gameBoard.getNodeAt(B.getSpacesFromStart()).getOcc()) {
                    DoublyLinkedList.Node playerBZone = gameBoard.getNodeAt(B.getSpacesFromStart());
                    playerBZone.setOcc(true);
                    playerBZone.setOccupied(B);
                    B.updateScore(playSpace);
                    turnCount++;
                    if(B.checkWin()) {
                        System.out.println("Player B Won");
                        return B;
                    }
                }
                else {
                    B.sendBack();
                    B.updateScore(playSpace);
                    turnCount++;
                }
            }
        }
        return null;
    }
    private Player game3() {
        Player A = players.get(0);
        Player B = players.get(1);
        Player C = players.get(2);
        DoublyLinkedList gameBoard = playSpace.getDLL();
        this.turnCount = 0;
        while(!A.checkWin() && !B.checkWin()) {
            int criticalValue = gameDie.roll();
            if(((turnCount + 3) % 3) == 0 ){
                System.out.println("Player A Moves. Info from previous turn:");
                System.out.println(A.getPrintInfo());
                gameBoard.getNodeAt(A.getSpacesFromStart()).setOcc(false);
                gameBoard.getNodeAt(A.getSpacesFromStart()).removeOccupant();
                A.addSpacesFromStart(criticalValue);
                if(!gameBoard.getNodeAt(A.getSpacesFromStart()).getOcc()) {
                    DoublyLinkedList.Node playerAZone = gameBoard.getNodeAt(A.getSpacesFromStart());
                    playerAZone.setOcc(true);
                    playerAZone.setOccupied(A);
                    A.updateScore(playSpace);
                    turnCount++;
                    if(A.checkWin()) {
                        System.out.println("Player A won");
                        return A;
                    }
                }
                else{
                    A.sendBack();
                    A.updateScore(playSpace);
                    turnCount++;
                }
            }
            else if (((turnCount + 3) % 3) == 1 ){
                System.out.println("Player B Moves. Info from previous turn:");
                System.out.println(B.getPrintInfo());
                gameBoard.getNodeAt(B.getSpacesFromStart()).setOcc(false);
                gameBoard.getNodeAt(B.getSpacesFromStart()).removeOccupant();
                B.addSpacesFromStart(criticalValue);
                if(!gameBoard.getNodeAt(B.getSpacesFromStart()).getOcc()) {
                    DoublyLinkedList.Node playerBZone = gameBoard.getNodeAt(B.getSpacesFromStart());
                    playerBZone.setOcc(true);
                    playerBZone.setOccupied(B);
                    B.updateScore(playSpace);
                    turnCount++;
                    if(B.checkWin()) {
                        System.out.println("Player B Won");
                        return B;
                    }
                }
                else {
                    B.sendBack();
                    B.updateScore(playSpace);
                    turnCount++;
                }
            }
            else if (((turnCount + 3) % 3) == 2 ){
                System.out.println("Player C Moves. Info from previous turn:");
                System.out.println(C.getPrintInfo());
                gameBoard.getNodeAt(C.getSpacesFromStart()).setOcc(false);
                gameBoard.getNodeAt(C.getSpacesFromStart()).removeOccupant();
                C.addSpacesFromStart(criticalValue);
                if(!gameBoard.getNodeAt(C.getSpacesFromStart()).getOcc()) {
                    DoublyLinkedList.Node playerCZone = gameBoard.getNodeAt(C.getSpacesFromStart());
                    playerCZone.setOcc(true);
                    playerCZone.setOccupied(C);
                    C.updateScore(playSpace);
                    turnCount++;
                    if(C.checkWin()) {
                        System.out.println("Player C Won");
                        return C;
                    }
                }
                else {
                    C.sendBack();
                    C.updateScore(playSpace);
                    turnCount++;
                }
            }
        }
        return null;
    }
    private Player game4() {
        Player A = players.get(0);
        Player B = players.get(1);
        Player C = players.get(2);
        Player D = players.get(3);
        DoublyLinkedList gameBoard = playSpace.getDLL();
        this.turnCount = 0;
        while(!A.checkWin() && !B.checkWin()) {
            int criticalValue = gameDie.roll();
            if(((turnCount + 4) % 4) == 0 ){
                System.out.println("Player A Moves. Info from previous turn:");
                System.out.println(A.getPrintInfo());
                gameBoard.getNodeAt(A.getSpacesFromStart()).setOcc(false);
                gameBoard.getNodeAt(A.getSpacesFromStart()).removeOccupant();
                A.addSpacesFromStart(criticalValue);
                if(!gameBoard.getNodeAt(A.getSpacesFromStart()).getOcc()) {
                    DoublyLinkedList.Node playerAZone = gameBoard.getNodeAt(A.getSpacesFromStart());
                    playerAZone.setOcc(true);
                    playerAZone.setOccupied(A);
                    A.updateScore(playSpace);
                    turnCount++;
                    if(A.checkWin()) {
                        System.out.println("Player A won");
                        return A;
                    }
                }
                else{
                    A.sendBack();
                    A.updateScore(playSpace);
                    turnCount++;
                }
            }
            else if (((turnCount + 4) % 4) == 1 ){
                System.out.println("Player B Moves. Info from previous turn:");
                System.out.println(B.getPrintInfo());
                gameBoard.getNodeAt(B.getSpacesFromStart()).setOcc(false);
                gameBoard.getNodeAt(B.getSpacesFromStart()).removeOccupant();
                B.addSpacesFromStart(criticalValue);
                if(!gameBoard.getNodeAt(B.getSpacesFromStart()).getOcc()) {
                    DoublyLinkedList.Node playerBZone = gameBoard.getNodeAt(B.getSpacesFromStart());
                    playerBZone.setOcc(true);
                    playerBZone.setOccupied(B);
                    B.updateScore(playSpace);
                    turnCount++;
                    if(B.checkWin()) {
                        System.out.println("Player B Won");
                        return B;
                    }
                }
                else {
                    B.sendBack();
                    B.updateScore(playSpace);
                    turnCount++;
                }
            }
            else if (((turnCount + 4) % 4) == 2 ){
                System.out.println("Player C Moves. Info from previous turn:");
                System.out.println(C.getPrintInfo());
                gameBoard.getNodeAt(C.getSpacesFromStart()).setOcc(false);
                gameBoard.getNodeAt(C.getSpacesFromStart()).removeOccupant();
                C.addSpacesFromStart(criticalValue);
                if(!gameBoard.getNodeAt(C.getSpacesFromStart()).getOcc()) {
                    DoublyLinkedList.Node playerCZone = gameBoard.getNodeAt(C.getSpacesFromStart());
                    playerCZone.setOcc(true);
                    playerCZone.setOccupied(C);
                    C.updateScore(playSpace);
                    turnCount++;
                    if(C.checkWin()) {
                        System.out.println("Player C Won");
                        return C;
                    }
                }
                else {
                    C.sendBack();
                    C.updateScore(playSpace);
                    turnCount++;
                }
            }
            //TODO Add fourth player logic
        }
        return null;
    }
    public Player gameWithPlayers(int numOfPlayers) {
        if (numOfPlayers == 1){
            return this.game1();
        }
        else if (numOfPlayers == 2) {
            return this.game2();
        }
        else if (numOfPlayers == 3) {
            return this.game3();
        }
        else if (numOfPlayers == 4) {
            return this.game4();
        }
        return null;
    }
    //TODO add game statistic gatherer
    //TODO create method to play games 1000 times
}

