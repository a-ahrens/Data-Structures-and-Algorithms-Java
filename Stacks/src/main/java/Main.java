public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack(4);

        myStack.getTop();
        myStack.getHeight();
        myStack.printStack();
        System.out.println();

        myStack.push(6);
        myStack.getTop();
        myStack.getHeight();

        myStack.printStack();
        System.out.println();


        myStack.pop();
        myStack.getTop();
        myStack.getHeight();


    }
}
