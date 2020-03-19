
public class PolymorphismPillarRoom extends Room
{
	private boolean hasBeenFound = false;
	public PolymorphismPillarRoom(MonsterFactory monsterFactory, boolean north, boolean south, boolean east,
			boolean west)
	{
		super(monsterFactory, north, south, east, west);
		
	}
}
