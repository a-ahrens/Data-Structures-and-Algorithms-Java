public class Main {
    public static void main(String[] args){

        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(2);
        myDLL.prepend(3);
        myDLL.insert(11,2);
        myDLL.printList();

        System.out.println("Get node at 0: " + myDLL.get(0).value);
        System.out.println("Get node at 1: " + myDLL.get(1).value);

    }
}
