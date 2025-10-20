
public class ThreadDoubleLock {

    // ab isko lock lagana he

    private static ThreadDoubleLock instance = null;

    private ThreadDoubleLock() {
        System.out.println("Singleton Constructor called : ");

    }

    public static ThreadDoubleLock getInstance() {
        if(instance==null){

        synchronized (ThreadDoubleLock.class) {
            if(instance==null){

                instance = new ThreadDoubleLock();
            }


        }


        }

            return instance;

    }

    public static void main(String[] args) {

        ThreadDoubleLock s1 = ThreadDoubleLock.getInstance();
        ThreadDoubleLock s2 = ThreadDoubleLock.getInstance();

        System.out.println(s1 == s2);

    }

}
