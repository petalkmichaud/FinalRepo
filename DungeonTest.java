
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DungeonTest {
	Hero hero;
	Monster monster;
	MonsterFactory monsterFactory;
	@BeforeEach
	void setup() {
		Ability[] abilites = new Ability[6];
		abilites[0] = new RegularAttack();
		abilites[3] = new SurpriseAttack();
		abilites[2] = new Heal();
		abilites[1] = new CrushingBlow();
		abilites[4] = new LightningBolt();
		abilites[5] = new SteadyShot();
		
		hero = new Warrior(abilites);
		monster = new Ogre(abilites);
		monsterFactory = new MonsterFactory(abilites);
		
		
	}
	
	@Test
	void AbilityTest() {
		Ability crushingBlow = new CrushingBlow();
		assertEquals(" uses the special attack crushing blow", crushingBlow.getDisplay());
		hero.attack(monster);
		
	}
	@Test
	void DungeonTests() {
		Dungeon dungeon = new Dungeon(5,5);
		
		
		if(dungeon.getDungeon()[0][0] instanceof Room) {
			//pass
		}
		else {
			fail("Not a room");
		}
		
		
		
	}
	@Test 
	void RoomTests(){
		Room room = new RegularRoom(monsterFactory, true, true, true, true);
		assertFalse(room.isExit());
		Room exitRoom = new ExitRoom(true,true,true,true);
		assertTrue(exitRoom.isExit());
		Room entranceRoom = new EntranceRoom(true,true,true,true);
		assertTrue(entranceRoom.isEntrance());
		
		Monster monsterRoom = (Monster) room.generateMonster();
		
		if(monsterRoom instanceof Monster) {
			//passed
		}
		else {
			fail("Not a monster");
		}
		
		String roomString = "";
		roomString += "*-*\n";
		roomString += "|I|\n";
		roomString += "*-*";
		assertEquals(roomString, entranceRoom.toString());
		assertEquals("This is the Entrance...", entranceRoom.roomStats());	
	}
	@Test
	void characterTests() {
		hero.subtractHitPoints(50);//hero may block the damage... so may fail test
		assertEquals(75, hero.getHitPoints());
		hero.attack(monster);
		if(monster.getHitPoints() < 200) {
			//
		}
		else fail("monster not damaged");
		
		
	}
	
}
