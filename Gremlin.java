public class Gremlin extends Monster
{

    public Gremlin(Ability[] flyweightRef)
	{
		super(flyweightRef, "Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);

    }//end constructor

	public void attack(GameCharacter opponent)
	{
		System.out.println(super.getName() + " jabs his kris at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end class Gremlin