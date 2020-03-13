
<<<<<<< HEAD
public class CrushsingBlow implements Ability {
	private int damage = 150;
	private double chanceToHit = .2;
=======
public class CrushsingBlow implements Attack {
	
>>>>>>> 8cba00e4a3c5bc9143e4bc2b89f5cd9ec63f2269
	public String getDisplay() {
		return " uses the special aattack crushing blow";
	}

	@Override
	public void doAbility(DungeonCharacter opponent) {
<<<<<<< HEAD
		
		
		if(Math.random() >= chanceToHit) {
			System.out.println("has used CRUSHING BLOW on " + opponent.getName());
			opponent.subtractHitPoints(damage);
		}
		else {
			System.out.println(" MISSED crushing blow..");
		}
		
=======
		// TODO Auto-generated method stub
>>>>>>> 8cba00e4a3c5bc9143e4bc2b89f5cd9ec63f2269
		
	}
}
