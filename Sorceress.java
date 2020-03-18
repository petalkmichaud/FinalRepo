public class Sorceress extends Hero
{
	/*public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;*/
	
    public Sorceress(Ability[] flyweightRef)
	{
		super(flyweightRef, "Sorceress", 75, 5, .7, 25, 50, .3);
		this.setAbility(flyweightRef[2]);
		
    }//end constructor

}//end class