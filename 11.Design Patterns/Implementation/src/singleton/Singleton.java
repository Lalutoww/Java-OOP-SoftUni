package singleton;

public class Singleton {
    //The instance of the class that will be accessed from other classes
    //The volatile keyword is used to indicate that a variable's value will be modified by different threads.
    private static volatile Singleton instance;

    //Private constructor so other classes wouldn't be able to create new instances
    private Singleton() {
    }

    //Method which allows the class to access the instance
    public static Singleton getInstance() {
        //Only create a new instance if it is the first time invoking the method
        if (instance == null) {
            //Makes sure only one thread is accessing the instance at a time (ensures that only one instance is created)
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
