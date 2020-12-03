package ACT;

/**
 * This functionality is for objects that need only movement functionality
 * @author khaled
 *
 */
public class ActMoveOnly implements Act {
	@Override
	public void act(Actor actor,long now) {
		actor.move(actor.speed , 0);
		restrictmovement(actor);

	}

	
	@Override
	public void restrictmovement(Actor actor) {
		if (actor.getX()>600 && actor.speed>0)
			actor.setX(-200);
		if (actor.getX()<-100 && actor.speed<0)
			actor.setX(800);
	}

}
