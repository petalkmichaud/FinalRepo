public class HeroFactory{
	private Ability[] flyweightRef;
	public HeroFactory(Ability[] flyweightRef) {
		this.flyweightRef = flyweightRef;
		
	}
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
}