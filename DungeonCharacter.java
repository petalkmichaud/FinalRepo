
<<<<<<< HEAD
public abstract class DungeonCharacter  {
	Ability[] flyweightReference;
	protected Ability regularAttack;
	protected Ability ability;
=======
public abstract class DungeonCharacter {
	Attack[] flyweightReference;
	protected Attack attack;
	protected Attack ability;
>>>>>>> 8cba00e4a3c5bc9143e4bc2b89f5cd9ec63f2269
	protected String name;
	protected int hitPoints;
	protected int attackSpeed;
	protected double chanceToHit;
	protected int damageMin, damageMax;
	
	
<<<<<<< HEAD
	public DungeonCharacter(Ability[] flyweightRef,int hitPoints, String name, int damageMin, int damageMax, int attackSpeed, double chanceToHit) {
		this.flyweightReference = flyweightRef;
		this.regularAttack = flyweightReference[1];
		this.hitPoints = hitPoints;
		this.name = name;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
=======
	public DungeonCharacter(Attack[] flyweightRef) {
		this.flyweightReference = flyweightRef;
>>>>>>> 8cba00e4a3c5bc9143e4bc2b89f5cd9ec63f2269
	
	}
	
	
	
	
<<<<<<< HEAD
	
	public void attack(DungeonCharacter opponent) {
		
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
		
	
	public abstract void specialAttack(DungeonCharacter opponent);
=======
	public abstract void attack(DungeonCharacter opponent);
	
	public abstract void specialAttack();
>>>>>>> 8cba00e4a3c5bc9143e4bc2b89f5cd9ec63f2269
	
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
<<<<<<< HEAD
								"for <" + hitPoints + "> points damage.");
=======
								" for <" + hitPoints + "> points damage.");
>>>>>>> 8cba00e4a3c5bc9143e4bc2b89f5cd9ec63f2269
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
<<<<<<< HEAD
	public void addHitPoints(int hitPoints){
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		else{
			this.hitPoints += hitPoints;
		}
	}
=======
>>>>>>> 8cba00e4a3c5bc9143e4bc2b89f5cd9ec63f2269
}
