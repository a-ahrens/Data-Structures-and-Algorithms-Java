public class BinarySearchTree {
    private Node root;

    class Node{
        int value;
        Node left;
        Node right;

        private Node(int value){
            this.value= value;
        }
    }

    public BinarySearchTree(){}

    public BinarySearchTree(int value){
        Node newNode = new Node(value);
        root = newNode;
    }

    public Node getRoot(){
        return root;
    }

    public boolean insert(int value){
        Node newNode = new Node(value);
        Node temp = root;

        if(temp == null){
            root = newNode;
            return true;
        }

        while(true){
            if (newNode.value == temp.value){
                return false;
            }

            if (newNode.value < temp.value){
                if (temp.left == null){
                    temp.left = newNode;
                    return true;

                }
                temp = temp.left;

            } else {
                if (temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;

        while (temp != null) {
            if (value == temp.value) {
                return true;
            } else if (value < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        return false;
    }

}
