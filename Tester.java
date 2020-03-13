
public class Tester {
	public static void main(String args[]) {
		
		//Abilites
<<<<<<< HEAD
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
		
	
=======
		Attack[] flyweight = new Attack[5];
		flyweight[0] = new RegularAttack();
		flyweight[1] = new CrushsingBlow();
		
		
		DungeonCharacter ranger = new Ranger(flyweight);
		DungeonCharacter ranger2 = new Ranger(flyweight);
		DungeonCharacter range3 = new Ranger(flyweight);
		DungeonCharacter ranger4 = new Ranger(flyweight);
		
		
		
		
>>>>>>> 8cba00e4a3c5bc9143e4bc2b89f5cd9ec63f2269
		
		
	}
}
