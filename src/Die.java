/*Basic die class.
* Variables:
* Value: the value which the roll takes
* randSeed: the seed which is used to generate the random integers the die produces
* sides: number of sides on the die (essentially the upper bound of the die, the lower bound being 1)
* rollCount: counter for the instances number of rolls
* n: the random number generator used to produce the values of rolls.*/
import java.util.Random;
public class Die {
    private int value;
    private int randSeed;
    private int sides;
    public int rollCount;
    Random n;
    /*Constructors offer multiple possible ways of declaring a die. For the first, we have parameters:
    * s: set the number of sides
    * sd: set the seed for the random number generator
    * This constructor has mostly depreciated and was used for testing the game without random values*/
    public Die(int s, int sd) {
        this.sides = s;
        this.randSeed = sd;
        this.n = new Random(randSeed);
        this.rollCount = 0;
    }
    /*Constructor parameters:
    * s: set number of sides
    * Only given a number of sides, the die will choose its own seed which is randomly generated between 0 and 999.
    * The reasoning behind this method of construction is two-fold: it allows for easy return of the seed (there is
    * no easy way to get the seed of a random number generator when allowed to generate its own), and also allows for
    * a third, simpler constructor.*/
    public Die(int s) {
        this.sides = s;
        Random seedGen = new Random();
        this.randSeed = seedGen.nextInt(1000);
        this.n = new Random(randSeed);
        this.rollCount = 0;
    }
    /*This constructor takes no parameters and instead calls the one above it, creating a six sided die. This is the
    * method of construction currently in use in the game.*/
    public Die() {
        this(6);
    }
    //Accessor methods are mostly self explanatory
    public int getSides() {
        return this.sides;
    }
    public int getSeed() {
        return this.randSeed;
    }
    public int getRollCount() {
        return this.rollCount;
    }
    //Functions
    /*The roll method is essentially its name - the die is rolled, and produces a value between 1 and the number of
    * sides on the die. Also increments the rollCount variable. Returns the value of the "roll".*/
    public int roll() {
        value = (n.nextInt(this.getSides()) + 1);
        this.rollCount++;
        return value;
    }
}
