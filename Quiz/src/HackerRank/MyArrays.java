package HackerRank;

public class MyArrays {

    public static int sumArray(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
            sum = sum + arr[i];
        return sum;
    }

}
