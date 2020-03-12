public abstract class Hero extends GameCharacter implements Ability
{
	private double chanceToBlock;
	private int numTurns;

	public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
  	{
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		//readName();
  	}

  	public boolean defend()
  	{
  		return Math.random() <= chanceToBlock;

  	}//end defend method

  	public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(super.getName() + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}


	}//end method

	/*public void battleChoices(GameCharacter opponent)
	{
	    numTurns = super.getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices*/

}//end Hero class