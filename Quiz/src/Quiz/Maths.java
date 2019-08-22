package Quiz;

public class Maths {

    public static int rand(int begin, int end){
        return begin + (int) (Math.random() * end);
    }

    public static boolean findSimple(int number) {

        if(number == 1)
            return false;
        for(int i = 2; i*i < number; i++){
            System.out.println(i*i);
            System.out.println(number / i);
            if(number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(findSimple(24));
        System.out.println(rand(0,3));
        System.out.println(rand(0,3));
        System.out.println(rand(0,3));
        System.out.println(rand(0,3));
        System.out.println(rand(0,3));
    }

}
