public class MindFlayer extends Monster
{

    public MindFlayer(Ability[] flyweightRef)
	{
		super(flyweightRef, "Tom the MindFlayer", 125, 5, .85, .3, 35, 65, 20, 40);

    }//end MindFlayer

	public void attack(GameCharacter opponent)
	{
		System.out.println(super.getName() + " waves his tentacles and psychic blasts " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end attack


}//end class