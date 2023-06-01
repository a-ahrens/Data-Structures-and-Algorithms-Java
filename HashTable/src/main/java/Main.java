import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//Hash Table Tutorial Concepts
//        ht.set("nails", 100);
//        ht.set("tile", 50);
//        ht.set("lumber", 80);
//        ht.set("bolts", 50);
//        ht.set("screws", 80);
//
//        ht.set("screws", 2000);
//
//        ht.printTable();
//
//        System.out.println("Lumber: " + ht.get("lumber"));
//        System.out.println("Bolts: " + ht.get("bolts"));
//
//        System.out.println("All keys: " + ht.keys());
//

/*Common Interview Questions: See Interiew Class for details and coding instructions */
        InterviewQuestions iq = new InterviewQuestions();

    // HT: Do the arrays have an item in Common?

        int[] array1 = {1,3,5};
        int[] array2 = {2,4,5};
        int[] array3 = {7,8,9};
        List<Integer> list = new ArrayList<>();

        System.out.println("Array 1 & Array2: " + iq.hasItemInCommon(array1, array2));
        System.out.println("Array 1 & Array3: " + iq.hasItemInCommon(array1, array3));



    }
}
