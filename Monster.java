
public abstract class Monster extends DungeonCharacter{
<<<<<<< HEAD
	protected double chanceToHeal;
	protected int healMin, healMax;
	public Monster (Ability[] flyweightRef,int hitPoints, String name, int damageMin, int damageMax, int attackSpeed, double chanceToHit
			, double chanceToHeal, int healMin, int healMax) {
		super(flyweightRef,hitPoints,  name,  damageMin,  damageMax,  attackSpeed,  chanceToHit);
		this.chanceToHeal = chanceToHeal;
		this.healMin = healMin;
		this.healMax = healMax;
	}

	@Override
	public void specialAttack(DungeonCharacter thisMonster) {
		System.out.print(this.getName());
		this.ability.doAbility((Monster)thisMonster);
		
	}
	@Override	
	public void subtractHitPoints(int hitPoints){
		super.subtractHitPoints(hitPoints);
		specialAttack(this);//heal its self
	}
	
	
=======

	public Monster(Attack[] flyeightRef) {
		super(flyeightRef);
		
	}
>>>>>>> 8cba00e4a3c5bc9143e4bc2b89f5cd9ec63f2269
	
}
