import java.util.HashMap;
import java.util.Map;

public class InterviewQuestions {

    //Determine if two arrays have an item in common
    public boolean hasItemInCommon(int[] array1, int[] array2){
        Map<Integer, Boolean> map = new HashMap<>();

        for(int i : array1){
            map.put(i,true);
        }

        for(int j : array2){
            if(map.get(j) != null){
                return true;
            }
        }
        return false;
    }
}
