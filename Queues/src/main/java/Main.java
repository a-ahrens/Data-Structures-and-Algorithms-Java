public class Main {

    public static void main(String[] args) {
        Queue myQueue = new Queue(3);

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.printQueue();
        System.out.println();

        myQueue.enqueue(7);

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.printQueue();


        System.out.println(myQueue.dequeue().value);
        System.out.println(myQueue.dequeue().value);
        System.out.println(myQueue.dequeue());



    }
}
