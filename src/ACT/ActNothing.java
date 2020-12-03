package ACT;

/**
 * This functionality is for objects that have no runtime functionality
 * @author khaled
 *
 */
public class ActNothing implements Act {

	@Override
	public void act(Actor actor, long now) {
		// does nothing
		
	}

	@Override
	public void restrictmovement(Actor actor) {
		// nothing
		
	}



}
