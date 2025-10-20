


interface  Burger {
    void prepare() ; 
}

class BasicBurger implements Burger{
    public void prepare(){
         System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}

class StandardBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumBurger implements Burger {
    public void prepare() {
        System.out.println(
                "Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

class BasicWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger with bun, patty, and ketchup!");
    }
}

class StandardWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Standard Wheat Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumWheatBurger implements Burger {
    public void prepare() {
        System.out.println(
                "Preparing Premium Wheat Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}


interface BurgerFactory{
    Burger createBurger(String type ) ; 
}


class  KingBurgerFactory implements   BurgerFactory {
   public  Burger createBurger(String type){

        if(type.equalsIgnoreCase("basic")){
            return new BasicBurger() ; 
        }else if(type.equalsIgnoreCase("standard")){
            return new StandardBurger();
        }else if(type.equalsIgnoreCase("premium")){
            return new PremiumBurger() ; 
        }else{
            return null ; 
        }
    }
}

class SinghBurgerFactory implements  BurgerFactory{

    public Burger createBurger(String type ){

        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardWheatBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumWheatBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}








public class FactoryMethod {

    public static void main(String[] args) {

        SinghBurgerFactory sbf= new SinghBurgerFactory() ; 
        
        Burger SinghBurger=sbf.createBurger("basic") ; 
        SinghBurger.prepare();

    }
    
}
