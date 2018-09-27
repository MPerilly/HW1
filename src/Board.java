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
    public void printBoard() {
        DoublyLinkedList.Node mover = this.spaces.getHeader();
        for(int i = 0; i < 5; i++){
            System.out.println();
            for(int j = 0; j < 5; j++){
                if(mover == this.spaces.getHeader()){
                    System.out.print("Start - ");
                    j--;
                }
                else if (mover == this.spaces.getTrailer()) {
                    System.out.print(" - End");
                    break;
                }
                else {
                    if (mover.getOcc()){

                        System.out.print("");
                    }
                    else {
                        System.out.print("{ " + mover.getElement() + " } - ");
                    }
                }
            }
            if (mover == this.spaces.getTrailer()) {
                break;
            }
        }
    }
}
