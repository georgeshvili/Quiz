package CodeWars;

import java.util.Arrays;

public class CodeWarsInts {

    /**
     * checks if b has squared numbers of a
     * @param a any array
     * @param b any array with squared numbers
     * @return if equals true, else false
     */
    public static boolean compAreSame(int[] a, int[] b) {

        if(a == null || b == null)
            return false;

        if(a.length != b.length)
            return false;

        /*int[] sortA = Arrays.stream(a).map(Math::abs).sorted().toArray();
        int[] sortB = Arrays.stream(b).sorted().toArray();*/

        Arrays.sort(a);
        Arrays.sort(b);

        for(int i = 0; i < a.length; i++){
            if(a[i] * a[i] != b[i])
                return false;
        }
        return true;
    }

    /**
     * Counts number of zeros at the end of factorial
     * @param n any number
     * @return number of zeros at the end of factorial
     */
    public static int factorialZeros(int n) {
        // your beautiful code here
        int count = 0;
        int result;
        int divider = 5;
        while(n > divider) {
            result = n / divider;
            count += result;
            divider *= 5;
        }
        return count;
    }

    /**
     * Finds sum of numbers between two numbers
     * @param a any number
     * @param b any number
     * @return sum of numbers between a and b
     */
    public static int getSumBetween(int a, int b){
        //Good luck!
        //Дурак, лучше бы решил через арифметическую прогрессию
        int sum = 0;
        if(a > b){
            while(a >= b){
                sum += b;
                b++;
            }
        } else if (a < b){
            while(a <= b){
                sum += a;
                a++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 3, 3 , 5};
        int[] b = {9, 1, 1, 9, 25, 1};
        System.out.println(compAreSame(a, b));
        //System.out.println(factorialZeros(100));
        //System.out.println(GetSumBetween(-3, -2));
    }
}
