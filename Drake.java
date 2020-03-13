public class Drake extends Monster
{

    public Drake(Ability[] flyweightRef)
	{
		super(flyweightRef, "Stu the Drake", 240, 2, .8, .4, 25, 60, 30, 50);

    }//end MindFlayer

	public void attack(GameCharacter opponent)
	{
		System.out.println(super.getName() + " loudly roars in protest at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end attack


}//end class