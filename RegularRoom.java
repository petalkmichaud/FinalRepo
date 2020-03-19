
public class RegularRoom extends Room{

	public RegularRoom(MonsterFactory monsterFactory, boolean north, boolean south, boolean east, boolean west) {
		super(monsterFactory, north, south, east, west);
		this.monsterChance = 0;
	//	System.out.println(monsterChance);
		
		double randomNum = Math.random();
		if(randomNum < 0) {
			randomNum *= -1;
		}
		if(this.monsterChance > randomNum) {
			this.monsterCount = 1;
			this.monsterC = this.generateMonster();
		}
		
	}
	

}
