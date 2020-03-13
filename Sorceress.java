
public class Sorceress extends Hero{
	
	public Sorceress(Ability[] flyweightRef) {
		super(flyweightRef, 75, "Sorceress", 25, 50, 5, .7, .3);
		this.ability = this.flyweightReference[2];
		
	}
	

}
