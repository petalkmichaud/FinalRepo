package dungeon;

public class Room {
	
	boolean north,south,east,west;
	double monster, pit, healingPotion, visionPotion;

		public Room(boolean north, boolean south, boolean east, boolean west)
		{
			this.monster = getMonster();
			this.pit = getPit();
			this.healingPotion = getHealingPotion();
			this.visionPotion = getVisionPotion();
			
		}
		
		public double getMonster()
		{
			return Math.random();
		}
		
		public double getPit()
		{
			return Math.random();
		}
		
		public double getHealingPotion()
		{
			return Math.random();
		}
		
		public double getVisionPotion()
		{
			return Math.random();
		}
}
