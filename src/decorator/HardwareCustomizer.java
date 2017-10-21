package decorator;

public abstract class HardwareCustomizer implements Computer 
{
	protected Computer tempComp;
	protected int levelup = 1;
	public HardwareCustomizer(Computer newComp)
	{
        tempComp = newComp;
	}
	public String getParts()
	{
		return tempComp.getParts();
	}
	public int getCost()
	{
		return tempComp.getCost();
	}
}

