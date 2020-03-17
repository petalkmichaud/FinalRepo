
public class Heal implements Ability
{
	public String getDisplay()
	{
		return "Heal";
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
								+ thisHero.getHitPoints());
			 System.out.println();
		}
		else
		{
			
			Monster thisMonster = (Monster)thisCharacter;
			boolean canHeal;
			int healPoints;

			canHeal = (Math.random() <= thisMonster.getChanceToHeal()) && (thisMonster.getHitPoints() > 0);

			if (canHeal)
			{
				healPoints = (int)(Math.random() * (thisMonster.getMaxHeal() - thisMonster.getMinHeal() + 1)) + thisMonster.getMinHeal();
				thisMonster.addHitPoints(healPoints);
				System.out.println(" healed itself for " + healPoints + " points.\n"
									+ "Total hit points remaining are: " + thisMonster.getHitPoints());
				System.out.println();
			}
			else {
				System.out.print( " MISSED his chance to heal.");
			}
		}
	}
}
