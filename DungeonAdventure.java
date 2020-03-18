import java.util.Scanner;

public class DungeonAdventure
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to Dungeon Adventure!");
		System.out.println("In this game you will be given hero options and will get to name them.");
		System.out.println("Then you will get to traverse through a dungeon to find the 4 Pillars of OO and try to escape.");
		System.out.println("But be weary! There are monsters about, and you will need the help of potions to succeed.");
		System.out.println("Good luck brave adventurer! \n");
		
		Ability[] flyweight = new Ability[6];
		flyweight[0] = new RegularAttack();
		flyweight[1] = new SurpriseAttack();
		flyweight[2] = new Heal();
		flyweight[3] = new CrushingBlow();
		flyweight[4] = new SteadyShot();
		flyweight[5] = new LightningBolt();
 		Hero hero = (Hero)selectHero(flyweight);
		Dungeon dungeon = new Dungeon(5,5);
		
		
		boolean isPlaying = true;
		
		while(isPlaying) {
			boolean heroIsAlive = true;
			while(heroIsAlive) {
				int x = dungeon.getPlocX();
				int y = dungeon.getPlocY();
				
			
			//	System.out.println(dungeon.getDungeon()[x][y].roomStats());
				dungeon.printRoom(x, y);
				System.out.println();
			//	System.out.println(dungeon.getDungeon()[x][y].roomStats());;
				if(dungeon.getDungeon()[x][y].monsterCount >=1 )
				{
					System.out.println("fighting...");
					dungeon.printRoom(x, y);
					boolean won = battle(hero,dungeon.getDungeon()[x][y].monsterC);
					
					dungeon.getDungeon()[x][y].monsterCount = 0;
					heroIsAlive = won;
				}
				dungeon.traverseDungeon();
			}
			
			System.out.println("Game over you, died and were not successfull in completing the objectives \n Play Again? (y)(n)");
			Scanner input = new Scanner(System.in);
			
			if(input.next().equals("n"))
			{
				isPlaying = false;
			}
		}
		
	}//end main
	
	public static Hero selectHero(Ability[] flyweight)
	{
		HeroFactory factory = new HeroFactory(flyweight);
		Hero hero;
		Scanner in = new Scanner(System.in);
		int choice = 0;
		
		//Create a dungeon object here
		
		System.out.println("Please select your Hero from this list of options!");
		System.out.println("1) Warrior: The strong fighter!");
		System.out.println("2) Thief: The sneaky pickpocket!");
		System.out.println("3) Cleric: The divine healer!");
		System.out.println("4) Ranger: The cautious woodsman!");
		System.out.println("5) Sorceress: The destructive spellcaster! \n");
		
		choice = in.nextInt();
		
		if(choice == 1)
		{
			hero = (Hero)factory.createWarrior();
			System.out.println("You have selected Warrior");
		}
		else if(choice == 2)
		{
			hero = (Hero)factory.createThief();
			System.out.println("You have selected Thief");
		}
		else if(choice == 3)
		{
			hero = (Hero)factory.createCleric();
			System.out.println("You have selected Cleric");
		}
		else if(choice == 4)
		{
			hero = (Hero)factory.createRanger();
			System.out.println("You have selected Ranger");
		}
		else if(choice == 5)
		{
			hero = (Hero)factory.createSorceress();
			System.out.println("You have selected Sorceress");
		}
		else
		{
			System.out.println("You did not pick a menu item, defaulting to Warrior");
			hero = (Hero)factory.createWarrior();
		}
		
		return hero;
		
	}//end selectHero
	
	public static boolean battle(GameCharacter hero, GameCharacter monster)
	{
		System.out.println("\n*********PREPARE FOR BATTLE*********");
		System.out.println("You have encountred " + monster.getName());
		
		while(hero.isAlive() && monster.isAlive())
		{
			int option = battleOption(hero);
			if(option == 1)
			{
				hero.attack(monster);
			}
			else if(option == 2)
			{
				
				if(hero.getAbilityName().equals("Heal"))
				{
					hero.specialAttack(hero);
				}
				else
				{
					hero.specialAttack(monster);
				}
			}
			else
			{
				System.out.println("invalid menu choice, defaulting to attack..");
				hero.attack(monster);
			}
			monster.attack(hero);
			
		}
		return hero.isAlive();
	}//end battle
	
	public static int battleOption(GameCharacter hero)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Select a battle option:");
		System.out.println("1: Attack");
		System.out.println("2: " + hero.getAbilityName());
		int option = input.nextInt();
		return option;
	}//end battleOption
	
}//end class