
public class ExitRoom extends Room
{

	public ExitRoom(boolean north, boolean south, boolean east, boolean west)
	{
		super(null, north, south, east, west);
		this.healingPotionCount = 0;
		this.visionPotionCount = 0;
		this.pit = 0;
		this.exit = 1;
		this.entrance = 0;
	}
	
	public String roomStats()
	{
		return "This is the Exit...";
		
	}//end roomStats

}