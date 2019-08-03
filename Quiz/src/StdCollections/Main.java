package StdCollections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0 ; scanner.hasNextInt(); i++){
            if(i % 2 != 0)
                deque.addFirst(scanner.nextInt());
            else
                scanner.nextInt();
        }

        for(int i : deque)
            System.out.print(i + " ");
    }
}
