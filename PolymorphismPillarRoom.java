
public class PolymorphismPillarRoom extends Room
{
	public PolymorphismPillarRoom(MonsterFactory monsterFactory, boolean north, boolean south, boolean east,
			boolean west)
	{
		super(monsterFactory, north, south, east, west);
		super.pPillar = true;
	}
}
