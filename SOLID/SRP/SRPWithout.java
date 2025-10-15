
import java.util.ArrayList;
import java.util.List;




class Product {
    public String name ; 
    public double price ; 
    public Product(String name , double price){
        this.name= name ; 
        this.price= price ; 
    }
}

// violating srp ; shopping cart is handling multiple responsibllites 

class shoppingCart{
     // list is interface and Product is wrapper class
     // 
  private List<Product>  products= new ArrayList<>() ; 

  public void addProduct(Product p ){
    products.add(p) ; 
  }

  public List<Product> getProducts(){
    return products ; 
  }

  // calculate total price in cart 

  public double calculateTotal(){

    double total =0 ; 
    for( Product p : products){
        total+=p.price ; 
    }
    return total ; 
  }

  // 2 . violating srp - prints invoice 
  public void printInvoice(){
    System.out.println("Shopping cart invoice : ");
    for( Product p : products){
        System.out.println(p.name + " - Rs "+ p.price);
    }
    System.out.println("Total Rs : " + calculateTotal());
  }
  

  // 3 Violating SRP - Saves to DB (should be in a separate class )

  public void saveToDatabase(){
    System.out.println("Saving shopping cart to database ...");
  }


}

public class SRPWithout {

    public static void main(String[] args) {
          
        shoppingCart cart = new shoppingCart() ; 
        // creating new instance of product 

        Product Laptop = new Product("Acer Aspire", 60000) ;    
        Product TV = new Product("Lenove", 900000) ; 
        cart.addProduct(Laptop);
        cart.addProduct(TV);
        cart.printInvoice();
    }}
    

