
import java.util.*;

public class Dungeon
{
	//Player Location
	int PlocX, PlocY;
	
	//dungeon dimensions
	int maxX, maxY;
	
	Ability[] flyweight;
	
	CharacterFactory heroFactory;
	CharacterFactory monsterFactory;
	
	private Room[][] dungeon;

	protected GameCharacter hero;
	protected int healPotions;
	protected int visionPotions;
	
	public Dungeon(int dimensionX, int dimensionY)
	{
		this.maxX = dimensionX;
		this.maxY = dimensionY;
		
		
		this.dungeon = new Room[dimensionX][dimensionY];
		this.flyweight = new Ability[5];
		
		
		this.flyweight[0] = new CrushsingBlow();
		this.flyweight[1] = new RegularAttack();
		this.flyweight[2] = new Heal();
		this.flyweight[3] = new SurpriseAttack();
		
		this.monsterFactory = new MonsterFactory(flyweight);
		
		this.heroFactory = (CharacterFactory) new HeroFactory(flyweight);
		
		
		
	//	dungeon[0][0] = new RegularRoom((MonsterFactory) monsterFactory, true, false, false, true);
		
		int startX = getRandomX(maxX);
		int startY = getRandomY(maxY);
		this.PlocX = startX;
		this.PlocY = startY;
		
		//hardcoded doors
		
		dungeon[startX][startY] = new EntranceRoom(true, true, true, true);
		dungeon[2][4] = new ExitRoom(false, false, true, false);
		dungeon[0][0] = new RegularRoom((MonsterFactory) monsterFactory,false,false,true,false);
		dungeon[1][0] = new RegularRoom((MonsterFactory) monsterFactory,false,true,false,true);
		dungeon[2][0] = new RegularRoom((MonsterFactory) monsterFactory,false,true,true,false);
		dungeon[3][0] = new RegularRoom((MonsterFactory) monsterFactory,false,true,true,true);
		dungeon[4][0] = new RegularRoom((MonsterFactory) monsterFactory,false,false,false,true);
		dungeon[0][1] = new RegularRoom((MonsterFactory) monsterFactory,false,false,true,false);
		dungeon[1][1] = new RegularRoom((MonsterFactory) monsterFactory,true,false,true,true);
		dungeon[2][1] = new RegularRoom((MonsterFactory) monsterFactory,true,true,false,true);
		dungeon[3][1] = new RegularRoom((MonsterFactory) monsterFactory,true,false,true,false);
		dungeon[4][1] = new RegularRoom((MonsterFactory) monsterFactory,false,true,false,true);
		dungeon[0][2] = new RegularRoom((MonsterFactory) monsterFactory,false,true,false,false);
		dungeon[1][2] = new RegularRoom((MonsterFactory) monsterFactory,false,true,false,false);
		dungeon[2][2] = new RegularRoom((MonsterFactory) monsterFactory,true,true,false,false);
		dungeon[3][2] = new RegularRoom((MonsterFactory) monsterFactory,false,true,true,false);
		dungeon[4][2] = new RegularRoom((MonsterFactory) monsterFactory,true,true,false,true);
		dungeon[0][3] = new RegularRoom((MonsterFactory) monsterFactory,true,true,true,false);
		dungeon[1][3] = new RegularRoom((MonsterFactory) monsterFactory,true,true,true,true);
		dungeon[2][3] = new RegularRoom((MonsterFactory) monsterFactory,true,false,true,true);
		dungeon[3][3] = new RegularRoom((MonsterFactory) monsterFactory,true,false,false,true);
		dungeon[4][3] = new RegularRoom((MonsterFactory) monsterFactory,true,true,false,false);
		dungeon[0][4] = new RegularRoom((MonsterFactory) monsterFactory,true,false,false,false);
		dungeon[1][4] = new RegularRoom((MonsterFactory) monsterFactory,true,false,false,false);
		dungeon[3][4] = new RegularRoom((MonsterFactory) monsterFactory,false,false,true,true);
		dungeon[4][4] = new RegularRoom((MonsterFactory) monsterFactory,true,false,false,true);
		
		Room tempRoom = dungeon[startX][startY];
		boolean tempN = tempRoom.north;
		boolean tempS = tempRoom.south;
		boolean tempE = tempRoom.east;
		boolean tempW = tempRoom.west;
		
		this.dungeon[startX][startY] = new EntranceRoom(tempN,tempS,tempE,tempW);
		
		borderiseDungeon();
	}
	
	public void setDungeonHero(GameCharacter hero)
	{
		this.hero = hero;
		
	}//end setDungeonHero
	
	@Override
	public String toString() {
		String roomStats = "Size of dungeon is " +  this.maxX + " " + this.maxY;
		
		return roomStats;
		
	}
	
	public void generateDungeon()
	{
		for(int i = 0; i < this.maxX; i ++)
		{
			for(int j = 0; j < this.maxY; j ++)
			{
				if(this.dungeon[i][j] == null)
				{
					this.dungeon[i][j] = new RegularRoom((MonsterFactory) this.monsterFactory, true, true, true, true);
				}
			}
		}
		borderiseDungeon();
				
	}//end generateDungeon
	
	public int getRandomX(int max)
	{

		Random r = new Random();
		
		int x = r.nextInt((max - 0) + 1);
		
		x = x -1;
		
		if(x < 0)
			x = x * -1;

		return x;
		
	}//end getRandomX
	
	public int getRandomY(int max)
	{
		Random r = new Random();
		
		int y = r.nextInt((max - 0) + 1);
		y --;
		
		if(y < 0)
			y  = y * -1;

		return y;
		
	}//end getRandomY

	
	public void traverseDungeon()
	{
		Scanner input = new Scanner(System.in);
		
		String direction;
		
		System.out.println("\nPlease enter a direction to move... w a s d (Then press enter)");
		direction = input.next();
		
		if(direction.equals("s"))
		{
			if(this.PlocY < this.maxX-1)
			{
				if(this.dungeon[PlocX][PlocY].south == true && (this.dungeon[PlocX][PlocY + 1].north == true))
					this.PlocY ++;
			}
		}
		
		if(direction.equals("w"))
		{
			if(this.PlocY > 0)
			{
				if(this.dungeon[PlocX][PlocY].north == true && (this.dungeon[PlocX][PlocY -1].south == true))
					this.PlocY --;
			}
		}
		
		if(direction.equals("a"))
		{
			if(this.PlocX > 0)
			{
				if(this.dungeon[PlocX][PlocY].west == true && (this.dungeon[PlocX-1][PlocY].east == true))
					this.PlocX --;
			}
		}
		
		if(direction.equals("d"))
		{
			if(this.PlocX < this.maxX -1)
			{
				if(this.dungeon[PlocX][PlocY].east == true && (this.dungeon[PlocX+1][PlocY].west == true))
					this.PlocX ++;
			}
		}
		
		if(direction.equals("h"))
		{
			if(this.healPotions > 0)
			{
				System.out.println("You use the healing potion and heal 45 hit points");
				this.hero.addHitPoints(45);
				System.out.println("Your total hitpoints are now " + this.hero.getHitPoints());
				this.healPotions --;
			}
		}
		
		if(direction.equals("v"))
		{
			if(this.visionPotions > 0)
			{
				System.out.println("You use the visiong potion and can see all adjacent rooms for one turn");
			}
		}
		
		if(direction.equals("m")) //Not Correct
		{
			System.out.print(dungeon[this.PlocX - 1][this.PlocY + 1].toString() +
					dungeon[this.PlocX][this.PlocY + 1].toString() + dungeon[this.PlocX + 1][this.PlocY + 1].toString());
			System.out.print(dungeon[this.PlocX - 1][this.PlocY].toString() + 
					dungeon[this.PlocX][this.PlocY].toString() + dungeon[this.PlocX + 1][this.PlocY].toString());
			System.out.print(dungeon[this.PlocX - 1][this.PlocY - 1].toString() +
					dungeon[this.PlocX][this.PlocY - 1].toString() + dungeon[this.PlocX + 1][this.PlocY - 1].toString());
		}
		
		System.out.println("Player is at [" + PlocX + "]" + "[" + PlocY + "]");
		
	}//end traverseDungeon
	
	public void useHealPotion(GameCharacter hero)
	{
		System.out.println("You drink the healing potion");
		hero.addHitPoints(45);
		
	}//end useHealPotion
		
	public void useVisionPotion(GameCharacter hero)
	{
		
	}//end useVisionPotion?
		
	//}
	public void printPosition()
	{
		System.out.println(this.PlocX + " " + this.PlocY);
		
	}//end printPosition
	
	public void printRoom(int x, int y)
	{
		System.out.print(this.dungeon[x][y].toString());
		
	}//end printRoom
	
	public void borderiseDungeon()
	{
		for(int i = 0; i < this.maxX; i ++)
		{
			for(int j = 0; j < this.maxY; j++)
			{
				if(i == 0)
					this.dungeon[0][j].west = false;
				
				if(i == this.maxX -1 )
					this.dungeon[maxY-1][j].east = false;
				
				if(j == 0)
					this.dungeon[i][j].north = false;
				
				if(j == this.maxY - 1)
					this.dungeon[i][j].south = false;  
				
			}
		}
		
	}//end borderiseDungeon

	public Room[][] getDungeon()
	{
		return this.dungeon;
		
	}//end getDungeon
	
}//end class
	
