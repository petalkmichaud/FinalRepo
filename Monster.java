public abstract class Monster extends GameCharacter //implements Ability
{
	private double chanceToHeal;
	public double getChanceToHeal() {
		return chanceToHeal;
	}

	public void setChanceToHeal(double chanceToHeal) {
		this.chanceToHeal = chanceToHeal;
	}

	public int getMinHeal() {
		return minHeal;
	}

	public void setMinHeal(int minHeal) {
		this.minHeal = minHeal;
	}

	public int getMaxHeal() {
		return maxHeal;
	}

	public void setMaxHeal(int maxHeal) {
		this.maxHeal = maxHeal;
	}

	
	private int minHeal, maxHeal;

	public Monster(Ability[] flyweightRef, String name, int hitPoints, int attackSpeed,
				     double chanceToHit, double chanceToHeal,
					 int damageMin, int damageMax,
					 int minHeal, int maxHeal)
	{
		super(flyweightRef, name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToHeal = chanceToHeal;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;
		this.setAbility(flyweightRef[2]);

	}//end Monster
	
	public void specialAttack(GameCharacter thisMonster)
	{
		if(this.isAlive()) {
		System.out.print(this.getName());
		this.getAbility().doAbility((Monster)thisMonster);
		}
	}//end specialAttack

		
	/* public void heal()
  	{
		boolean canHeal;
		int healPoints;

		canHeal = (Math.random() <= chanceToHeal) && (super.getHitPoints() > 0);

		if (canHeal)
		{
			healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
			addHitPoints(healPoints);
			System.out.println(super.getName() + " healed itself for " + healPoints + " points.\n"
							+ "Total hit points remaining are: " + super.getHitPoints());
			System.out.println();
		}//end can heal

  	}//end heal method
	
	public void attack(GameCharacter opponent)
	{
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= super.getChanceToHit();

		if (canAttack)
		{
			damage = (int)(Math.random() * (super.getDamageMax() - super.getDamageMin() + 1))
						+ super.getDamageMin() ;
			opponent.subtractHitPoints(damage);



			System.out.println();
		}//end if can attack
		else
		{

			System.out.println(getName() + "'s attack on " + opponent.getName() +
								" failed!");
			System.out.println();
		}//end else

	}//end attack method */
	  
	public void subtractHitPoints(int hitPoints)
	{
		super.subtractHitPoints(hitPoints);
		specialAttack(this);
	
	}//end method

}//end Monster class