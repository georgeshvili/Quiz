package Quiz;

import java.security.MessageDigest;
import java.math.BigInteger;

public class Quiz {

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        int i = 0;

        if(a)
            i++;
        if(b == true)
            i++;
        if(c == true)
            i++;
        if(d == true)
            i++;
        if(i == 2)
            return true;
        return false;
    }

    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value     any number
     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        return  value ^ (1 << (bitIndex - 1));// put your implementation here
    }

    public static boolean doubleExpression(double a, double b, double c) {
        double d = 0.03;
        if(Math.abs(c - d) <= 0.0001)
           return true;
        return false;
    }

    public static char charExpression(int a) {
        a += 92;
        return (char) a;
    }

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        value = Math.abs(value);
        int b = (value & (value-1));
        if(b == 0 && value-1 >= 0)
            return true;
        return false;
        /*легче сделать
        return Integer.bitCount(Math.abs(value)) == 1;
        */
    }

    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        System.out.println(text);
        StringBuilder sText = new StringBuilder(text);
        sText = sText.reverse();
        if(text.equals(sText.toString()))
            return true; // your implementation here
        return false;
    }

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger fact = BigInteger.valueOf(1);
        for(int i = 1; i <= value; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact; // your implementation here
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {

        int[] a3 = new int[a1.length + a2.length];

        for(int i = 0, j = 0, k = 0; k < a3.length; k++){

            if(i > a1.length - 1){
                int a = a2[j];
                a3[k] = a;
                j++;
            } else if(j > a2.length - 1) {
                int a = a1[i];
                a3[k] = a;
                i++;
            } else if(a1[i] < a2[j]){
                int a = a1[i];
                a3[k] = a;
                i++;
            } else {
                int a = a2[j];
                a3[k] = a;
                j++;
            }
        }
        return a3; // your implementation here
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {

        StringBuffer buf = new StringBuffer();
        String result;
        for(int i = 0; i < roles.length; i++){
            buf.append(roles[i]);
            buf.append(":");
            for(int j = 0; j < textLines.length; j++) {
                if (roles[i].equals(textLines[j].substring(0, roles[i].length()))) {
                    buf.append("\n");
                    buf.append(j + 1 + ")");
                    buf.append(textLines[j].substring(roles[i].length() + 1));
                }
            }
            buf.append("\n");
            buf.append("\n");
        }
        result = buf.toString();
        return result;
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;}

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {

        if(toY == 0){
            if(toX > 0){
                robot.turnRight();
                while(toX != robot.getX())
                    robot.stepForward();
            } else if (toX < 0){
                robot.turnLeft();
                while(toX != robot.getX())
                    robot.stepForward();
            }
        }

        if(toX == 0){
            if(toY > 0){
                while(toY != robot.getX())
                    robot.stepForward();
            } else if (toY < 0){
                robot.turnRight();
                robot.turnRight();
                while(toX != robot.getX())
                    robot.stepForward();
            }
        }

        if(toY > 0)
            while(toY != robot.getY())
                robot.stepForward();
        else if (toY < 0) {
            robot.turnRight();
            robot.turnRight();
            while(toY != robot.getY())
                robot.stepForward();
        }

        if((toX > 0 && toY < 0) || (toX < 0 && toY > 0)){
            robot.turnLeft();
            while(toX != robot.getX())
                robot.stepForward();
        } else if ((toX < 0 && toY < 0) || (toX > 0 && toY > 0)) {
            robot.turnRight();
            while (toX != robot.getX())
                robot.stepForward();
        }
    }

    public static void main(String[] args) throws Exception {
        /*MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest("abracadabra".getBytes("UTF-8"));
        for (byte b : digest) {
            System.out.printf("%02x", b);
        }*/
        ComplexNumber firstNumber = new ComplexNumber(1,2);
        ComplexNumber secondNumber = new ComplexNumber(1,2);
        System.out.println(firstNumber.equals(secondNumber));
        System.out.println(firstNumber.hashCode());
        System.out.println(secondNumber.hashCode());
        Robot robot = new Robot(0,0,Direction.UP);
        moveRobot(robot, 11 , -22);
        System.out.println(robot.getX());
        System.out.println(robot.getY());
        /*boolean answer = booleanExpression(true,true,false,false);
        System.out.println(answer);
        System.out.println(charExpression(21));
        isPalindrome("Madam, I'm Adam!");
        System.out.println("FACTORIAL= "+factorial(1000));
        int[] a1 = {0,2,2};
        int[] a2 = {0,2,2};
        int[] a3 = mergeArrays(a1,a2);
        for(int i = 0; i < a3.length; i++)
            System.out.println(a3[i]);
        String[] roles = {"Городничий","Аммос Федорович","Артемий Филиппович","Лука Лукич"};
        String[] mas = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles, mas));*/
    }
}
