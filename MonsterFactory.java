public class MonsterFactory
{
	public GameCharacter createOgre()
	{
		return new Ogre();
		
	}//end createOgre
	
	public GameCharacter createSkeleton()
	{
		return new Skeleton();
		
	}//end createSkeleton
	
	public GameCharacter createGremlin()
	{
		return new Gremlin();
		
	}//end createGremlin
	
	public GameCharacter createMindFlayer()
	{
		return new MindFlayer();
		
	}//end createMindFlayer
	
	public GameCharacter createDrake()
	{
		return new Drake();
		
	}//end createDrake
}