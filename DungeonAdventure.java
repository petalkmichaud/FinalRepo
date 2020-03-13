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
		
		Scanner in = new Scanner(System.in);
		int choice = 0;
		
		//Create a dungeon object here
		
		System.out.println("Please select your Hero from this list of options!");
		System.out.println("1) Warrior: The strong fighter!");
		System.out.println("2) Thief: The sneaky pickpocket!");
		System.out.println("3) Cleric: The divine healer!");
		System.out.println("4) Ranger: The cautious woodsman!");
		System.out.println("5) Sorceress: The destructive spellcaster! \n");
		
		switch(choice)
		{
			case 1: //Create hero object of type Warrior
			
			case 2: //Create hero object of type Thief
			
			case 3: //Create hero object of type Cleric
			
			case 4: //Create hero object of type Ranger
			
			case 5: //Create hero object of type Sorceress
		}
		
		/*Probably from Dungeon class, we need options to detect player action choices.
		 * Such as moving and using a potion. This will be looped until the hero dies.*/
		
		/*At the end, we need to display the entire Dungeon to the screen.
		 * We also need a secret menu option that will allow us to see it all before game end.*/
		
	}//end main
	
}//end class