import java.util.Scanner;

public class Ranger extends Hero {
	public Ranger(Ability[] flyweightRef) {
		super(flyweightRef, 200, "Ranger", 10, 30, 4, .5, 0.3);
		this.ability = this.flyweightReference[0];
	}
	
}
