
public class Ogre extends Monster{
	public Ogre(Ability[] flyweightRef) {
		super(flyweightRef, 200, "Ogre", 30, 50, 2, .6, .2, 30, 50);
		this.ability = flyweightRef[2];
		
	}

	

}
