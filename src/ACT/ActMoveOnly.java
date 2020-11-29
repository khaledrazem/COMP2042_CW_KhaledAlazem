package ACT;

public class ActMoveOnly implements Act {
	
	Actor actor;

	@Override
	public void act(Actor actor,long now) {
		actor.move(actor.speed , 0);
		this.actor=actor;
		restrictmovement();

	}

	@Override
	public void restrictmovement() {
		if (actor.getX()>600 && actor.speed>0)
			actor.setX(-180);
		if (actor.getX()<-300 && actor.speed<0)
			actor.setX(700);
		
	}

}
