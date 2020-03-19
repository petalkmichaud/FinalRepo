import java.util.Scanner;

public class DungeonAdventure
{
	public static void main(String args[])
	{
		Ability[] flyweight = new Ability[5];
		flyweight[0] = new RegularAttack();
		flyweight[3] = new SurpriseAttack();
		flyweight[2] = new Heal();
		flyweight[1] = new CrushingBlow();
		
		
		
		boolean isPlaying = true;
		
		while(isPlaying)
		{
			Hero hero = (Hero)selectHero(flyweight);
			Dungeon dungeon = new Dungeon(5,5);
			
			dungeon.setDungeonHero(hero);
			
			boolean heroIsAlive = true;
			while(heroIsAlive) {
				int x = dungeon.PlocX;
				int y = dungeon.PlocY;
				
			
			//	System.out.println(dungeon.getDungeon()[x][y].roomStats());
				dungeon.printRoom(x, y);
				System.out.println();
			//	System.out.println(dungeon.getDungeon()[x][y].roomStats());;
				if(dungeon.getDungeon()[x][y].monsterCount >=1 ) {
					System.out.println("fighting...");
					dungeon.printRoom(x, y);
					boolean won = battle(hero,dungeon.getDungeon()[x][y].monsterC);
					
					dungeon.getDungeon()[x][y].monsterCount = 0;
					heroIsAlive = won;
				}
				if(dungeon.getDungeon()[x][y].healingPotionCount >=1 )
				{
					System.out.println("found a healing potion");
					dungeon.printRoom(x, y);
					
					dungeon.healPotions = dungeon.healPotions + 1;
					
					System.out.println("You now have " + dungeon.healPotions + " healing potions in your inventory");
					
					dungeon.getDungeon()[x][y].healingPotionCount = 0;
				}
				
				if(dungeon.getDungeon()[x][y].visionPotionCount >=1 )
				{
					System.out.println("found a vision potion");
					dungeon.printRoom(x, y);
					
					dungeon.visionPotions = dungeon.visionPotions + 1;
					
					System.out.println("You now have " + dungeon.visionPotions + " vision potions in your inventory");
					
					dungeon.getDungeon()[x][y].visionPotionCount = 0;
				}
				
				if(dungeon.getDungeon()[x][y].pit >= 1 )
				{
					System.out.println("fell in to a pit");
					dungeon.printRoom(x, y);
					
					hero.subtractHitPoints(15);
					
					dungeon.getDungeon()[x][y].pit = 0;
				}
				
				if(dungeon.getDungeon()[x][y].isPPillarRoom() == true)
				{
					System.out.println("You found the Pillar of Polymorphism!");
					dungeon.getDungeon()[x][y].pPillar = false;
				}
				
				if(dungeon.getDungeon()[x][y].isIPillarRoom() == true)
				{
					System.out.println("You found the Pillar of Inheritance!");
					dungeon.getDungeon()[x][y].iPillar = false;
				}
				
				if(dungeon.getDungeon()[x][y].isEPillarRoom() == true)
				{
					System.out.println("You found the Pillar of Encapsulation!");
					dungeon.getDungeon()[x][y].ePillar = false;
				}
				
				if(dungeon.getDungeon()[x][y].isAPillarRoom() == true)
				{
					System.out.println("You found the Pillar of Abstraction!");
					dungeon.getDungeon()[x][y].aPillar = false;
				}
				
				if(dungeon.getDungeon()[x][y].isExit() == true && dungeon.getDungeon()[x][y].pPillar == true &&
						dungeon.getDungeon()[x][y].ePillar == true && dungeon.getDungeon()[x][y].iPillar == true
						&& dungeon.getDungeon()[x][y].aPillar == true)
				{
					System.out.println("You have made it to the exit with all of the Pillars of OO in tow!");
					System.out.println("Congratulations, you win!");
					System.exit(0);
				}
				
				dungeon.traverseDungeon();
			}
			
			System.out.println("Game over you, died and were not successfull in completing the objectives \n Play Again? (y)(n)");
			Scanner input = new Scanner(System.in);
			if(input.next().equals("n")) {
				isPlaying = false;
			}
		}
		
		
	}//end main
	
	public static Hero selectHero(Ability[] flyweight)
	{
		
		HeroFactory factory = new HeroFactory(flyweight);
		Scanner input = new Scanner(System.in);
		Hero hero;
		int selection;
		System.out.println("Welcome to the adventure of a life time...");
		System.out.println("Here you will battle monsters and overcome obstacles to locate the pillars of OO!");
		System.out.println("Once you find the pillars, take them to the exit in order to win the game! \n\n");
		System.out.println("Please choose a hero: ");
		System.out.println("1: Sorceress");
		System.out.println("2: Warrior");
		System.out.println("3: Theif");
		System.out.println("4: Cleric");
		System.out.println("5: Ranger");
		
		selection = input.nextInt();
		
		if(selection == 1)
		{
			hero = (Hero)factory.createSorceress();
			System.out.println("You have selected Sorceress");
		}
		else if(selection == 2)
		{
			hero = (Hero)factory.createWarrior();
			System.out.println("You have selected Warrior");
		}
		else if(selection == 3)
		{
			hero = (Hero)factory.createThief();
			System.out.println("You have selected Theif");
		}
		else if(selection == 4)
		{
			hero = (Hero)factory.createCleric();
			System.out.println("You have selected Cleric");
		}
		else if(selection == 5)
		{
			hero = (Hero)factory.createRanger();
			System.out.println("You have selected Ranger");
		}
		else
		{
			System.out.println("You did not pick a menu item, defaulting to Warrior");
			hero = (Hero)factory.createWarrior();
			
		}
		System.out.println("");
		return hero;
		
	}
	
	public static boolean battle(GameCharacter hero, GameCharacter monster)
	{
		System.out.println("\n*********PREPARE FOR BATTLE*********");
		System.out.println("You have encountred " + monster.getName());
		
		while(hero.isAlive() && monster.isAlive())
		{
			int option = battleOption(hero);
			if(option == 1)
				hero.attack(monster);
			
			else if(option == 2)
			{
				
				if(hero.getAbilityName().equals("Heal"))
					hero.specialAttack(hero);
				
				else
					hero.specialAttack(monster);
			}
			else
			{
				System.out.println("invalid menu choice, defaulting to attack..");
				hero.attack(monster);
			}
			monster.attack(hero);
			
		}
		return hero.isAlive();
	}
	
	public static int battleOption(GameCharacter hero)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Select a battle option:");
		System.out.println("1: Attack");
		System.out.println("2: " + hero.getAbilityName());
		int option = input.nextInt();
		return option;
	}
}
