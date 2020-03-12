
public class Tester {
	public static void main(String args[]) {
		
		//Abilites
		Attack[] flyweight = new Attack[5];
		flyweight[0] = new RegularAttack();
		flyweight[1] = new CrushsingBlow();
		
		
		DungeonCharacter ranger = new Ranger(flyweight);
		DungeonCharacter ranger2 = new Ranger(flyweight);
		DungeonCharacter range3 = new Ranger(flyweight);
		DungeonCharacter ranger4 = new Ranger(flyweight);
		
		
		
		
		
		
	}
}
