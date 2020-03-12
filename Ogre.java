
public class Ogre extends Monster{
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
}
