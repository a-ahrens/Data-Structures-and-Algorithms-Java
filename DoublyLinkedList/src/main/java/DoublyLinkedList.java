public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }
    }

    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + " , ");
            temp = temp.next;
        }
        System.out.println();
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

    //add new node to the end of list
    public void append(int value){
        Node newNode = new Node(value);

        if(length == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        length++;
    }

    public Node removeLast(){
        /*check to see if the list is empty prior to doing anything
            return null if so */
        if(length == 0){
            return null;
        }

        Node temp = tail;       //create a marker pointing at current tail

        if(length == 1){
            head = null;
            tail = null;
        } else {
            tail = tail.prev;       //move the tail marker to the previous node
            tail.next = null;       //break the new tail location from the old tail location (currently the temp node)
            temp.prev = null;       //break the temp node from the new tail node
        }

        length--;
        return temp;
    }

    //add a new node to the front of the list
    public void prepend(int value){
        Node newNode = new Node(value);

        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    //remove first node from list
    public Node removeFirst(){

        if(length == 0){
            return null;
        }

        Node temp = head;
        if(length == 1){
            head = null;
            tail = null;

        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;

        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }

        Node temp = head;
        if(index <= length / 2){
            for(int i = 0; i < index; i++ ){
                temp = temp.next;
            }
        } else {
            temp = tail;
            for(int i = length - 1; i > index; i--){
                temp = temp.prev;
            }
        }

        return temp;
    }

    public boolean set(int value, int index){
        Node temp = get(index);
        if(temp == null) {
            return false;
        }

        temp.value = value;
        return true;
    }

    public boolean insert(int value, int index){
        Node newNode = new Node(value);

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

        Node before = get(index - 1);
        Node after = before.next;

        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
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

        Node before = get(index - 1);
        Node temp = before.next;
        Node after = temp.next;

        before.next = after;
        after.prev = before;
        temp.prev = null;
        temp.next = null;
        length--;

        return temp;
    }

}
