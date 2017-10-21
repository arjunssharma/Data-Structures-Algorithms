package decorator;

public class Laptop extends HardwareCustomizer  {
	private int ssd = 128;
	private int ssdCost = 80;
	public Laptop (Computer newComp) {
		super(newComp); 
		this.upgrade();
	}
	public String getParts() {
		return tempComp.getParts() + ", Solid State Drive = "+ssd*levelup +"GB";
	}
	@Override
	public int getCost() {
		return tempComp.getCost() + ssdCost*levelup;
	}
    private void upgrade(){
    	this.levelup = 4;
    }
}
