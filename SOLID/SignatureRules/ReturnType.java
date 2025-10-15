// covariant return types 
// The Rule:Covariant Return Types The rule is that the return type in an overridden method can be either the exact same type or a subtype(narrower type)of the original return type.
class Organism {

}
class Animal  extends Organism{

    // some animal mehtods
}

class Dog extends Animal {
    // additional dog method specific to dogs 
}


class  Parent {
    public Animal getAnimal(){
        System.out.println("Parent : Returning Animal instance ");
        return new Animal() ; 

    }
}

class Child extends Parent {
    @Override 
    public Animal getAnimal(){
        System.out.println("Child : returning dog instance");
        return new Organism() ; 
    }
}

class Client {
    private Parent p ; 
    public Client(Parent p ){
        this.p= p ; 
    }

    public void takeAnimal(){
        p.getAnimal() ; 
    }
}

public class ReturnType {

    public static void main(String[] args) {

         Parent parent  = new Parent() ; 
         Child child= new Child() ; 

         Client client= new Client(child) ; 
         client.takeAnimal();
        
    }}



    

