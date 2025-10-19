

// It's simple factory , just object creation ham ispe chhod dete he 


interface  Burger {
    void prepare();
}

class BasicBurger implements  Burger{
     @Override
    public void prepare(){
        System.out.println("Preparing Basic burger with bun , patty , and ketchup ! ");
    }
}

class StandardBurger implements  Burger{
    @Override
    public void prepare(){
        System.out.println("preparing standard burger with bun , patty , cheese , and lettuce ! ");
    }

}

class PremiumBurger implements  Burger {
    @Override
    public void prepare(){
        System.out.println(
                "Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");

    }
}


// --- Burger Factory  ---- 

class BurgerFactory{

    public Burger createBurger(String type ){
        if(type.equalsIgnoreCase("basic")){
            return new BasicBurger() ; 
        }else if(type.equalsIgnoreCase("standard")){
            return new StandardBurger() ; 
        }else if(type.equalsIgnoreCase("premium")){
            return new PremiumBurger() ; 
        }else{
            System.out.println("Invalid burger type ! ");
            return null ; 
        }
    }
}

public class SimpleFactory {

    public static void main(String[] args) {

        BurgerFactory bf= new BurgerFactory() ; 
        Burger myBurger= bf.createBurger("basic");
        if(myBurger!=null){
            myBurger.prepare();
        }
    }
    
}
