public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }


    }

    //create a new LinkedList and initialize length to 1 node
    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public LinkedList(){
        length = 0;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    //create a new node and add to the end of the linked list
    public void append(int value){
        Node newNode = new Node(value);

    //check if the linkedlist is empty.
        // If yes, then both head and tail point to new node
        //If no, then change the linkedlist's tail node's next value is assigned to point at newNode, then tail is assigned newNode
        if(length == 0){
            head = newNode;
        }
        else {
            tail.next = newNode;    //
        }
        tail = newNode;
        length++;
    }

    //create a new node and add to the front of the linked list
    public void prepend(int value){
        Node newNode = new Node(value);

    //check if list is empty
        //if yes, then head and tail are assigned newNode
        //else, assign the newNode.next to current head, then reassign head to newNode
        if(length == 0){
            head = newNode;
            tail = newNode;
        } else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    //remove first item from linkedlist
    public Node removeFirst(){
        //check if the linked list is empty
        if(length == 0){
            return null;
        }

        Node temp = head;       //marks the location of the current head
        head = head.next;       //moves the head to the next node
        temp.next = null;       //detaches the previous head from the list. must do this after head is moved to the next node
        length--;

        //check to see if list is now empty after decrementing
        if (length == 0){
            tail = null;
        }

        return temp;
    }

    //remove item from the end of the linked list
    public Node removeLast(){
        //check if the linkedlist is empty
        if(length == 0){
            return null;
        }

        Node pre = head;    //indicates the previous node's position with respect to the target. Determines where the new tail will be
        Node temp = head;   //used to temp examine each item. Once the end is found, temp holds the node and breaks the loop.

        while(temp.next != null){       //index through each item until you get to the end, using temp and pre as sliding markers
            pre = temp;
            temp = temp.next;
        }

        tail = pre;         //pre becomes the new tail
        tail.next = null;   //tail node's next is reassigned to null
        length--;

        //check if linkedlist is now empty
        if(length == 0){
            head = null;
            tail = null;
        }

        return temp;
    }

    //get node at specific index
    public Node get(int index){

        //Index can't be negative, or greater than length. Length of zero is caught here as well
        if(index < 0 || index >= length){
            return null;
        }

        Node temp = head;
        for(int i = 0; i < index; i++){         //iterate through each node, stepping down into the next node until index is found
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);

        if(temp == null){
            return false;
        }
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > length){
            return false;
        }

        if(index == 0){
            prepend(value);
            return true;
        }

        if(index == length){
            append(value);
            return true;
        }

        Node newNode = new Node(value);         //create a new node with the value
        Node temp = get(index - 1);             //
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= length){
            return null;
        }

        if(index == 0){
            return removeFirst();
        }

        if(index == length - 1){
            return removeLast();
        }

        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    public void reverse(){
    /* 1. reverse head and tail
        temp functions as a temporary placeholder for the head node.
            This allows head to shift focus to the tail node.
            Tail node can then shift back to the temp node.
     */
        Node temp = head;
        head = tail;
        tail = temp;

    /* 2. Setup before and after markers with relation to the current temp marker
        Temp is currently pointed at the left most node (old head location)
        the left side of temp is nothing, so before marker should be null
        the right side of temp, after, is the next node in the list

     */
        Node after = temp.next;
        Node before = null;

    /* 3. Iterate through the entire list,
        - The before-temp-after setup will slide down the list, flipping the next values as it goes along
            1. Shift AFTER marker to next node after temp marker
            2. Assign current temp node's next value equal to the before marker
            3. Shift BEFORE marker to current temp position
            4. Shift temp marker to AFTER position
            5. Repeat process until end of list is reached

     */
        for(int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    //SYSTEM FUNCTIONS
    public void printList(){
        if(length == 0){
            System.out.println("Null");
        }

        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + ", ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Interview Question - Insertion Sort of LL
        Write an insertionSort method that sorts a singly linked list in ascending order using the insertion sort algorithm.
        The method should take no arguments
    */

    public void insertionSort(){
        Node sortedHead = head;                     //take the first item in the list to begin sorting
        Node unsortedHead = head.next;              //this marker points at the remaining numbers that haven't been sorted yet
        sortedHead.next = null;                     //breaks the first item away from the unsorted List

        /* we are going to iterate through the unsorted list, and perform the following steps
           - mark the current node to be checked in the unsorted list
           - move the unsortedHead marker forward one node until there are no more Nodes to check
           - placing the current Node within the sortedList
        */
        while(unsortedHead != null){
            Node current = unsortedHead;
            unsortedHead = unsortedHead.next;

            if(current.value < sortedHead.value){
                current.next = sortedHead;          //current Node is moved to the front of the sorted list
                sortedHead = current;               //current Node is marked as the new head of the sorted list

            } else {

                /* Here, we need to determine where to place the Node within the sortedList
                   - a temp Node marks the position as we iterate through the sortedList
                   - we need to determine one of two things
                     1. is temp located at the end of the list? (in this case, temp.next == null)
                            if so, we will simply add the new Node to the end of the sortedList
                     2. is temp's next node's value < the current node's value?
                            if it is NOT, then we have determined that this location of temp is where we need to put the current node
                            (between temp and temp.next)
                 */

                Node temp = sortedHead;
                while (temp.next != null && current.value > temp.next.value) {
                    temp = temp.next;
                }

                current.next = temp.next;
                temp.next = current;
            }
        }
        //at this point, the list has been sorted, now we need to reassign the LinkedList's head and tail properties

        head = sortedHead;      //head is easy because we already have a marker assigned to it.

        //traverse the list until you hit the end to find the new tail location
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        tail = temp;

    }
}
