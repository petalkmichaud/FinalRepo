public class Ogre extends Monster
{

    public Ogre(Ability[] flyweightRef)
	{
		super(flyweightRef, "Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);

    }//end constructor

	public void attack(GameCharacter opponent)
	{
		System.out.println(super.getName() + " slowly swings a club toward's " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack

}//end Monster class