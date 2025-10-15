

// 

import java.util.ArrayList;
import java.util.List;

class Product {
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart{

    private List<Product> products = new ArrayList<>() ; 
    
    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getProducts(){
        return products ; 
    }

    public double calculateTotal(){
        double total =0 ; 
        for( Product p : products){
            total+=p.price ; 
        }
        return total ; 
    }
}

class ShoppingCartPrinter{
    private ShoppingCart cart ; 
    // has a relationship ShoppingCartPrinter has a Cart 
    public ShoppingCartPrinter(ShoppingCart cart){
        this.cart= cart ; 
    }

    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}


class ShoppingCartStorage {
    private ShoppingCart cart ; 
    public ShoppingCartStorage(ShoppingCart cart){
        this.cart= cart ; 
    }
    
    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}
public  class SRPWith {


public static void main(String[] args){
    ShoppingCart cart = new ShoppingCart() ; 
    cart.addProduct(new Product("Laptop", 50000));
    cart.addProduct(new Product("Mouse", 2000));

    ShoppingCartPrinter printer= new ShoppingCartPrinter(cart) ; 
    ShoppingCartStorage storage= new ShoppingCartStorage(cart ) ; 
    printer.printInvoice();
    storage.saveToDatabase();
 

}


}