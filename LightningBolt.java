
public class LightningBolt implements Ability
{
	private int damage = 95;
	private double chanceToHit = .45;
	
	public String getDisplay()
	{
		return " uses the special move lightning bolt";
	}

	public void doAbility(GameCharacter opponent)
	{
		if(Math.random() >= chanceToHit)
		{
			System.out.println("has used lightning bolt on " + opponent.getName());
			opponent.subtractHitPoints(damage);
		}
		else
		{
			System.out.println(" MISSED lightning bolt...");
		}
	}
}
