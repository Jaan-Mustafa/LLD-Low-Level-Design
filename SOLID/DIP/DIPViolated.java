
class MySQLDatabase { // Low-level module
    public void saveToSQL(String data) {
        System.out.println(
                "Executing SQL Query: INSERT INTO users VALUES('"
                        + data + "');");
    }
}

class MongoDBDatabase { // Low-level module
    public void saveToMongo(String data) {
        System.out.println(
                "Executing MongoDB Function: db.users.insert({name: '"
                        + data + "'})");
    }
}


class UserService {
    // high level module  , business logic . 
    private final MySQLDatabase sqlDb = new MySQLDatabase() ;
    private final MongoDBDatabase mongoDb= new MongoDBDatabase() ; 
    
    public void storeUserToSQL(String user){
        sqlDb.saveToSQL(user) ; 
    }

    public void storeUserToMongo(String user){
        mongoDb.saveToMongo(user);

    }

}

// dependency inversion principal 
public class DIPViolated {
    public static void main(String[] args) {
        UserService service = new UserService() ; 
        service.storeUserToSQL("Aditya");
        service.storeUserToMongo("Rizabul");
    }


    
}
