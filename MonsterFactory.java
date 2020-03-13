public class MonsterFactory
{
	public GameCharacter createOgre()
	{
		return new Ogre(null);
		
	}//end createOgre
	
	public GameCharacter createSkeleton()
	{
		return new Skeleton(null);
		
	}//end createSkeleton
	
	public GameCharacter createGremlin()
	{
		return new Gremlin(null);
		
	}//end createGremlin
	
	public GameCharacter createMindFlayer()
	{
		return new MindFlayer(null);
		
	}//end createMindFlayer
	
	public GameCharacter createDrake()
	{
		return new Drake(null);
		
	}//end createDrake
}