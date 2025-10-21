

class PowerSupply {
    public void providePower(){
        System.out.println("Power supply : Providing power ...");
    }
}


class CoolingSystem {
    public void startFans(){
        System.out.println("Cooling System: Fans started...");
    }
}


class CPU {
    public void initialize() {
        System.out.println("CPU: Initialization started...");
    }
}

class Memory {
    public void selfTest() {
        System.out.println("Memory: Self-test passed...");
    }
}

class HardDrive {
    public void spinUp() {
        System.out.println("Hard Drive: Spinning up...");
    }
}

class BIOS {
    public void boot(CPU cpu, Memory memory) {
        System.out.println("BIOS: Booting CPU and Memory checks...");
        cpu.initialize();
        memory.selfTest();
    }
}

class OperatingSystem {
    public void load() {
        System.out.println("Operating System: Loading into memory...");
    }
}


class ComputerFacade{

  // Isi me ham sabkuch mention kar rakhe he ...
  private PowerSupply  powerSupply = new PowerSupply() ; 
  private CoolingSystem coolingSystem= new CoolingSystem() ; 
  private CPU cpu = new CPU() ; 
  private Memory memory = new Memory() ; 
  private HardDrive hardDrive = new HardDrive() ; 
  private BIOS bios= new BIOS() ; 
  private OperatingSystem os= new OperatingSystem() ; 


  public void startComputer(){
    System.out.println("------o wo o wo o o o wo o wo o ..computer started   .... ");

    powerSupply.providePower();
    coolingSystem.startFans();
    bios.boot(cpu, memory);
    os.load();
    System.out.println("Computer booted successfully ! ");
  }

}

// Client 

public class FacadeDesign{

    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade() ; 
        computer.startComputer();
        
    }




}