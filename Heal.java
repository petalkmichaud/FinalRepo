
public class Heal implements Ability
{
	public String getDisplay()
	{
		return null;
	}
	
	public void doAbility(GameCharacter thisCharacter)
	{
		if(thisCharacter instanceof Hero)
		{
			Hero thisHero =  (Hero)thisCharacter;
			int hPoints;
			final int MIN_ADD = 25; 
			final int MAX_ADD = 50;
			
			hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
			thisHero.addHitPoints(hPoints);
			System.out.println(" added [" + hPoints + "] points.\n"
								+ "Total hit points remaining are: "
								+ thisHero.hitPoints);
			 System.out.println();
		}
		else
		{
			Monster thisMonster = (Monster)thisCharacter;
			boolean canHeal;
			int healPoints;

			canHeal = (Math.random() <= thisMonster.chanceToHeal) && (thisMonster.hitPoints > 0);

			if (canHeal)
			{
				healPoints = (int)(Math.random() * (thisMonster.maxHeal - thisMonster.minHeal + 1)) + thisMonster.minHeal;
				thisMonster.addHitPoints(healPoints);
				System.out.println(" healed itself for " + healPoints + " points.\n"
									+ "Total hit points remaining are: " + thisMonster.hitPoints);
				System.out.println();
			}
			else {
				System.out.println( " could not heal this round.");
			}
		}
}
