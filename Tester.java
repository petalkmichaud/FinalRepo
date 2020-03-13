
public class Tester {
	public static void main(String args[]) {
		
		//Abilites
		Ability[] flyweight = new Ability[5];
		
		flyweight[0] = new CrushsingBlow();
		flyweight[1] = new RegularAttack();
		flyweight[2] = new Heal();
		
		//DungeonCharacter ranger = new Ranger(flyweight);
		DungeonCharacter monster = new Ogre(flyweight);
		
		DungeonCharacter sorc = new Sorceress(flyweight);
		
		DungeonCharacter ranger = new Ranger(flyweight);
		//sorc.specialAttack(sorc);
		
		//
	//	monster.specialAttack(monster); //only when healing must that character pass him self in parm
		
		sorc.attack(monster);
		monster.attack(sorc);
		sorc.specialAttack(sorc);
		
	
		
		
	}
}
