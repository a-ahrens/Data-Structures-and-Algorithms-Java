public class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable();

        ht.set("nails", 100);
        ht.set("tile", 50);
        ht.set("lumber", 80);
        ht.set("bolts", 50);
        ht.set("screws", 80);

        ht.set("screws", 2000);

        ht.printTable();

        System.out.println("Lumber: " + ht.get("lumber"));
        System.out.println("Bolts: " + ht.get("bolts"));

        System.out.println("All keys: " + ht.keys());
    }
}
