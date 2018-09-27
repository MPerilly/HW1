public class Player {
    private int spacesFromStart;
    private int score;
    private boolean win;
    public Player() {
        this.spacesFromStart = 0;
        this.score = 0;
        this.win = false;
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
    //Player Functions
    public void addSpacesFromStart(int move) {
        this.spacesFromStart += move;
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
