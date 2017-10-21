package decorator;

public class BasicComputer implements Computer {
    private int ram = 256;
    private int rom = 4;
	@Override
	public String getParts() {   
		return "RAM = "+ ram +"MB, ROM = "+rom;
	}
	@Override
	public int getCost() {
		return 200; 
	}
}
