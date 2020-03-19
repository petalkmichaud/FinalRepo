
public abstract class CharacterFactory
{
	protected Ability[] flyweightRef;
	
	public CharacterFactory(Ability[] flyweightRef)
	{
		this.flyweightRef = flyweightRef;
		
	}//end CharacterFactory
	
}//end class
