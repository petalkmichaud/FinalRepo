<<<<<<< HEAD
import java.util.Scanner;

public abstract class Hero extends DungeonCharacter{
	protected double chanceToBlock;
	
	public Hero(Ability[] flyweightRef, int hitPoints, String name, int damageMin, int damageMax, int attackSpeed, double chanceToHit, double chanceToBlock) {
		super(flyweightRef, hitPoints, setName(), damageMin, damageMax, attackSpeed, chanceToHit);
		this.chanceToBlock = chanceToBlock;
	}

	public static String setName() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter name: ");
		return input.nextLine();
	}
	
	@Override
	public void specialAttack(DungeonCharacter opponent) {
		System.out.print(this.getName());
		this.ability.doAbility(opponent);
		
	}
	
	
	
	
}
=======

public abstract class Hero extends DungeonCharacter{
	public Hero(Attack[] flyweightRef) {
		super(flyweightRef);
	}
	

}
>>>>>>> 8cba00e4a3c5bc9143e4bc2b89f5cd9ec63f2269
