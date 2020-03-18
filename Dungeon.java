import java.util.*;

public class Dungeon
{
	private int PlocX, PlocY;
	
	private int maxX, maxY;
	
	//private int entranceX, entranceY;
	//private int exitX, exitY;
	
	//private Room entrance = new Room();
	//private Room exit = new Room();
	
	private Ability[] flyweight;
	
	private CharacterFactory heroFactory;
	private CharacterFactory monsterFactory;
	
	
	private Room[][] dungeon;
	
	public Dungeon(int dimensionX, int dimensionY)
	{
		this.maxX = dimensionX;
		this.maxY = dimensionY;
		
		dungeon = new Room[dimensionX][dimensionY];
		this.flyweight = new Ability[5];
		
		this.flyweight[0] = new CrushingBlow();
		this.flyweight[1] = new RegularAttack();
		this.flyweight[2] = new Heal();
		this.flyweight[3] = new SurpriseAttack();
		
		this.monsterFactory = new MonsterFactory(flyweight);
		this.heroFactory = (CharacterFactory) new HeroFactory(flyweight);
		
		//dungeon[0][0] = new RegularRoom((MonsterFactory) monsterFactory, true, false, false, true);
		
		int startX = getRandomX(maxX);
		int startY = getRandomY(maxY);
		PlocX = startX;
		PlocY = startY;
		
		dungeon[startX][startY] = new EntranceRoom(true, true, true, true);
		dungeon[2][4] = new ExitRoom(true, true, true, true);
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
		//dungeon[0][0] = new AbstractionPillarRoom((MonsterFactory) monsterFactory,true,true,true,true);
		generateDungeon();
		
		
		Room tempRoom = dungeon[startX][startY];
		boolean tempN = tempRoom.north;
		boolean tempS = tempRoom.south;
		boolean tempE = tempRoom.east;
		boolean tempW = tempRoom.west;
		
		dungeon[startX][startY] = new EntranceRoom(tempN,tempS,tempE,tempW);
		
		borderiseDungeon();
	}//end Dungeon
	
	public String toString()
	{
		String roomStats = "Size of dungeon is " +  this.maxX + " " + this.maxY;
		return roomStats;
		
	}//end toString
	
	public void generateDungeon()
	{
		for(int i = 0; i < maxX; i ++)
		{
			for(int j = 0; j < maxY; j ++)
			{
				if(dungeon[i][j] == null)
				{
					dungeon[i][j] = new RegularRoom((MonsterFactory) monsterFactory, true, true, true, true);
				}
			}
		}
		
	}//end generateDungeon
	
	public int getPlocX()
	{
		return this.PlocX;
		
	}//end getPlocX
	
	public int getPlocY()
	{
		return this.PlocY;
		
	}//end getPlocY
	
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
		
		System.out.println("Player is at [" + PlocX + "]" + "[" + PlocY + "]");
		printRoom(PlocX, PlocY);
		
		while(true)
		{
			System.out.println("Please enter a direction to move... w a s d");
			direction = input.next();
			if(direction.equals("s"))
			{
				if(PlocY < this.maxX-1)
					this.PlocY ++;
			}
		
			if(direction.equals("w"))
			{
				if(PlocY > 0)
					this.PlocY --;
			}
			if(direction.equals("a"))
			{
				if(PlocX > 0)
					this.PlocX --;
			}
				if(direction.equals("d"))
				{
					if(PlocX < this.maxX -1)
						this.PlocX ++;
				}
				
				System.out.println("Player is at [" + PlocX + "]" + "[" + PlocY + "]");
				printRoom(PlocX, PlocY);
		}
		
	}//end traverseDungeon
	
	public void printPosition()
	{
		System.out.println(PlocX + " " + PlocY);
		
	}//end printPosition
	
	public void printRoom(int x, int y)
	{
		System.out.println(dungeon[x][y].toString());
		System.out.println(dungeon[x][y].roomStats());
		
	}//end printRoom
	
	public void borderiseDungeon()
	{
		for(int i = 0; i < this.maxX; i ++)
		{
		
			for(int j = 0; j < this.maxY; j++)
			{
				if(i == 0)
				{
					dungeon[0][j].west = false;
				}
				if(i == this.maxX -1 )
				{
					dungeon[maxY-1][j].east = false;
				}
				if(j == 0)
				{
					dungeon[i][j].north = false;
				}
				if(j == this.maxY - 1)
				{
					dungeon[i][j].south = false;  
				}
			}
			
		}
		
	}//end borderiseDungeon
	
	public void activateVision()
	{
		printRoom(PlocX-1,PlocY-1);
		
	}//end activateVision
	
	public Room[][] getDungeon() 
	{
		return dungeon;
		
	}//end getDungeon
	
}