
import javax.management.RuntimeErrorException;


class GrandParent {

}
class Parent extends  GrandParent {

    public void getValue() throws RuntimeErrorException {
        throw new RuntimeException("Parent error ") ; 
    }
}


class Child extends Parent {
    @Override
    public void getValue() throws ArithmeticException {
        throw new ArithmeticException("Child error ") ; 
    }
}

 // client that invokes the getValue and catches hte parent exception type 
class Client {
    private Parent  p ; 
    public Client(Parent p){
        this.p= p ; 
    }

    public void takeValue(){
        try{
            p.getValue();
        }catch (RuntimeException e){
            System.out.println("Runtime exception occured "+ e.getMessage());

        }
    }

}

// The overriding
// method can throw
// an exception
// that is

// a subtype (narrower) of the exception declared by the superclass method.Superclass MethodSubclass Overridden MethodResultvoid

// process() throws IOExceptionvoid

// process() throws FileNotFoundExceptionValid. FileNotFoundException is a subclass of IOException, so the client's catch (IOException) block will handle it safely.
public class ExceptionRule {

  public static void main(String[] args) {
      Parent parent = new Parent() ; 
      Child child= new Child() ; 
      GrandParent gp= new GrandParent();

      Client client= new Client(gp) ; 
      client.takeValue();

  }
    
}
