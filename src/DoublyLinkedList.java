public class DoublyLinkedList<E> {

    //---------------- nested Node class ----------------
    /**
     * Node of a doubly linked list, which stores a reference to its
     * element and to both the previous and next node in the list.
     */
    public static class Node<E> {

        /** The element stored at this node */
        private E element;               // reference to the element stored at this node

        /** A reference to the preceding node in the list */
        private Node<E> prev;            // reference to the previous node in the list

        /** A reference to the subsequent node in the list */
        private Node<E> next;            // reference to the subsequent node in the list
        //Additional node element, true or false as to whether the space is occupied
        private boolean occupied;
        //Additional node element, holds a reference to a player which occupies the space
        private Player occupant;

        /**
         * Creates a node with the given element and next node.
         *
         * @param e  the element to be stored
         * @param p  reference to a node that should precede the new node
         * @param n  reference to a node that should follow the new node
         */
        public Node(E e,  Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
            occupied = false;
            occupant = null;
        }

        // public accessor methods
        /**
         * Returns the element stored at the node.
         * @return the element stored at the node
         */
        public E getElement() { return element; }

        public boolean getOcc() { return occupied; }

        public Player getOccupant() { return occupant; }

        /**
         * Returns the node that precedes this one (or null if no such node).
         * @return the preceding node
         */
        public Node<E> getPrev() { return prev; }

        /**
         * Returns the node that follows this one (or null if no such node).
         * @return the following node
         */
        public Node<E> getNext() { return next; }

        // Update methods
        /**
         * Sets the node's previous reference to point to Node n.
         * @param p    the node that should precede this one
         */
        public void setPrev(Node<E> p) { prev = p; }

        /**
         * Sets the node's next reference to point to Node n.
         * @param n    the node that should follow this one
         */
        public void setNext(Node<E> n) { next = n; }

        public void setOcc(boolean t) { occupied = t; }

        public void setOccupied(Player p) { occupant = p; }

        public void removeOccupant() { this. occupant = null; }
    } //----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    /** Sentinel node at the beginning of the list */
    public Node<E> header;                    // header sentinel

    /** Sentinel node at the end of the list */
    public Node<E> trailer;                   // trailer sentinel

    /** Number of elements in the list (not including sentinels) */
    private int size = 0;                      // number of elements in the list

    /** Constructs a new empty list. */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);      // create header
        trailer = new Node<>(null, header, null);   // trailer is preceded by header
        header.setNext(trailer);                    // header is followed by trailer
    }

    // public accessor methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() { return size; }

    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * Returns (but does not remove) the first element of the list.
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();   // first element is beyond header
    }
    //These methods return the nodes named in their headers
    public Node<E> getFirst(){
        return header.getNext();
    }
    public Node<E> getHeader() {return this.header;}
    public Node<E> getTrailer() {return this.trailer;}

    /**
     * Returns (but does not remove) the last element of the list.
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();    // last element is before trailer
    }
    //Returns an element of a node at a given index (starting at header = 0)
    public E getElementAt(int index) {
        if (isEmpty()) return null;
        else {
            Node<E> check = header;
            for(int i = 0; i < index; i++){
                check = check.getNext();
            }
            return check.getElement();
        }
    }
    //Returns the node itself, not just the element, at a given index (header = 0)
    public Node<E> getNodeAt(int index) {
        if (isEmpty()) return null;
        else {
            Node<E> check = header;
            for(int i = 0; i < index; i++){
                check = check.getNext();
            }
            return check;
        }
    }

    // public update methods
    /**
     * Adds an element to the front of the list.
     * @param e   the new element to add
     */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());    // place just after the header
    }

    /**
     * Adds an element to the end of the list.
     * @param e   the new element to add
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);  // place just before the trailer
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
        if (isEmpty()) return null;                  // nothing to remove
        return remove(header.getNext());             // first element is beyond header
    }

    /**
     * Removes and returns the last element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeLast() {
        if (isEmpty()) return null;                  // nothing to remove
        return remove(trailer.getPrev());            // last element is before trailer
    }

    // private update methods
    /**
     * Adds an element to the linked list in between the given nodes.
     * The given predecessor and successor should be neighboring each
     * other prior to the call.
     *
     * @param predecessor   node just before the location where the new element is inserted
     * @param successor     node just after the location where the new element is inserted
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /**
     * Removes the given node from the list and returns its element.
     * @param node    the node to be removed (must not be a sentinel)
     */
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = header.getNext();
        while (walk != trailer) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != trailer)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
    //Depreciated, method was used in early iterations of the project but has been replaced with
    //printBoard method in board class.
    public void printElements() {
        if(this.isEmpty() == true) {System.out.println("List is Empty");}
        else {
            Node head = this.header;
            Node check = head.getNext();
            int elem = 1;
            while (check.getNext() != null) {
                System.out.println("Element " + elem + ":");
                System.out.println(check.getElement());
                check = check.getNext();
                elem++;
            }
        }
    }
} //----------- end of DoublyLinkedList class -----------
