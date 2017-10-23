package Framework;

import Service.Level;

import java.lang.reflect.Method;

/**
 * Class provides static method for logging methods invocation of other objects
 * by using reflection
 */
public class Logger {
    /**
     * Log method invokation by using reflection
     *
     * @param message String message passed by invoked method
     */
    public static void logger(String message) {
        String methodName;
        String className;
        Class<?> theClass = null;
        Method invokedMethod = null;
        //getting class name and method name of object
        // from which method logger was invoked
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] stake = e.getStackTrace();
            methodName = stake[1].getMethodName();
            className = stake[1].getClassName();
        }
        try {
            theClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods = theClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                invokedMethod = method;
            }
        }
        //Analyzing level of logging of class from which method was invoked.
        //Depending on a value passed to Level annotation's enum parameter
        //"level" there must be different responce to annotation presence in
        //methods of that class
        Level ann = (Level) theClass.getAnnotation(Level.class);
        switch (ann.level()) {
            case INFO:
                if (invokedMethod.isAnnotationPresent(Info.class)) {
                    System.out.println("Method " + invokedMethod.getName() +
                            " was invoked/n" + message);
                }
            case DEBUG:
                if (invokedMethod.isAnnotationPresent(Error.class)
                        || invokedMethod.isAnnotationPresent(Info.class)
                        || invokedMethod.isAnnotationPresent(Debug.class)) {
                    System.out.println("Method " + invokedMethod.getName() +
                            " was invoked/n" + message);
                }
                break;
            case ERROR:
                if (invokedMethod.isAnnotationPresent(Error.class)
                        || invokedMethod.isAnnotationPresent(Debug.class)) {
                    System.out.println("Method " + invokedMethod.getName() +
                            " was invoked/n" + message);
                }
                break;
            default:
                System.out.println("Method " + invokedMethod.getName() + " was invoked");
        }
    }
}
