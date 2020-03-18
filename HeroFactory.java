public class HeroFactory extends CharacterFactory
{
	public HeroFactory(Ability[] flyweightRef)
	{
		super(flyweightRef);
		
	}//end HeroFactory
	
	public GameCharacter createSorceress()
	{
		return new Sorceress(this.flyweightRef);
		
	}//end createSorceress
	
	public GameCharacter createWarrior()
	{
		return new Warrior(this.flyweightRef);
		
	}//end createWarrior
	
	public GameCharacter createThief()
	{
		return new Thief(this.flyweightRef);
		
	}//end createThief
	
	public GameCharacter createCleric()
	{
		return new Cleric(this.flyweightRef);
		
	}//end createCleric
	
	public GameCharacter createRanger()
	{
		return new Ranger(this.flyweightRef);
		
	}//end createRanger
	
}//end class
