
public class Tester {
	public static void main(String args[]) {
		
		
		Ability[] flyweight = new Ability[5];
		
		flyweight[0] = new CrushsingBlow();
		flyweight[1] = new RegularAttack();
		flyweight[2] = new Heal();
		flyweight[3] = new SurpriseAttack();

		GameCharacter theif = new Thief(flyweight);
		
		GameCharacter monster = new Ogre(flyweight);
		
		GameCharacter draake = new Drake(flyweight);
		
		draake.attack(monster);
		//.aeif.specialAttack(monster);
		
	}
}
