package decorator;

public class ComputerFabricator {

	public static void main(String[] args){
		Computer customizedPC = new GamingComputer(new Laptop(new BasicComputer()));
		System.out.println("Parts : "+customizedPC.getParts());
		System.out.println("Cost ="+customizedPC.getCost());
	}
}

