
public class SteadyShot implements Ability
{
	private int damage = 85;
	private double chanceToHit = .8;
	
	public String getDisplay()
	{
		return " uses the special move steady shot";
	}

	public void doAbility(GameCharacter opponent)
	{
		if(Math.random() >= chanceToHit)
		{
			System.out.println("has used steady shot on " + opponent.getName());
			opponent.subtractHitPoints(damage);
		}
		else
		{
			System.out.println(" MISSED steady shot...");
		}
	}
}
