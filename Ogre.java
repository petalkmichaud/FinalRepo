
public class Ogre extends Monster{
<<<<<<< HEAD
	public Ogre(Ability[] flyweightRef) {
		super(flyweightRef, 200, "Ogre", 30, 50, 2, .6, .2, 30, 50);
		this.ability = flyweightRef[2];
		
	}

	

=======
	public Ogre(Attack[] flyweightRef){
		super(flyweightRef);
	}

	@Override
	public void attack(DungeonCharacter opponent) {
		this.attack.doAbility(opponent);
		
	}

	@Override
	public void specialAttack() {
		// TODO Auto-generated method stub
		
	}
>>>>>>> 8cba00e4a3c5bc9143e4bc2b89f5cd9ec63f2269
}
