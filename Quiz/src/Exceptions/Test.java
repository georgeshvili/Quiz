package Exceptions;

//import static Exceptions.NegativeSqrtException.sqrt;

public class Test {

    public static void main(String[] args){
        //B b = new B();
        //FindException a = (FindException) b;
        NegativeSqrtException n = new NegativeSqrtException();
        double y = 2.0;
        double x = n.sqrt(y);
        System.out.println(x);

        getCallerClassAndMethodName m = new getCallerClassAndMethodName();
        System.out.println(m.getCallerClassAndMethodName());
        m.m1();

    }

}
