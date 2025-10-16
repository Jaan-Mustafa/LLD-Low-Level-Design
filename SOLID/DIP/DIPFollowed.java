

interface Persistance {
  public void save(String data ) ; 
}
class MySQLDatabase  implements Persistance{ // Low-level module
    public void save(String data) {
        System.out.println(
                "Executing SQL Query: INSERT INTO users VALUES('"
                        + data + "');");
    }
}

class MongoDBDatabase implements Persistance { // Low-level module
    public void save(String data) {
        System.out.println(
                "Executing MongoDB Function: db.users.insert({name: '"
                        + data + "'})");
    }
}

class UserService {
    // high level module , business logic .

    private final Persistance db ; 

    public UserService(Persistance p ){
        this.db= p ; 
    }
     public void storeUser(String user){
        db.save(user);
     }
   


}

// dependency inversion principal
public class DIPFollowed {
    public static void main(String[] args) {
        MySQLDatabase sqlDb= new MySQLDatabase() ; 
        MongoDBDatabase mongoDb= new MongoDBDatabase() ; 

        UserService service = new UserService(mongoDb) ;
        service.storeUser("Rizabul is greatest");
         
      
    }


    
}