
public class InheritancePillarRoom extends Room
{
	public boolean hasBeenFound = true;
	public InheritancePillarRoom(MonsterFactory monsterFactory, boolean north, boolean south, boolean east,
			boolean west)
	{
		super(monsterFactory, north, south, east, west);
		
	}
	
	public boolean getPillar()
	{
		return this.hasBeenFound;
		
	}//end getPillar
}
