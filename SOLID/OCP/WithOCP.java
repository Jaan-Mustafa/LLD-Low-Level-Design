
import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart {

    private List<Product> products = new ArrayList<>();

    void addProduct(Product p) {
        products.add(p);
    }

    List<Product> getProducts() {
        return products;
    }

    double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }

}

class ShoppingCartPrinter {
    private ShoppingCart cart;

    ShoppingCartPrinter(ShoppingCart cart) {
        this.cart = cart;
    }

    void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}

interface  Persistance {
    void save(ShoppingCart cart) ; 
}

class SQLPersistance implements  Persistance {
    @Override 
    public void save(ShoppingCart cart){
        System.out.println("Saving shopping cart to sql DB ..");
    }
}

class MongoPersistence implements Persistance {
    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saving shopping cart to MongoDB...");
    }
}

class FilePersistence implements Persistance {
    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saving shopping cart to a file...");
    }
}


public class WithOCP {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 50000));

        cart.addProduct(new Product("Mouse", 2000));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();
        // db is refernce of type Persistance but the actual object is of SQLPeristance 
        Persistance db = new SQLPersistance() ; 
        Persistance mongo = new MongoPersistence() ; 
        Persistance file = new FilePersistence() ; 

        db.save(cart) ; 
        mongo.save(cart) ; 
        file.save(cart) ; 

    }
}
