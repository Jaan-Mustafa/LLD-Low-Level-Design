
// strategy interface for walk 
interface WalkableRobot {
    void walk();

}

// concreate strategies for walk ---
class NormalWalk implements WalkableRobot {
    public void walk() {
        System.out.println("Walking normally ... ");
    }
}

class NoWalk implements WalkableRobot {
    public void walk() {
        System.out.println("Cannot walk ");
    }
}

// Strategy interface for talk

interface TalkableRobot {
    void talk();
}

// concreate Strategies for Talk
class NormalTalk implements TalkableRobot {
    public void talk() {
        System.out.println("Talking normally .. ");
    }
}

class NoTalk implements TalkableRobot {
    public void talk() {
        System.out.println("Cannot talk.");
    }
}

// Strategy for Flyable Robot

interface FlyableRobot {
    void fly();
}

class NormalFly implements FlyableRobot {
    public void fly() {
        System.out.println("Flying normally .. ");
    }
}

class NoFly implements FlyableRobot {
    public void fly() {
        System.out.println("Cannot fly . .. ");
    }
}

// Robot Base Class -----

// in java we can't create objects directly from abstract class .

abstract class Robot {
    protected WalkableRobot walkBehaviour;
    protected TalkableRobot talkBehaviour;
    protected FlyableRobot flyBehaviour;

    // 
    public Robot(WalkableRobot w ,TalkableRobot t , FlyableRobot f){
       
        this.walkBehaviour= w ; 
        this.talkBehaviour= t ; 
        this.flyBehaviour = f ; 
    }

    public void walk(){
        walkBehaviour.walk() ; 

    }

    public void talk(){
        talkBehaviour.talk() ; 
    }

    public void fly(){
        flyBehaviour.fly();
    }

    public abstract void project(); // abstract method for subclass 




}


// concreate robot types ; 

class CompanionRobot extends Robot {
    public CompanionRobot(WalkableRobot w , TalkableRobot t , FlyableRobot f){
        // super key used to call the constructure of parent class 
        super(w , t , f) ; 
    }

    public void project(){
        System.out.println("Displaying friendly companion features ...");
    }
}

class WorkerRobot extends Robot {
    public WorkerRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    public void project() {
        System.out.println("Displaying worker efficiency stats...");
    }
}




public class StrategyDesign {

    public static void main(String[] args) {


        Robot robot1= new CompanionRobot(new NormalWalk(), new NormalTalk(), new NoFly()) ; 

        robot1.walk();
        robot1.talk();
        robot1.fly();
        robot1.project();

        System.out.println("--------------------");

        Robot robot2 = new WorkerRobot(new NoWalk(), new NoTalk(), new NormalFly());
        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.project();


    }

}
