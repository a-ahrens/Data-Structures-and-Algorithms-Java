public class Main {
    public static void main(String[] args) {
        System.out.println("Starting List: ");
        LinkedList newList = new LinkedList(1);
        newList.printList();

        System.out.println("Append to end: ");
        newList.append(2);
        newList.printList();

        System.out.println("Prepend to front: ");
        newList.prepend(0);
        newList.printList();

        System.out.println("Insert at 0 (Prepend)");
        System.out.println(newList.insert(0, 11));
        System.out.println("length: " + newList.getLength());
        newList.printList();

        System.out.println("Insert at end, (append)");
        System.out.println(newList.insert(4, 22));
        newList.printList();

        System.out.println("Insert at 2");
        System.out.println(newList.insert(2, 33));
        newList.printList();

        System.out.println("Insert at 11");
        System.out.println(newList.insert(12, 15));
        newList.printList();

        System.out.println("Remove at 2");
        System.out.println(newList.remove(2));
        newList.printList();

        System.out.println("Remove first");
        System.out.println(newList.remove(0));
        newList.printList();

        System.out.println("Remove Last");
        System.out.println(newList.remove((newList.getLength()-1)));
        newList.printList();

        System.out.println("Reverse the list");
        newList.reverse();
        newList.printList();

    }
}
