/*A variant of doublyLinkedList, the board where the games are played. The integer array "values"
* is a replication of what was given in the project assignment. "spaces" is a doublyLinkedList
* that is filled with the values from the aforementioned array.*/
public class Board {
    int[] values = {5 , 10, 8 , 10, 7,
                    5 , 9 , 10, 6 , 7,
                    10, 6 , 5 , 8 , 9,
                    5 , 10, 5 , 9 , 6,
                    8 , 7 , 10, 6 , 8};
    DoublyLinkedList spaces;
    /*Constructs a doublyLinkedList with the values of the spaces as the elements of the list. A for loop runs through
    * and adds the elements beginning at the last value in array "values". The rationale being that there is only
    * one method called to add elements to the list, addFirst. The list is generated similarly to train cars being
    * put together starting with the caboose, pushing it further down the tracks as more cars are added until the
    * first element added is the last one.*/
    public Board() {
        spaces = new DoublyLinkedList();
        for(int i = 24; i >= 0; i--) {
            spaces.addFirst(values[i]);
        }
    }
    //Accessor methods
    //Returns the list that the board is based on for accessing nodes and elements
    public DoublyLinkedList getDLL() {
        return this.spaces;
    }
    //Functions
    /*printBoard facilitates the board printout conducted. Takes the winning player of a game as a parameter.
    * After a game is played, this method is called on the board object created in the game class to output
    * the final state of the game after winning. General formatting was applied, as well as printing out
    * the positions of the non-winning players. If there is overlap on two spaces (i.e., a player gets sent back after
    * landing on an occupied space and in turn lands on another occupied space, really the only possible way two players
    * would end up on the same space), the player who occupied the space first is printed and the other is omitted.
    * The winner is taken as input and printed along with the board after the end space (trailer).*/
    public void printBoard(Player winner) {
        DoublyLinkedList.Node mover = this.spaces.getHeader();
        String winName = winner.getName();
        for(int i = 0; i < 5; i++){
            System.out.println();
            for(int j = 0; j < 5; j++){
                if(mover == this.spaces.getHeader()){
                    System.out.format("Start - %n");
                    mover = mover.getNext();
                    j--;
                }
                else if (mover == this.spaces.getTrailer()) {
                    break;
                }
                else {
                    if (mover.getOcc()){
                        if(mover.getNext() == this.spaces.getTrailer()) {
                            System.out.format("{ %2s } - ", mover.getElement());
                            break;
                        }
                        else {
                            System.out.format("{ %2s } - ", mover.getOccupant().getName());
                            mover = mover.getNext();
                        }
                    }
                    else {
                        System.out.format("{ %2s } - ", mover.getElement());
                        mover = mover.getNext();
                    }
                }
            }
            if (mover == this.spaces.getTrailer()) {
                break;
            }
        }
        System.out.format(" %nEnd %n");
        System.out.print("Winner: Player " + winName);
    }
}
