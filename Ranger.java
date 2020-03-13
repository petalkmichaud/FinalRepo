<<<<<<< HEAD
import java.util.Scanner;

public class Ranger extends Hero {
	public Ranger(Ability[] flyweightRef) {
		super(flyweightRef, 200, "Ranger", 10, 30, 4, .5, 0.3);
		this.ability = this.flyweightReference[0];
	}
	
=======

public class Ranger extends Hero {
	public Ranger(Attack[] flyweightRef) {
		super(flyweightRef);
		
		this.attack = this.flyweightReference[1];
	}
	
	
	
	
	
	public void attack() {
		System.out.println("ranger" + this.attack.getDisplay());
	}

	@Override
	public void specialAttack() {
		// TODO Auto-generated method stub
		
	}
	
	
	
>>>>>>> 8cba00e4a3c5bc9143e4bc2b89f5cd9ec63f2269
}
