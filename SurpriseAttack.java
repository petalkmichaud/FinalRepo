
public class SurpriseAttack implements Ability
{
	GameCharacter thisChar;
	
	
	
	public String getDisplay()
	{
		return null;
	}
	
	public void doAbility(GameCharacter opponent) 
	{
		
		//Method does not work, how to change to work with our structure?
		double surprise = Math.random();
		if (surprise <= thisChar.getChanceToHit())
		{
			
			System.out.println("Surprise attack was successful!\n" +
								thisChar.getName()+ " gets an additional turn.");
			thisChar.attack(opponent);
			
			//Pick battle option
			
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		
		thisChar.attack(opponent);
	}
	public void setThisChar(GameCharacter thisChar) {
		this.thisChar = thisChar;
	}

}
