
public class AbstractionPillarRoom extends Room
{
	public AbstractionPillarRoom(MonsterFactory monsterFactory, boolean north, boolean south, boolean east,
			boolean west)
	{
		super(monsterFactory, north, south, east, west);
		super.aPillar = true;
		
	}
	

}
