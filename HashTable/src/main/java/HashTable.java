import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        private String key;
        private int value;
        private Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for(int i = 0; i < dataMap.length; i++){
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null){
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++){
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;        //the 23 is a random prime number that guarentees more random generated values
                                                                    // by modulous division with the array size, we can always get a hash of 0 to size-1 as a result
        }
        return hash;
    }

    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key, value);
        if(dataMap[index] == null){
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];

            while (true) {
                if (temp.key.equals(key)) {             //if it contains a matching key, then just update the value
                    temp.value = value;
                    break;
                }

                if(temp.next == null){                  //adds new node to the end
                    temp.next = newNode;
                }
                temp = temp.next;
            }
        }
    }

    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];

        while (temp != null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;       //returns 0 if the item you are searching for does not exist within the map
    }

    public List keys(){
        List<String> allKeys = new ArrayList<>();
        for(int i = 0; i < size; i++){
            Node temp = dataMap[i];

            while(temp != null){
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }

        return allKeys;
    }
}
