package Exceptions;

public class getCallerClassAndMethodName {

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if(stackTraceElements.length > 3) {
            StackTraceElement element = stackTraceElements[3];
            String className = element.getClassName();
            String methodName = element.getMethodName();
            return className+"#"+methodName;
        } else
            return null;
    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }

}
