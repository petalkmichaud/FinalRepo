
public class CrushingBlow implements Ability
{
	private int damage = 150;
	private double chanceToHit = .2;
	
	public String getDisplay()
	{
		return " uses the special aattack crushing blow";
	}

	public void doAbility(GameCharacter opponent)
	{
		if(Math.random() >= chanceToHit) {
			System.out.println("has used CRUSHING BLOW on " + opponent.getName());
			opponent.subtractHitPoints(damage);
		}
		else {
			System.out.println(" MISSED crushing blow..");
		}
	}

}
