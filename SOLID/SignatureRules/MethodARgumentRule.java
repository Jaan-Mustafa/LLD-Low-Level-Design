


class  Parent {
      
    public void print(String msg){
        System.out.println("Parent : " + msg );
    }

} 

class Child extends  Parent {
    @Override 
    public void print(String msg){
        System.out.println("Child : " + msg );
    }
}

class Client {

    private Parent p ; 
    // p is private 
    public Client(Parent p ){
        this.p= p ; 
    }

    public void printMsg(){
        p.print("Hello HI this is rizabul ");
    }
}

public class MethodARgumentRule {
    public static void main(String[] args){
        Parent parent = new Parent() ; 
        Parent child = new Child()  ; 

        // Client client = new Client(parent) ; 
        Client client = new Client(child);

        client.printMsg();

    }
}

// the declared

// type (Parent) defines what methods you can call, but the actual

// object type (Child) determines whose implementation runs. You use the Child's override because you want the specialized behavior.

// so we can call only htose mehtods which are defined in the parent , but implementations will be implemented by those of child  . 
// 