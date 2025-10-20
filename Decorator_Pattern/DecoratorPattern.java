// component interface for all common interface for mario and all power up 
interface Character {
    String getAbilities();
}


class Mario implements  Character{
    public String getAbilities(){
        return "Mario";
    }
}

// Abstract Decorator : Character Decorator "is-a " Character and "has-a" Character 

abstract class CharacterDecorator implements  Character {
    protected  Character character ; // wrapped componnent 
    // is-a relationship 

    public CharacterDecorator(Character c){
        this.character=c ; 
    }
}


// Concreate Decorator : Height - Increasing Power-Up 

class HeightUp extends CharacterDecorator {
    public HeightUp(Character c){
        super(c) ; 
        // this will call parents constructure 
    }

    public String getAbilities(){
        return character.getAbilities()+" with HeightUp ";
    }
}


// concrate Decorator : Gun Shooting Power-up 

class GunPowerUp extends CharacterDecorator {
    public GunPowerUp(Character c){
        super(c) ; 
    }

    public String getAbilities(){
        return character.getAbilities()+"with Gun "; 
    }
}

class StarPowerUp extends CharacterDecorator {
    public StarPowerUp(Character c){
        super(c) ; 
    }

    public String getAbilities() {
        return character.getAbilities() + " with Star Power (Limited Time)";
    }

}



public class DecoratorPattern{


    public static void main(String[] args) {
        
        // crate a basic Mario character : 
        Character  mario = new Mario();
        System.out.println("Basic Character : " + mario.getAbilities());

        // Decorate Mario with a HeightUp power-up . 

        mario= new HeightUp(mario) ; 
        System.out.println("After HeightUp: " + mario.getAbilities());
     }


}