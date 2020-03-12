
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
	
	
	
}
