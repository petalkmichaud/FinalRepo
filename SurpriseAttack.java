
public class SurpriseAttack implements Ability
{
	public String getDisplay()
	{
		return null;
	}
	
	public void doAbility(GameCharacter opponent) 
	{
		//Method does not work, how to change to work with our structure?
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								name + " gets an additional turn.");
			numTurns++;
			attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    attack(opponent);
	}

}
