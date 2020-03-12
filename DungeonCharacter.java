
public abstract class DungeonCharacter {
	Attack[] flyweightReference;
	protected Attack attack;
	protected Attack ability;
	protected String name;
	protected int hitPoints;
	protected int attackSpeed;
	protected double chanceToHit;
	protected int damageMin, damageMax;
	
	
	public DungeonCharacter(Attack[] flyweightRef) {
		this.flyweightReference = flyweightRef;
	
	}
	
	
	
	
	public abstract void attack(DungeonCharacter opponent);
	
	public abstract void specialAttack();
	
	public void subtractHitPoints(int hitPoints)
	{
		if (hitPoints <0)
			System.out.println("Hitpoint amount must be positive.");
		else if (hitPoints >0)
		{
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			System.out.println(getName() + " hit " +
								" for <" + hitPoints + "> points damage.");
			System.out.println(getName() + " now has " +
								getHitPoints() + " hit points remaining.");
			System.out.println();
		}//end else if

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");
	}
	public int getHitPoints() {
		return this.hitPoints;
	}
	
	public String getName() {
		return this.name;
	}
}
