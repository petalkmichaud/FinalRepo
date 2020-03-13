
public class Ranger extends Hero
{
	public Ranger(Ability[] flyweightRef)
	{
		super(flyweightRef, "Ranger", 95, 6, .85, 30, 50, .35);
		this.setAbility(flyweightRef[1]);
	
	}//end constructor
	
}//Ranger class