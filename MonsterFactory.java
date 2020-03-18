public class MonsterFactory extends CharacterFactory
{
	public MonsterFactory ( Ability [] flyweightRef)
	{
		super(flyweightRef);
		
	}//end MonsterFactory
	
	public GameCharacter createOgre()
	{
		return new Ogre(this.flyweightRef);
		
	}//end createOgre
	
	public GameCharacter createSkeleton()
	{
		return new Skeleton(this.flyweightRef);
		
	}//end createSkeleton
	
	public GameCharacter createGremlin()
	{
		return new Gremlin(this.flyweightRef);
		
	}//end createGremlin
	
	public GameCharacter createMindFlayer()
	{
		return new MindFlayer(this.flyweightRef);
		
	}//end createMindFlayer
	
	public GameCharacter createDrake()
	{
		return new Drake(this.flyweightRef);
		
	}//end createDrake
	
}//end class
