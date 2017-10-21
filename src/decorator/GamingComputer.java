package decorator;

public class GamingComputer extends HardwareCustomizer  {
    private int graphics = 2;
    private int graphicsCost = 10;
	public GamingComputer (Computer newComp) 
	{
		super(newComp);
	}
	 @Override
     public String getParts() {
         return tempComp.getParts() + ", Graphics Card= "+graphics +"GB"; //>> 8.Fill in the blank
     }
	@Override
	public int getCost() {
		return tempComp.getCost()*levelup + graphicsCost;
	}
}

