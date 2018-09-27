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
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        p4 = new Player();
        players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        turnCount = 0;
    }
    public void getNumberOfPlayers() {

    }
    public void getDieInfo() {
        System.out.println("Number of Sides:");
        System.out.print(gameDie.getSides());
        System.out.println("Seed:");
        System.out.print(gameDie.getSeed());
    }
    private void game1() {
        Player A = players.get(1);
        DoublyLinkedList gameBoard = playSpace.getDLL();
        this.turnCount = 0;
        while(!A.checkWin()){
            int criticalValue = gameDie.roll();
            A.addSpacesFromStart(criticalValue);
            A.updateScore(playSpace);
            turnCount++;
        }
        System.out.println("Player won in " + turnCount + " turns with a score of " + A.getScore() + ".");
    }
    public void game2() {
        Player A = players.get(1);
        Player B = players.get(2);
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
                        break;
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
                        break;
                    }
                }
                else {
                    B.sendBack();
                    B.updateScore(playSpace);
                    turnCount++;
                }
            }
        }
    }
    private void game3() {
        Player A = players.get(1);
        Player B = players.get(2);
        Player C = players.get(3);
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
                        break;
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
                        break;
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
                        break;
                    }
                }
                else {
                    C.sendBack();
                    C.updateScore(playSpace);
                    turnCount++;
                }
            }
        }
    }
    private void game4() {
        Player A = players.get(1);
        Player B = players.get(2);
        Player C = players.get(3);
        Player D = players.get(4);
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
                        break;
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
                        break;
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
                        break;
                    }
                }
                else {
                    C.sendBack();
                    C.updateScore(playSpace);
                    turnCount++;
                }
            }
        }
    }
    public void gameWithPlayers(int numOfPlayers) {
        if (numOfPlayers == 1){
            this.game1();
        }
        else if (numOfPlayers == 2) {
            this.game2();
        }
        else if (numOfPlayers == 3) {
            this.game3();
        }
        else if (numOfPlayers == 4) {
            this.game4();
        }
    }
}

