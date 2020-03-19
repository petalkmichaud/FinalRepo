
public abstract class Room
{
	
	protected boolean north,south,east,west;
	
	protected double monsterChance;
	
	protected double roomConstant = .1;
	protected double pitChance = roomConstant;
	protected double healingPotionChance = roomConstant;
	protected double visionPotionChance = roomConstant;
	
	protected double entrance, exit;
	
	protected int monsterCount, healingPotionCount, visionPotionCount, pit;
	
	protected boolean pPillar = false, aPillar = false, ePillar = false, iPillar = false;
	
	MonsterFactory monsterFactory;
	GameCharacter monsterC;
	

		public Room(MonsterFactory monsterFactory, boolean north, boolean south, boolean east, boolean west)
		{	
			this.east = east;
			this.west = west;
			this.north = north;
			this.south = south;
			
			this.monsterFactory = monsterFactory;
			
			this.pit = getPit();
			this.healingPotionCount = getHealingPotion();
			this.visionPotionCount = getVisionPotion();
			
		}
		
		public GameCharacter generateMonster()
		{
			Monster monster = null;
			
			double randomNum = Math.random();
			
			if(randomNum < 0) {
				randomNum *= -1;
			}
			
			if(randomNum >=0 && randomNum <.2) {
				monster = (Monster) this.monsterFactory.createDrake();
			}
			
			else if(randomNum >=.2 && randomNum < .4) {
				monster = (Monster) this.monsterFactory.createOgre();
			}
			
			else if(randomNum >= .4 && randomNum <.6) {
				monster = (Monster) this.monsterFactory.createGremlin();
			}
			
			else if(randomNum >= .6 && randomNum < .8) {
				monster = (Monster)this.monsterFactory.createSkeleton();
			}
			else if(randomNum >= .8 && randomNum <=1) {
				monster = (Monster)this.monsterFactory.createMindFlayer();
			}
			else {
				//default monster
				monster = (Monster) this.monsterFactory.createOgre();
			
			}
			
			return (Monster) monster;
			
		}
		
		private int getPit()
		{
			
			int pit = 0;
			
			
			if(this.pitChance >= Math.random()) {
				pit = 1;
			}
			return pit;
			
			
		}
		
		private int getHealingPotion()
		{
			int healPotion = 0;
			
			if(this.healingPotionChance >= Math.random()) {
				healPotion = 1;
			}
			return healPotion;
		}
		
		private int getVisionPotion()
		{
			int visionPotion = 0;
			
			if(this.healingPotionChance >= Math.random()) {
				visionPotion = 1;
			}
			return visionPotion;
		}
		
		public boolean isPPillarRoom()
		{
			if(this.pPillar == true)
				return true;
			else
				return false;
			
		}//end isPPillarRoom
		
		public boolean isAPillarRoom()
		{
			if(this.aPillar == true)
				return true;
			else
				return false;
			
		}//end isAPillarRoom
		
		public boolean isEPillarRoom()
		{
			if(this.ePillar == true)
				return true;
			else
				return false;
			
		}//end isEPillarRoom
		
		public boolean isIPillarRoom()
		{
			if(this.iPillar == true)
				return true;
			else
				return false;
			
		}//end isIPillarRoom
		
		public boolean isEntrance()
		{
			
			if(this.entrance > 0)
				return true;
			else
				return false;
			
		}//end isEntrance
		
		public boolean isExit()
		{
			if(this.exit > 0)
				return true;
			else
				return false;
			
		}//end isExit
		
		public String toString()
		{
			String room = "";
			if(this.north == false) {
				room = room + "***";
			}
			else {
				room = room + "*-*";
			}
			
			room = room + "\n";
			if(this.west == false) {
				room = room + "*";
			}
			else {
				room = room + "|";
			}
			
			if((monsterCount + pit + healingPotionCount + visionPotionCount) == 0) {
				
				if(this.isExit())
					room = room + "O";
				
				else if(this.isEntrance())
					room = room + "I";
				
				else if(this.isAPillarRoom() || this.isPPillarRoom() ||
						this.isEPillarRoom() || this.isIPillarRoom())
					room = room + "P";
				
				else
					room = room + "E";
				
				
				
			}
			else if((monsterCount + pit + healingPotionCount + visionPotionCount) > 1) {
				room = room + "M";
			}
			else if(pit == 1) {
				room = room + "P";
			}
			
			
			else if(healingPotionCount >= 1) {
				room = room + "H";
			}
			else if(visionPotionCount >= 1) {
				room = room + "V";
			}
			else if(monsterCount >= 1) {
				room = room + "X";
			}
			else {
				room = room + " ";
			}
			if(this.east == false) {
				room = room + "*";
			}
			else {
				room = room + "|";
			}
			room = room + "\n";
			
			if(this.south == false) {
				room = room + "***";
			}
			else {
				room = room + "*-*\n";
			}
			return room;
		}
		public String roomStats() {
			
			String roomStats =  "Here are the stats for this room:";
			roomStats += "\nHealing Potion: " +  healingPotionCount;
			roomStats += "\nIs a pit: ";
			if(pit > 0) {
				roomStats += "True";
			}
			else {
				roomStats += "False";
			}
			roomStats += "\nVision Postion: " + visionPotionCount;
			
			roomStats += "\nContains a monster: ";
			
			if(monsterCount > 0) {
				roomStats += "True: " + monsterC.getName();
				roomStats += "\n" +  this.monsterCount;

			}
			else {
				roomStats+= "False";
			}
			return roomStats;
		}
	
		
	
		
}
