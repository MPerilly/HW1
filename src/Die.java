import java.util.Random;
public class Die {
    private int value;
    private int randSeed;
    private int sides;
    public int rollCount;
    Random n;
    public Die(int s, int sd) {
        this.sides = s;
        this.randSeed = sd;
        this.n = new Random(randSeed);
        this.rollCount = 0;
    }
    public Die(int s) {
        this.sides = s;
        Random seedGen = new Random();
        this.randSeed = seedGen.nextInt(1000);
        this.n = new Random(randSeed);
        this.rollCount = 0;
    }
    public Die() {
        this(6);
    }
    public int getSides() {
        return this.sides;
    }
    public int getSeed() {
        return this.randSeed;
    }
    public int getRollCount() {
        return this.rollCount;
    }
    public int roll() {
        value = (n.nextInt(this.getSides()) + 1);
        this.rollCount++;
        return value;
    }
}
