import java.util.Scanner;

public abstract class Hero extends GameCharacter// implements Ability
{
	private double chanceToBlock;
	private int numTurns;
	Ability[] flyweightReference;
	private int pillar1 = 0;
	private int pillar2 = 0;
	private int pillar3 = 0;
	private int pillar4 = 0;
	private int healingPotionCount;
	private int visionPostionCount;
	

	public Hero(Ability[] flyweightRef, String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
  	{
		super(flyweightRef, setName(), hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		//readName();
  	}
	
	public static String setName()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter name: ");
		return input.nextLine();
	}

  	public boolean defend()
  	{
  		return Math.random() <= chanceToBlock;

  	}//end defend method
  	
  	public void specialAttack(GameCharacter opponent)
  	{
  		//System.out.println(opponent.toString());
		if(this.isAlive()) {
  		System.out.print(this.getName());
		
		
		
		Ability ability = this.getAbility();
		
		//System.out.println(ability);
		ability.doAbility(opponent);
		
	}
  	}

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
  	
  	public boolean canWin() {
  		if((pillar1 + pillar2 + pillar3 + pillar4) == 4) {
  			return true;
  		}
  		else return false;
  	}

	/*public void battleChoices(GameCharacter opponent)
	{
	    numTurns = super.getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices*/

}//end Hero class