


public class ThreadSafeEager {

    // agar ham ek instance pehle se hi bana de


    private static ThreadSafeEager instance= new ThreadSafeEager();

    private ThreadSafeEager(){
        System.out.println("This is printable ");
    }

    public static ThreadSafeEager getInstance(){
        return instance ; 
    }




    public static void main(String[] args) {

        // jab bhi koi instance banayenge to jo ek he wahi banega

        ThreadSafeEager s1= ThreadSafeEager.getInstance() ; 
        ThreadSafeEager s2= ThreadSafeEager.getInstance() ; 
        System.out.println(s1==s2);
        
    }
    
}
