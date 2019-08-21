package HackerRank;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b){

        List<Integer> result = new LinkedList<>();
        int first, second;
        first = second = 0;

        for(int i = 0; i < a.size(); i++){
            if(a.get(i) > b.get(i))
                first++;
            else if(a.get(i) < b.get(i))
                second++;
        }

        result.add(first);
        result.add(second);

        return result;

    }

}
