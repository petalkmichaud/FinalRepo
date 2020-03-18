
public abstract class GameCharacter
{
	private Ability[] flyweightReference;
	private Ability regularAttack;
	protected Ability ability; //Maybe make this private later?
	private String name;
	private int hitPoints;
	private int attackSpeed;
	private double chanceToHit;
	private int damageMin, damageMax;

	public GameCharacter(Ability[] flyweightRef, String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax)
	{
		this.flyweightReference = flyweightRef;
		this.regularAttack = flyweightReference[1];
		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;

	}//end constructor
	
	public Ability[] getFlyweightReference()
	{
		return flyweightReference;
		
	}//end getFlyweightReference

	public String getName()
	{
		return this.name;
		
	}//end getName

	public int getHitPoints()
	{
		return this.hitPoints;
		
	}//end getHitPoints
	
	public int getAttackSpeed()
	{
		return this.attackSpeed;
		
	}//end getAttackSpeed
	
	public double getChanceToHit()
	{
		return this.chanceToHit;
		
	}//end getChanceToHit
	
	public int getDamageMin()
	{
		return this.damageMin;
		
	}//end getDamageMin
	
	public int getDamageMax()
	{
		return this.damageMax;
		
	}//end getDamageMax

	public void addHitPoints(int hitPoints)
	{
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		else
		{
			this.hitPoints += hitPoints;
			//System.out.println("Remaining Hit Points: " + hitPoints);

		}
	}//end addHitPoints method

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


	}//end method

    public boolean isAlive()
	{
	  return (hitPoints > 0);
	}//end isAlive method

    public void attack(GameCharacter opponent)
    {
		boolean canAttack;
		int damage;
		canAttack = Math.random() <= chanceToHit;
		
		if (canAttack) {
			damage = (int)(Math.random() * (damageMax - damageMin + 1)) + damageMin ;
			opponent.subtractHitPoints(damage);
			System.out.println();
		}
		else{
			System.out.println(getName() + "'s attack on " + opponent.getName() + " failed!");
			System.out.println();
		}//end else

	}//end attack method
    
    public String getAbilityName()
    {
    	return ability.getDisplay();
    	
    }//end getAbilityName
    
    public abstract void specialAttack(GameCharacter opponent);
}