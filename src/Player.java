public class Player {
    private int spacesFromStart;
    private int score;
    private int moves;
    private boolean win;
    private String name;
    public Player(String n) {
        this.spacesFromStart = 0;
        this.score = 0;
        this.win = false;
        this.name = n;
        this.moves = 0;
    }
    //Accessor Methods
    public int getSpacesFromStart() {
        this.checkWin();
        return this.spacesFromStart;
    }
    public int getScore() {
        return this.score;
    }
    public String getPrintInfo(){
        String printable = "Score: " + this.score + ", Position: " + this.spacesFromStart;
        return printable;
    }
    public String getName() {
        return this.name;
    }
    public int getMoves() {return this.moves;}
    //Player Functions
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
    public void sendBack() {
        if (this.spacesFromStart >= 7) {
            this.spacesFromStart = this.spacesFromStart - 7;
        }
        else {
            this.spacesFromStart = 0;
        }
    }
    public void updateScore(Board b) {
        if (b.spaces.getElementAt(this.spacesFromStart) != null) {
            if (this.checkWin() == false) {
                int scoreAdd = (int) b.spaces.getElementAt(this.spacesFromStart);
                this.score += scoreAdd;
            }
        }
    }
    public boolean checkWin() {
        if(this.score > 44 && this.spacesFromStart >= 25) {
            win = true;
            return win;
        }
        else if (this.spacesFromStart <= 25) {
            return win;
        }
        else {
            this.spacesFromStart = 0;
            return win;
        }
    }
}
