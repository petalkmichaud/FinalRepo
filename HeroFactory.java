public class HeroFactory
{
	public GameCharacter createSorceress(String name)
	{
		return new Sorceress(null);
		
	}//end createSorceress
	
	public GameCharacter createWarrior(String name)
	{
		return new Warrior(null);
		
	}//end createWarrior
	
	public GameCharacter createThief(String name)
	{
		return new Thief(null);
		
	}//end createThief
	
	public GameCharacter createCleric(String name)
	{
		return new Cleric(null);
		
	}//end createCleric
	
	public GameCharacter createRanger(String name)
	{
		return new Ranger(null);
		
	}//end createRanger
}