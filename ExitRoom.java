
public class ExitRoom extends Room{

	public ExitRoom(MonsterFactory monsterFactory, boolean north, boolean south, boolean east, boolean west) {
		super(monsterFactory, north, south, east, west);
		this.healingPotionCount = 0;
		this.visionPotionCount = 0;
		this.pit = 0;
		this.exit = 1;
		this.entrance = 0;
	}

}
