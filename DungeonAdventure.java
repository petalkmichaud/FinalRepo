import java.util.Scanner;

public class DungeonAdventure {
	public static void main(String args[]) {
		Ability[] flyweight = new Ability[5];
		Hero hero = (Hero)selectHero(flyweight);
		Dungeon dungeon = new Dungeon(5,5);
		
		while(true) {
			dungeon.traverseDungeon();
			
		}
		
		
	}
	
	public static Hero selectHero(Ability[] flyweight) {
		
		HeroFactory factory = new HeroFactory(flyweight);
		Scanner input = new Scanner(System.in);
		Hero hero;
		int selection;
		
		System.out.println("Please choose a hero: ");
		System.out.println("1: Sorceress");
		System.out.println("2: Warrior");
		System.out.println("3: Theif");
		System.out.println("4: Cleric");
		System.out.println("5: Ranger");
		
		selection = input.nextInt();
		
		if(selection == 1) {
			hero = (Hero)factory.createSorceress();
			System.out.println("You have selected Sorceress");
		}
		else if(selection == 2) {
			hero = (Hero)factory.createWarrior();
			System.out.println("You have selected Warrior");
		}
		else if(selection == 3) {
			hero = (Hero)factory.createThief();
			System.out.println("You have selected Theif");
		}
		else if(selection == 4) {
			hero = (Hero)factory.createCleric();
			System.out.println("You have selected Cleric");
		}
		else if(selection == 5) {
			hero = (Hero)factory.createRanger();
			System.out.println("You have selected Theif");
		}
		else {
			System.out.println("You did not pick a menu item, defaulting to Warrior");
			hero = (Hero)factory.createWarrior();
			
		}
		return hero;
	}
	
}
