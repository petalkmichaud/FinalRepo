
public class SurpriseAttack implements Ability
{
	GameCharacter thisChar;
	
	public String getDisplay()
	{
		return " uses the special move surprise attack";
	}
	
	public void doAbility(GameCharacter opponent) 
	{
		double surprise = Math.random();
		if (surprise <= thisChar.getChanceToHit())
		{
			System.out.println("Surprise attack was successful!\n" +
								thisChar.getName() + " gets an additional turn.");
			//numTurns++;
			thisChar.attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    thisChar.attack(opponent);
	}

}
