/*Player class fields:
* spacesFromStart: Index of the space which the player occupies.
* score: The player's score
* moves: The number of moves (i.e., the number of times the player has rolled the dice, not counting moves such as
* being sent backwards) specific to that instance of the player.
* win: Boolean for the win status of the player
* name: The player's name, in our case usually A, B, C, or D.
* Instances of this class move along the board and play the game as described in the project.*/
public class Player {
    private int spacesFromStart;
    private int score;
    private int moves;
    private boolean win;
    private String name;
    /*Constructor functions:
    * Parameters:
    *   String n: will be set to the player name
    * Initializes:
    *   spacesFromStart to zero (zero is the index of the header of the doubly linked list, or the start of the board).
    *   score to zero, because the player has scored no points
    *   win to false, because the player cannot win on turn one.
    *   name to input parameter n, which will be used to set occupancy and also while printing the board
    *   moves to zero, the first move occurring after the first roll.*/
    public Player(String n) {
        this.spacesFromStart = 0;
        this.score = 0;
        this.win = false;
        this.name = n;
        this.moves = 0;
    }
    //Accessor Methods, mostly self explanatory
    public int getSpacesFromStart() {
        this.checkWin();
        return this.spacesFromStart;
    }
    public int getScore() {
        return this.score;
    }
    /*Depreciated method used during testing before implementation of printBoard. Used to see where players were
    * and what their score was turn by turn when running test games. */
    public String getPrintInfo(){
        String printable = "Score: " + this.score + ", Position: " + this.spacesFromStart;
        return printable;
    }
    public String getName() {
        return this.name;
    }
    public boolean getWin() {
        return this.win;
    }
    public int getMoves() {return this.moves;}
    //Player Functions
    /*addSpacesFromStart Parameters:
    *   move: usually a value given by a call of roll method on the die class, the number of spaces to add to the
    *   player's position
    * The logic encapsulated here essentially eliminates the possibility for a player possessing an illegal index.
    * The method will only add spaces if the player's current index is less than 25 and the move does not put them past
    * the 25th space (and thus reaching the trailer, which would throw a null pointer exception when trying to update
    * the player's score). */
    public void addSpacesFromStart(int move) {
        if (this.spacesFromStart < 25 && (this.spacesFromStart + move) <= 25) {
            this.spacesFromStart += move;
            this.moves++;
        }
        else if ((this.spacesFromStart + move) > 25){
            this.spacesFromStart = 25;
            this.moves++;
        }
    }
    /*sendBack sends the player back 7 spaces if they are far enough from the start to allow that, otherwise just sets
    * them back at the header of the board (start square). Also checks if the player has won if on the 25th space
    * before sending them back (win takes priority over being sent back, project documentation didn't specify what
    * to do in this specific, albeit rare, case). */
    public void sendBack() {
        if (this.spacesFromStart >= 7) {
            this.spacesFromStart = this.spacesFromStart - 7;
        }
        else if (spacesFromStart == 25) {
            if(this.checkWin()) {
                this.spacesFromStart = 25;
            }
            else {
                this.spacesFromStart = 0;
            }
        }
        else {
            this.spacesFromStart = 0;
        }
    }
    /*updateScore parameters:
    *   b: the board which the game is being played currently.
    * The method calls getElementAt on board b, and adds the return value of the call to the respective players score.*/
    public void updateScore(Board b) {
        if (b.spaces.getElementAt(this.spacesFromStart) != null) {
            if (this.checkWin() == false) {
                int scoreAdd = (int) b.spaces.getElementAt(this.spacesFromStart);
                this.score += scoreAdd;
            }
        }
    }
    /*Arguably the most important, yet difficult method to implement logically, checkWin performs multiple operations
    * on instances:
    * If win conditions are met (first if statement), then the win condition is set to true and returned.
    * If the player is not at the 25th square (second if statement), then win is kept at false and returned.
    * In any other condition (on 25th square without proper score, etc.), the player is sent back to the first square,
    * win is kept at false and returned. */
    public boolean checkWin() {
        if(this.score > 44 && this.spacesFromStart >= 25) {
            this.win = true;
            return this.win;
        }
        else if (this.spacesFromStart < 25) {
            return this.win;
        }
        else {
            this.spacesFromStart = 1;
            return this.win;
        }
    }
}
