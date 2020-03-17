//Dungeon Class
/*• Creates/contains a 5 X 5 2D Array of Rooms (you can make this larger if you wish)
• Places the Entrance, the Exit, and the Pillars of OO Pieces. NOTES: the entrance and exit
are empty rooms. The Pillar pieces cannot be at the entrance or the exit. Pillar pieces
must not occur in the same room.
• Maintains location of the Hero in the Dungeon
• Contains a toString method that builds a String containing information about the entire
dungeon.*/


import java.util.*;
public class Dungeon{
	int PlocX, PlocY;
	
	int maxX, maxY;
	
	int entranceX, entranceY;
	int exitX, exitY;
	
	//private Room entrance = new Room();
	//private Room exit = new Room();
	
	Ability[] flyweight;
	
	CharacterFactory heroFactory;
	CharacterFactory monsterFactory;
	
	
	
	private Room[][] dungeon;
	
	public Dungeon(int dimensionX, int dimensionY) {
		this.maxX = dimensionX;
		this.maxY = dimensionY;
		
		
		dungeon = new Room[dimensionX][dimensionY];
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
		PlocX = startX;
		PlocY = startY;
		
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
		
		dungeon[startX][startY] = new EntranceRoom(tempN,tempS,tempE,tempW);
		
		borderiseDungeon();
	}
	
	
	@Override
	public String toString() {
		String roomStats = "Size of dungeon is " +  this.maxX + " " + this.maxY;
		
		return roomStats;
		
	}
	
	public void generateDungeon(){
			for(int i = 0; i < maxX; i ++) {
				for(int j = 0; j < maxY; j ++) {
					if(dungeon[i][j] == null) {
						dungeon[i][j] = new RegularRoom((MonsterFactory) monsterFactory, true, true, true, true);
					}
				}
			}
			borderiseDungeon();
				
	}	

	
	
	
	public int getRandomX(int max) {

		Random r = new Random();
		
		int x = r.nextInt((max - 0) + 1);
		
		x = x -1;
		
		if(x < 0) {
		
			x = x * -1;
		}
		

		return x;
	}
	
	public int getRandomY(int max) {
		Random r = new Random();
		
		int y = r.nextInt((max - 0) + 1);
		y --;
		
		if(y < 0) {
			
			y  = y * -1;
		}
		

		return y;	
	}

	
	public void traverseDungeon() {
		Scanner input = new Scanner(System.in);
		
		String direction;
		
	//	System.out.println("Player is at [" + PlocX + "]" + "[" + PlocY + "]");
		//printRoom(PlocX, PlocY);
		//while(true) {
		System.out.println("\nPlease enter a direction to move... w a s d (Then press enter)");
		direction = input.next();
		
		if(direction.equals("s")) {
			if(PlocY < this.maxX-1) {
				if(dungeon[PlocX][PlocY].south == true && (dungeon[PlocX][PlocY + 1].north == true)) {
					this.PlocY ++;
				}
				
			}
		}
		
		if(direction.equals("w")) {
			if(PlocY > 0) {
				if(dungeon[PlocX][PlocY].north == true && (dungeon[PlocX][PlocY -1].south == true)) {
					this.PlocY --;
			}
				}
		}
		
		if(direction.equals("a")) {
			if(PlocX > 0) {
				if(dungeon[PlocX][PlocY].west == true && (dungeon[PlocX-1][PlocY].east == true)) {
					this.PlocX --;
				}
			}
		}
		if(direction.equals("d")) {
			
			if(PlocX < this.maxX -1) {
				if(dungeon[PlocX][PlocY].east == true && (dungeon[PlocX+1][PlocY].west == true)) {
					this.PlocX ++;
				}
			}
		}
		System.out.println("Player is at [" + PlocX + "]" + "[" + PlocY + "]");
		
		}
		
		
		
	//}
	public void printPosition() {
		System.out.println(PlocX + " " + PlocY);
	}
	
	public void printRoom(int x, int y) {
		System.out.print(dungeon[x][y].toString());
	//	System.out.println(dungeon[x][y].roomStats());
		
	}
	
	public void borderiseDungeon() {
		for(int i = 0; i < this.maxX; i ++) {
		
			
			for(int j = 0; j < this.maxY; j++) {
				if(i == 0) {
					dungeon[0][j].west = false;
				}
				if(i == this.maxX -1 ) {
					dungeon[maxY-1][j].east = false;
				}
				if(j == 0) {
					dungeon[i][j].north = false;
				}
				if(j == this.maxY - 1) {
					dungeon[i][j].south = false;  
				}
			}
			
		}
	}
	
	
	public void activateVision() {
		printRoom(PlocX-1,PlocY-1);
		
		
	}
	public Room[][] getDungeon() {
		return dungeon;
	}
	}
	
