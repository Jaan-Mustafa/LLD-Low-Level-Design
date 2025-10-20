
public class ThreadSafeSingleton {

    // ab isko lock lagana he 

    private static ThreadSafeSingleton instance = null;

    private ThreadSafeSingleton() {
        System.out.println("Singleton Constructor called : ");

    }

    public static ThreadSafeSingleton getInstance() {

        synchronized (ThreadSafeSingleton.class) {
            if (instance == null) {
                instance = new ThreadSafeSingleton();
            }

            return instance;
            
        }

      
    }

    public static void main(String[] args) {

        ThreadSafeSingleton s1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton s2 = ThreadSafeSingleton.getInstance();

        System.out.println(s1 == s2);

    }

}
