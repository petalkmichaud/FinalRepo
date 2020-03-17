
public abstract class CharacterFactory {
	Ability[] flyweightRef;
	
	CharacterFactory(Ability[] flyweightRef){
		this.flyweightRef = flyweightRef;
		
	}
}
