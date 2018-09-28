public class Board {
    int[] values = {5 , 10, 8 , 10, 7,
                    5 , 9 , 10, 6 , 7,
                    10, 6 , 5 , 8 , 9,
                    5 , 10, 5 , 9 , 6,
                    8 , 7 , 10, 6 , 8};
    DoublyLinkedList spaces;
    public Board() {
        spaces = new DoublyLinkedList();
        for(int i = 24; i >= 0; i--) {
            spaces.addFirst(values[i]);
        }
    }
    //Accessor methods
    public DoublyLinkedList getDLL() {
        return this.spaces;
    }
    //Functions
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
