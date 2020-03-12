public class HeroFactory
{
	public GameCharacter createSorceress(String name)
	{
		return new Sorceress();
		
	}//end createSorceress
	
	public GameCharacter createWarrior(String name)
	{
		return new Warrior();
		
	}//end createWarrior
	
	public GameCharacter createThief(String name)
	{
		return new Thief();
		
	}//end createThief
	
	public GameCharacter createCleric(String name)
	{
		return new Cleric();
		
	}//end createCleric
	
	public GameCharacter createRanger(String name)
	{
		return new Ranger();
		
	}//end createRanger
}