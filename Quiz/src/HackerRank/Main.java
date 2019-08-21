package HackerRank;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] arr = new int[] {1, 2, 3};
        System.out.println(MyArrays.sumArray(arr));

        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();
        a.add(17); a.add(28); a.add(30);
        b.add(99); b.add(16); b.add(8);
        System.out.println(MyLinkedList.compareTriplets(a, b));


    }

}
